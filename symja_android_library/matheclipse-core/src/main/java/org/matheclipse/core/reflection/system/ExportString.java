package org.matheclipse.core.reflection.system;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import org.apfloat.Apfloat;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.ExportException;
import org.jgrapht.nio.GraphExporter;
import org.jgrapht.nio.csv.CSVExporter;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.nio.graphml.GraphMLExporter;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.interfaces.IFunctionEvaluator;
import org.matheclipse.core.expression.ApfloatNum;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.Num;
import org.matheclipse.core.expression.data.GraphExpr;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTDataset;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IStringX;
import org.matheclipse.core.io.Extension;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/** Export some data into a string representation */
public class ExportString extends AbstractEvaluator {

  /** Export an expression as ExpressionJSON */
  private static class JsonConverter {
    final ObjectMapper objectMapper = new ObjectMapper();

    public JsonConverter() {}

    /**
     * Export an expression as ExpressionJSON.
     *
     * @param arg1
     * @param writer
     * @return
     * @throws IOException
     * @throws JsonGenerationException
     * @throws JsonMappingException
     */
    private JsonNode convertJSON(IExpr arg1, StringWriter writer)
        throws IOException, JsonGenerationException, JsonMappingException {
      if (arg1.isASTOrAssociation()) {
        IAST ast = (IAST) arg1;
        ArrayNode temp = objectMapper.createArrayNode();
        temp.add(ast.head().toString());
        for (int i = 1; i < ast.size(); i++) {
          IExpr arg = ast.getRule(i);
          if (arg.isComplexNumeric()) {
            IComplexNum complexNum = (IComplexNum) arg;
            ArrayNode complexJson = objectMapper.createArrayNode();
            complexJson.add("Complex");
            complexJson.add(complexNum.reDoubleValue());
            complexJson.add(complexNum.imDoubleValue());
            temp.add(complexJson);
          } else if (arg instanceof Num) {
            temp.add(((Num) arg).doubleValue());
          } else if (arg instanceof ApfloatNum) {
            Apfloat apfloatValue = ((ApfloatNum) arg).apfloatValue();
            if (apfloatValue.precision() > 20L) {
              temp.add(apfloatValue.toString());
            } else {
              temp.add(apfloatValue.doubleValue());
            }
          } else if (arg.isNumber() || arg.isSymbol()) {
            temp.add(arg.toString());
          } else if (arg.isString()) {
            temp.add("'" + arg.toString() + "'");
          } else {
            temp.add(convertJSON(arg, writer));
          }
        }
        return temp;
        //      objectMapper.writeValue(writer, temp);
      }
      ArrayNode temp = objectMapper.createArrayNode();
      temp.add(temp.toString());
      return temp;
    }
  }

  public ExportString() {}

  @Override
  public IExpr evaluate(final IAST ast, EvalEngine engine) {
    if (Config.isFileSystemEnabled(engine)) {
      IExpr arg1 = ast.arg1();
      if (!(ast.arg2() instanceof IStringX)) {
        return F.NIL;
      }
      Extension format = Extension.exportExtension(((IStringX) ast.arg2()).toString());
      StringWriter writer = null;
      try {
        writer = new StringWriter();
        if (format.equals(Extension.JSON)) {
          if (arg1.isNumber() || arg1.isSymbol()) {
            return F.stringx(arg1.toString());
          } else if (arg1.isString()) {
            return F.stringx("'" + arg1.toString() + "'");
          }
          JsonConverter converter = new JsonConverter();
          JsonNode node = converter.convertJSON(arg1, writer);
          //          return F.stringx(node.toPrettyString());
          return F.stringx(node.toString());
        }

        if (arg1 instanceof GraphExpr) {
          graphExport(((GraphExpr<DefaultEdge>) arg1).toData(), writer, format);
          return F.stringx(writer.toString());
        }

        if (format.equals(Extension.CSV) || format.equals(Extension.TSV)) {
          if (arg1.isDataset()) {
            ((IASTDataset) arg1).csv(writer);
            return F.stringx(writer.toString());
          }
        } else if (format.equals(Extension.TABLE)) {
          int[] dims = arg1.isMatrix();
          if (dims != null) {
            for (int j = 0; j < dims[0]; j++) {
              IAST rowList = (IAST) arg1.getAt(j + 1);
              for (int i = 1; i <= dims[1]; i++) {
                if (rowList.get(i).isReal()) {
                  writer.append(rowList.get(i).toString());
                } else {
                  writer.append("\"");
                  writer.append(rowList.get(i).toString());
                  writer.append("\"");
                }
                if (i < dims[1]) {
                  writer.append(" ");
                }
              }
              writer.append("\n");
            }
            return F.stringx(writer.toString());
          } else {
            if (arg1.isList()) {}
          }
          // } else if (format.equals(Extension.DAT)) {
          // File file = new File(arg1.toString());
          // com.google.common.io.Files.write(arg2.toString(), file, Charset.defaultCharset());
          // return arg1;
          // } else if (format.equals(Extension.WXF)) {
          // File file = new File(arg1.toString());
          // byte[] bArray = WL.serialize(arg2);
          // com.google.common.io.Files.write(bArray, file);
          // return arg1;
        }

        // } catch (IOException ioe) {
        // return engine.printMessage("ExportString: " + arg1.toString() + " not found!");
      } catch (Exception ex) {
        return engine.printMessage(
            "ExportString: format: " + arg1.toString() + " - " + ex.getMessage());
      } finally {
        if (writer != null) {
          try {
            writer.close();
          } catch (IOException e) {
          }
        }
      }
    }
    return F.NIL;
  }

  private static final Function<IExpr, String> nameProvider = v -> String.valueOf(v);

  void graphExport(Graph<IExpr, DefaultEdge> g, Writer writer, Extension format)
      throws ExportException, UnsupportedEncodingException {
    switch (format) {
      case DOT:
        DOTExporter<IExpr, DefaultEdge> dotExporter =
            new DOTExporter<>(); // new IntegerComponentNameProvider<>(), null, null, null, null);
        //        dotExporter.putGraphAttribute("overlap", "false");
        //        dotExporter.putGraphAttribute("splines", "true");

        dotExporter.setGraphAttributeProvider(
            () -> {
              Map<String, Attribute> map = new LinkedHashMap<>();
              map.put("overlap", DefaultAttribute.createAttribute("false"));
              map.put("splines", DefaultAttribute.createAttribute("true"));
              return map;
            });
        return;
      case GRAPHML:
        GraphExporter<IExpr, DefaultEdge> graphMLExporter = new GraphMLExporter<>();
        graphMLExporter.exportGraph(g, writer);
        return;
      default:
    }

    // DEFAULT: return CSV file
    CSVExporter<IExpr, DefaultEdge> exporter =
        new CSVExporter<IExpr, DefaultEdge>(
            nameProvider, org.jgrapht.nio.csv.CSVFormat.EDGE_LIST, ';');
    exporter.exportGraph(g, writer);
  }

  @Override
  public int[] expectedArgSize(IAST ast) {
    return IFunctionEvaluator.ARGS_2_2;
  }
}
