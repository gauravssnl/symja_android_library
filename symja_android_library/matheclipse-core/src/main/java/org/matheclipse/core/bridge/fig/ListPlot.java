// code adapted from https://github.com/datahaki/bridge
package org.matheclipse.core.bridge.fig;

import java.awt.Color;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import org.matheclipse.core.bridge.fig.Axis.Type;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.data.ImageExpr;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IExpr;

public class ListPlot extends AbstractEvaluator {

  public ListPlot() {}

  @Override
  public IExpr evaluate(final IAST ast, EvalEngine engine) {
    if ((ast.size() == 2) && ast.arg1().isList()) {
      VisualSet visualSet = new VisualSet();
      if (listPlot(ast, visualSet)) {
        BufferedImage buffer = jFreeChartImage(visualSet);
        if (buffer != null) {
          return new ImageExpr(buffer, null);
        }
      }
    }
    return F.NIL;
  }

  /**
   * Remark: We would like to make joined property of VisualRow, but JFreeChart does not support
   * this granularity.
   * 
   * @param visualSet
   * @param joined for lines between coordinates, otherwise scattered points
   * @return
   */
  public static JFreeChart listPlot(VisualSet visualSet, boolean joined) {
    XYSeriesCollection xySeriesCollection = DatasetFactory.xySeriesCollection(visualSet);
    JFreeChart jFreeChart = joined //
        ? ChartFactory.createXYLineChart( //
            visualSet.getPlotLabel(), //
            visualSet.getAxisX().getAxisLabel(), //
            visualSet.getAxisY().getAxisLabel(), //
            xySeriesCollection, PlotOrientation.VERTICAL, //
            visualSet.hasLegend(), // legend
            false, // tooltips
            false) // urls
        : ChartFactory.createScatterPlot( //
            visualSet.getPlotLabel(), //
            visualSet.getAxisX().getAxisLabel(), //
            visualSet.getAxisY().getAxisLabel(), //
            xySeriesCollection, PlotOrientation.VERTICAL, //
            visualSet.hasLegend(), // legend
            false, // tooltips
            false); // urls
    XYPlot xyPlot = (XYPlot) jFreeChart.getPlot();
    XYItemRenderer xyItemRenderer = xyPlot.getRenderer();
    int limit = xySeriesCollection.getSeriesCount();
    for (int index = 0; index < limit; ++index) {
      VisualRow visualRow = visualSet.getVisualRow(index);
      xyItemRenderer.setSeriesPaint(index, visualRow.getColor());
      xyItemRenderer.setSeriesStroke(index, visualRow.getStroke());
    }
    // https://github.com/jfree/jfreechart/issues/301
    if (visualSet.getAxisX().getType().equals(Type.LOGARITHMIC)) {
      LogAxis logAxis = new LogAxis(visualSet.getAxisX().getAxisLabel());
      xyPlot.setDomainAxis(logAxis);
    }
    if (visualSet.getAxisY().getType().equals(Type.LOGARITHMIC)) {
      LogAxis logAxis = new LogAxis(visualSet.getAxisY().getAxisLabel());
      xyPlot.setRangeAxis(logAxis);
    }
    StaticHelper.setRange(visualSet.getAxisX(), xyPlot.getDomainAxis());
    StaticHelper.setRange(visualSet.getAxisY(), xyPlot.getRangeAxis());
    return jFreeChart;
  }

  /**
   * Mathematica's default is to draw data points as separate dots, i.e. "Joined->False".
   * 
   * Tested with up to 10 million points - a little slow but possible.
   * 
   * @param visualSet
   * @return
   */
  public static JFreeChart listPlot(VisualSet visualSet) {
    return listPlot(visualSet, false);
  }

  public static boolean listPlot(final IAST ast, VisualSet visualSet) {
    IASTAppendable[] pointSets =
        org.matheclipse.core.reflection.system.ListPlot.pointsOfListPlot(ast);
    if (pointSets != null) {
      for (int i = 0; i < pointSets.length; i++) {
        IASTAppendable points = pointSets[i];
        if (points.isPresent()) {
          visualSet.add(points);
        }
      }
      return true;
    }
    return false;
  }

  protected BufferedImage jFreeChartImage(VisualSet visualSet) {
    JFreeChart jFreeChart = listPlot(visualSet, false);
    jFreeChart.setBackgroundPaint(Color.WHITE);
    return jFreeChart.createBufferedImage(600, 480);
  }

}