package org.matheclipse.core.reflection.system;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.graphics.GraphicsOptions;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public class ListLogLogPlot extends ListPlot {
  @Override
  public IExpr evaluate(final IAST ast, EvalEngine engine) {
    GraphicsOptions graphicsOptions = new GraphicsOptions(engine);
    graphicsOptions.setXFunction(x -> F.Log(x));
    graphicsOptions.setYFunction(y -> F.Log(y));
    graphicsOptions.setXScale("Log10");
    graphicsOptions.setYScale("Log10");
    IAST graphicsPrimitives = listPlot(ast, graphicsOptions, engine);
    if (graphicsPrimitives.isPresent()) {
      graphicsOptions.addPadding();
      IAST listOfOptions = F.List(//
          F.Rule(S.$Scaling, //
              F.List(F.stringx("Log10"), F.stringx("Log10"))), //
          F.Rule(S.Axes, S.True), //
          graphicsOptions.plotRange());
      return createGraphicsFunction(graphicsPrimitives, listOfOptions, graphicsOptions);
    }

    return F.NIL;
  }
}
