package org.matheclipse.core.bridge.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.matheclipse.core.bridge.fig.VisualImage;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.reflection.system.ArrayPlot;
import org.matheclipse.core.tensor.ext.HomeDirectory;
import org.matheclipse.core.tensor.img.ColorDataGradients;
import org.matheclipse.core.tensor.img.ImageFormat;

class ArrayPlotTest {
  public static void main(String[] args) throws IOException {
    IAST raw = F.List(//
        F.List(1, 0, 0, 0.3), //
        F.List(1, 1, 0, 0.3), //
        F.List(1, 0, 1, 0.7));
    // IAST raw = (IAST) S.RandomReal.of(EvalEngine.get(), F.C1, F.List(10, 20));
    // IAST raw = (IAST) S.RandomVariate.of(EvalEngine.get(),
    // F.UniformDistribution(F.List(F.C0, F.C1)), F.List(2, 70000));
    BufferedImage bufferedImage =
        ImageFormat.toIntARGB(raw.mapLeaf(S.List, ColorDataGradients.GRAYSCALE));
    VisualImage visualImage = new VisualImage(bufferedImage);
    JFreeChart jFreeChart = ArrayPlot.arrayPlot(visualImage);
    ChartUtils.saveChartAsPNG(new File(HomeDirectory.Pictures(), "arrayplot001.png"), jFreeChart,
        1000, 300);
  }
}
