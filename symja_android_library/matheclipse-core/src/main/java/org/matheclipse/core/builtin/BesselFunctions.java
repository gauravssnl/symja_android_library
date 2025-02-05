package org.matheclipse.core.builtin;

import static org.matheclipse.core.expression.F.BesselY;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CI;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.CPiHalf;
import static org.matheclipse.core.expression.F.Plus;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sqrt;
import static org.matheclipse.core.expression.F.Times;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hipparchus.complex.Complex;
import org.hipparchus.exception.MathRuntimeException;
import org.matheclipse.core.builtin.functions.BesselJS;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.ValidateException;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.eval.interfaces.IFunctionExpand;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.reflection.system.FunctionExpand;
import org.matheclipse.core.reflection.system.rules.BesselIRules;
import org.matheclipse.core.reflection.system.rules.BesselJRules;
import org.matheclipse.core.reflection.system.rules.BesselKRules;
import org.matheclipse.core.reflection.system.rules.BesselYRules;
import org.matheclipse.core.reflection.system.rules.SphericalBesselJRules;
import org.matheclipse.core.reflection.system.rules.SphericalBesselYRules;

public class BesselFunctions {
  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation
   * in static initializer</a>
   */
  private static class Initializer {

    private static void init() {
      S.AiryAi.setEvaluator(new AiryAi());
      S.AiryAiPrime.setEvaluator(new AiryAiPrime());
      S.AiryBi.setEvaluator(new AiryBi());
      S.AiryBiPrime.setEvaluator(new AiryBiPrime());
      S.BesselI.setEvaluator(new BesselI());
      S.BesselJ.setEvaluator(new BesselJ());
      S.BesselJZero.setEvaluator(new BesselJZero());
      S.BesselK.setEvaluator(new BesselK());
      S.BesselY.setEvaluator(new BesselY());
      S.BesselYZero.setEvaluator(new BesselYZero());
      S.HankelH1.setEvaluator(new HankelH1());
      S.HankelH2.setEvaluator(new HankelH2());
      S.SphericalBesselJ.setEvaluator(new SphericalBesselJ());
      S.SphericalBesselY.setEvaluator(new SphericalBesselY());
      S.SphericalHankelH1.setEvaluator(new SphericalHankelH1());
      S.SphericalHankelH2.setEvaluator(new SphericalHankelH2());
      S.WeberE.setEvaluator(new WeberE());
    }
  }

  private static final class AiryAi extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr z = ast.arg1();
      if (z.isZero()) {
        // 1/(3^(2/3)*Gamma(2/3))
        return F.Divide(F.Power(F.C3, F.CN2D3), F.Gamma(F.C2D3));
      }
      if (engine.isDoubleMode() && z.isNumber()) {
        if (!z.isComplexNumeric()) {
          try {
            Complex airyAi = BesselJS.airyAi(z.evalf());
            if (F.isZero(airyAi.getImaginary())) {
              return F.num(airyAi.getReal());
            }
            return F.complexNum(airyAi);
          } catch (NegativeArraySizeException nae) {
            LOGGER.log(engine.getLogLevel(), "AiryAi: {} caused NegativeArraySizeException", ast,
                nae);
            return F.NIL;
          } catch (RuntimeException rex) {
            //
          }
        }

        try {
          return F.complexNum(BesselJS.airyAi(z.evalfc()));
        } catch (NegativeArraySizeException nae) {
          LOGGER.log(engine.getLogLevel(), "AiryAi: {} caused NegativeArraySizeException", ast);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class AiryAiPrime extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr z = ast.arg1();
      if (z.isZero()) {
        // -(1/(3^(1/3)*Gamma(1/3)))
        return F.Times(F.CN1, F.Power(F.C3, F.CN1D3), F.Power(F.Gamma(F.C1D3), F.CN1));
      }
      if (engine.isDoubleMode() && z.isNumber()) {
        if (!z.isComplexNumeric()) {
          try {
            Complex airyAiPrime = BesselJS.airyAiPrime(z.evalf());
            if (F.isZero(airyAiPrime.getImaginary())) {
              return F.num(airyAiPrime.getReal());
            }
            return F.complexNum(airyAiPrime);
          } catch (NegativeArraySizeException nae) {
            LOGGER.log(engine.getLogLevel(), "AiryAiPrime: {} caused NegativeArraySizeException",
                ast);
            return F.NIL;
          } catch (RuntimeException rex) {
          }
        }

        try {
          return F.complexNum(BesselJS.airyAiPrime(z.evalfc()));
        } catch (NegativeArraySizeException nae) {
          LOGGER.log(engine.getLogLevel(), "AiryAiPrime: {} caused NegativeArraySizeException",
              ast);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
        return F.NIL;
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class AiryBi extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr z = ast.arg1();
      if (z.isZero()) {
        // 1/(3^(1/6)*Gamma(2/3))
        return F.Divide(F.Power(F.C3, F.CN1D6), F.Gamma(F.C2D3));
      }
      if (engine.isDoubleMode() && z.isNumber()) {

        if (!z.isComplexNumeric()) {
          try {
            Complex airyBi = BesselJS.airyBi(z.evalf());
            if (F.isZero(airyBi.getImaginary())) {
              return F.num(airyBi.getReal());
            }
            return F.complexNum(airyBi);
          } catch (NegativeArraySizeException nae) {
            LOGGER.log(engine.getLogLevel(), "AiryBi: {} caused NegativeArraySizeException", ast);
            return F.NIL;
          } catch (RuntimeException rex) {
          }
        }

        try {
          return F.complexNum(BesselJS.airyBi(z.evalfc()));
        } catch (NegativeArraySizeException nae) {
          LOGGER.log(engine.getLogLevel(), "AiryBi: {} caused NegativeArraySizeException", ast);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class AiryBiPrime extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr z = ast.arg1();
      if (z.isZero()) {
        // 3^(1/6)/Gamma(1/3)
        return F.Divide(F.Power(F.C3, F.C1D6), F.Gamma(F.C1D3));
      }
      if (engine.isDoubleMode() && z.isNumber()) {
        if (!z.isComplexNumeric()) {
          try {
            Complex airyBiPrime = BesselJS.airyBiPrime(z.evalf());
            if (F.isZero(airyBiPrime.getImaginary())) {
              return F.num(airyBiPrime.getReal());
            }
            return F.complexNum(airyBiPrime);
          } catch (NegativeArraySizeException nae) {
            LOGGER.log(engine.getLogLevel(), "AiryBiPrime: {} caused NegativeArraySizeException",
                ast, nae);
            return F.NIL;
          } catch (RuntimeException rex) {
          }
        }

        try {
          return F.complexNum(BesselJS.airyBiPrime(z.evalfc()));
        } catch (NegativeArraySizeException nae) {
          LOGGER.log(engine.getLogLevel(), "AiryBiPrime: {} caused NegativeArraySizeException", ast,
              nae);
          return F.NIL;
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          return F.NIL;
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_1_1;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>BesselJ(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * Bessel function of the first kind.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Bessel_function">Wikipedia - Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; BesselJ(1, 3.6)
   * 0.0954655
   * </code>
   * </pre>
   */
  private static final class BesselJ extends AbstractFunctionEvaluator implements BesselJRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    /**
     * Precondition <code> n - 1/2 </code> is an integer number.
     *
     * @param n
     * @param z
     * @return
     */
    // private IExpr besselJHalf(IExpr n, IExpr z) {
    // // (1/Sqrt(z))*Sqrt(2/Pi)*(Cos((1/2)*Pi*(n - 1/2) - z)*Sum(((-1)^j*(2*j + Abs(n) + 1/2)! *
    // // (2*z)^(-2*j -
    // // 1))/
    // // ((2*j + 1)! * (-2*j + Abs(n) - 3/2)!), {j, 0, Floor((1/4)*(2*Abs(n) - 3))}) -
    // // Sin((1/2)*Pi*(n - 1/2) -
    // // z)*Sum(((-1)^j*(2*j + Abs(n) - 1/2)!)/ ((2*j)!*(-2*j + Abs(n) - 1/2)!*(2*z)^(2*j)), {j, 0,
    // // Floor((1/4)*(2*Abs(n) - 1))}))
    // ISymbol j = F.Dummy("j");
    // return F
    // .Times(
    // F.CSqrt2, F.Power(S.Pi, F.CN1D2), F.Power(z, F.CN1D2), F
    // .Plus(
    // F.Times(
    // F.Cos(F.Plus(F.Times(F.C1D2, F.Plus(F.CN1D2, n), S.Pi),
    // F.Negate(z))),
    // F.Sum(F.Times(F.Power(F.CN1, j),
    // F.Power(F.Times(F.C2, z), F.Plus(F.CN1, F.Times(F.CN2, j))),
    // F.Factorial(F.Plus(F.Times(F.C2, j), F.Abs(n), F.C1D2)),
    // F.Power(
    // F.Times(F.Factorial(F.Plus(F.Times(F.C2, j), F.C1)),
    // F.Factorial(
    // F.Plus(F.QQ(-3L, 2L), F.Times(F.CN2, j), F.Abs(n)))),
    // -1)),
    // F.list(j, F.C0,
    // F.Floor(
    // F.Times(F.C1D4, F.Plus(F.CN3, F.Times(F.C2, F.Abs(n)))))))),
    // F.Times(F.CN1,
    // F.Sin(F.Plus(F.Times(F.C1D2, F.Plus(F.CN1D2, n), S.Pi),
    // F.Negate(z))),
    // F.Sum(F.Times(F.Power(F.CN1, j),
    // F.Power(F.Times(F.Factorial(F.Times(F.C2, j)),
    // F.Factorial(F.Plus(F.CN1D2, F.Times(F.CN2, j), F.Abs(n))),
    // F.Power(F.Times(F.C2, z), F.Times(F.C2, j))), -1),
    // F.Factorial(F.Plus(F.CN1D2, F.Times(F.C2, j), F.Abs(n)))),
    // F.list(j, F.C0, F.Floor(
    // F.Times(F.C1D4, F.Plus(F.CN1, F.Times(F.C2, F.Abs(n))))))))));
    // }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      final int order = n.toIntDefault();
      if (z.isZero()) {
        if (n.isZero()) {
          // (0, 0)
          return F.C1;
        }
        if (n.isIntegerResult() || order != Integer.MIN_VALUE) {
          return F.C0;
        }

        IExpr a = n.re();
        if (a.isPositive()) {
          // Re(arg1) > 0
          return F.C0;
        } else if (a.isNegative()) {
          // Re(arg1) < 0 && !a.isInteger()
          return F.CComplexInfinity;
        } else if (a.isZero() && !n.isZero()) {
          return S.Indeterminate;
        }
      }
      // if (n.isReal()) {
      // IExpr in = engine.evaluate(((IReal) n).add(F.CN1D2));
      // if (in.isNumIntValue()) {
      // if (z.isInfinity() || z.isNegativeInfinity()) {
      // return F.C0;
      // }
      // return besselJHalf(n, z);
      // }
      // }

      if (n.isInteger() || order != Integer.MIN_VALUE) {
        if (n.isNegative()) {
          // (-n,z) => (-1)^n*BesselJ(n,z)
          return F.Times(F.Power(F.CN1, n), F.BesselJ(n.negate(), z));
        }
      }

      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }
          if (Double.isNaN(nDouble) || Double.isNaN(zDouble) || zDouble < 0.0) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.besselJ(nc, zc));
          } else {
            return F.num(BesselJS.besselJDouble(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>BesselJZero(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * is the <code>k</code>th zero of the <code>BesselJ(n,z)</code> function.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Bessel_function">Wikipedia - Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; BesselJZero(1.3, 3)
   * 10.61381
   * </code>
   * </pre>
   */
  private static final class BesselJZero extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      final int k = z.toIntDefault();
      if (engine.isDoubleMode() && n.isNumber()) {
        if (k > 0 && engine.isDoubleMode()) {
          try {
            // numeric mode evaluation
            if (n.isReal()) {
              return F.num(BesselJS.besselJZero(n.evalf(), k));
            }
          } catch (MathRuntimeException e) {
            // org.hipparchus.exception.MathIllegalArgumentException: interval does not bracket a
            // root
            LOGGER.debug("BesselJZero.evaluate() failed", e);
          }
        }
      }

      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>BesselI(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * modified Bessel function of the first kind.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Bessel_function">Wikipedia - Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; BesselI(1, 3.6)
   * 6.79271
   * </code>
   * </pre>
   */
  private static final class BesselI extends AbstractFunctionEvaluator implements BesselIRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      // final int order = n.toIntDefault();
      if (z.isZero()) {
        if (n.isZero()) {
          return F.C1;
        }
        if (n.isInteger()) {
          return F.C0;
        }
        IExpr re = n.re();
        if (re.isPositiveResult()) {
          return F.C0;
        }
        if (re.isNegativeResult() && n.isNumber() && !n.isInteger()) {
          return S.ComplexInfinity;
        }
        if (re.isZero() && n.isNumber() && !n.isZero()) {
          return S.Indeterminate;
        }
      }
      if (n.isNumber() && //
          (z.isDirectedInfinity(F.CI) || z.isDirectedInfinity(F.CNI))) {
        return F.C0;
      }
      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }
          if (Double.isNaN(nDouble) || Double.isNaN(zDouble) || zDouble < 0.0) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.besselI(nc, zc));
          } else {
            return F.num(BesselJS.besselIDouble(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>BesselK(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * modified Bessel function of the second kind.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Bessel_function">Wikipedia - Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; BesselK(1, 3.6)
   * 0.019795
   * </code>
   * </pre>
   */
  private static final class BesselK extends AbstractFunctionEvaluator implements BesselKRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      // final int order = n.toIntDefault();
      if (z.isZero()) {
        if (n.isZero()) {
          return F.CInfinity;
        }
        IExpr re = n.re();
        if (re.isZero() && n.isNumber() && !n.isZero()) {
          return S.Indeterminate;
        }
        if (re.isNumber() && !re.isZero()) {
          return S.ComplexInfinity;
        }
      }
      if (n.isNumber() && //
          (z.isDirectedInfinity(F.CI) || z.isDirectedInfinity(F.CNI))) {
        return F.C0;
      }
      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }
          if (Double.isNaN(nDouble) || Double.isNaN(zDouble) || zDouble < 0.0) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.besselK(nc, zc));
          } else {
            return F.num(BesselJS.besselKDouble(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>BesselY(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * Bessel function of the second kind.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Bessel_function">Wikipedia - Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; BesselY(1, 3.6)
   * 0.415392
   * </code>
   * </pre>
   */
  private static final class BesselY extends AbstractFunctionEvaluator implements BesselYRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      // final int order = n.toIntDefault();

      if (z.isZero()) {
        if (n.isZero()) {
          return F.CNInfinity;
        }
        IExpr re = S.Re.of(engine, n);
        if (re.isZero() && n.isNumber() && !n.isZero()) {
          return S.Indeterminate;
        }
        if (re.isNumber() && !re.isZero()) {
          return S.ComplexInfinity;
        }
      }
      if (n.isNumber() && //
          (z.isInfinity() || z.isNegativeInfinity())) {
        return F.C0;
      }
      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }
          if (Double.isNaN(nDouble) || Double.isNaN(zDouble) || zDouble < 0.0) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.besselY(nc, zc));
          } else {
            return F.num(BesselJS.besselYDouble(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class BesselYZero extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      final int k = z.toIntDefault();

      if (k > 0 && engine.isDoubleMode() && n.isNumber()) {
        try {
          // numeric mode evaluation
          if (n.isReal()) {
            return F.num(BesselJS.besselYZero(n.evalf(), k));
          }
        } catch (MathRuntimeException e) {
          // org.hipparchus.exception.MathIllegalArgumentException: interval does not bracket a root
          LOGGER.debug("BesselYZero.evaluate() failed", e);
        }
      }

      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class HankelH1 extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();

      if (z.isZero()) {
        return F.CComplexInfinity;
      }
      if (n.isNumber() && z.isNumber()) {
        if (engine.isDoubleMode()) {
          try {
            double nDouble = Double.NaN;
            double zDouble = Double.NaN;
            try {
              nDouble = n.evalf();
              zDouble = z.evalf();
            } catch (ValidateException ve) {
            }
            if (Double.isNaN(nDouble) || Double.isNaN(zDouble)) {
              Complex nc = n.evalfc();
              Complex zc = z.evalfc();
              return F.complexNum(BesselJS.hankelH1(nc, zc));
            } else {
              Complex hankelH1 = BesselJS.hankelH1(nDouble, zDouble);
              if (F.isZero(hankelH1.getImaginary())) {
                return F.num(hankelH1.getReal());
              }
              return F.complexNum(hankelH1);
            }

          } catch (ValidateException ve) {
            return IOFunctions.printMessage(ast.topHead(), ve, engine);
          } catch (RuntimeException rex) {
            LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          }
        } else if (engine.isArbitraryMode()) {
          return F.Plus(F.BesselJ(n, z), F.Times(F.CI, F.BesselY(n, z)));
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class HankelH2 extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (z.isZero()) {
        return F.CComplexInfinity;
      }
      if (n.isNumber() && z.isNumber()) {
        if (engine.isDoubleMode()) {
          try {
            double nDouble = Double.NaN;
            double zDouble = Double.NaN;
            try {
              nDouble = n.evalf();
              zDouble = z.evalf();
            } catch (ValidateException ve) {
            }
            if (Double.isNaN(nDouble) || Double.isNaN(zDouble)) {
              Complex nc = n.evalfc();
              Complex zc = z.evalfc();
              return F.complexNum(BesselJS.hankelH2(nc, zc));
            } else {
              Complex hankelH2 = BesselJS.hankelH2(nDouble, zDouble);
              if (F.isZero(hankelH2.getImaginary())) {
                return F.num(hankelH2.getReal());
              }
              return F.complexNum(hankelH2);
            }

          } catch (ValidateException ve) {
            return IOFunctions.printMessage(ast.topHead(), ve, engine);
          } catch (RuntimeException rex) {
            LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          }
        } else if (engine.isArbitraryMode()) {
          return F.Plus(F.BesselJ(n, z), F.Times(F.CNI, F.BesselY(n, z)));
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>SphericalBesselJ(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * spherical Bessel function <code>J(n, x)</code>.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href=
   * "https://en.wikipedia.org/wiki/Bessel_function#Spherical_Bessel_functions">Wikipedia - Bessel
   * function - Spherical Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; SphericalBesselJ(2.5,-5)
   * I*0.204488
   * </code>
   * </pre>
   */
  private static final class SphericalBesselJ extends AbstractFunctionEvaluator
      implements SphericalBesselJRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }

          if (Double.isNaN(nDouble) || Double.isNaN(zDouble)) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.sphericalBesselJ(nc, zc));
          } else {
            return F.complexNum(BesselJS.sphericalBesselJ(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          return F.NIL;
        }
      }
      // if (n.isReal() && z.isReal()) {
      // try {
      // return F.complexNum(BesselJS.sphericalBesselJ(n.evalDouble(), z.evalDouble()));
      // } catch (NegativeArraySizeException nae) {
      // return engine
      // .printMessage("SphericalBesselJ: " + ast.toString() + " caused
      // NegativeArraySizeException");
      // } catch (RuntimeException rte) {
      // return engine.printMessage("SphericalBesselJ: " + rte.getMessage());
      // }
      // }
      // if (n.isNumeric() && z.isNumeric()) {
      // try {
      // return F.complexNum(BesselJS.sphericalBesselJ(n.evalComplex(), z.evalComplex()));
      // } catch (NegativeArraySizeException nae) {
      // return engine
      // .printMessage("SphericalBesselJ: " + ast.toString() + " caused
      // NegativeArraySizeException");
      // } catch (RuntimeException rte) {
      // return engine.printMessage("SphericalBesselJ: " + rte.getMessage());
      // }
      // }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class SphericalHankelH1 extends AbstractFunctionEvaluator
      implements IFunctionExpand {

    @Override
    public IExpr functionExpand(final IAST ast, EvalEngine engine) {
      if (ast.isAST2()) {
        IExpr a = ast.arg1();
        IExpr b = ast.arg2();
        // SphericalHankelH1(a_,b_):=(Sqrt(Pi/2)*BesselJ(1/2*(1+2*a),b))/Sqrt(b)+(I*Sqrt(Pi/2)*BesselY(1/2*(1+2*a),b))/Sqrt(b)
        return F.Plus(
            F.Times(F.Power(b, F.CN1D2), F.Sqrt(F.CPiHalf),
                F.BesselJ(F.Times(C1D2, F.Plus(F.C1, F.Times(C2, a))), b)),
            Times(CI, Power(b, CN1D2), Sqrt(CPiHalf),
                BesselY(Times(C1D2, Plus(C1, Times(C2, a))), b)));
      }
      return F.NIL;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (engine.isNumericMode() && n.isNumber() && z.isNumber()) {
        try {
          // Complex nc = n.evalComplex();
          // Complex zc = z.evalComplex();
          // return FunctionExpand.callMatcher(F.FunctionExpand(ast), ast, engine);
          return functionExpand(ast, engine);
        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          return F.NIL;
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class SphericalHankelH2 extends AbstractFunctionEvaluator
      implements IFunctionExpand {
    @Override
    public IExpr functionExpand(final IAST ast, EvalEngine engine) {
      if (ast.isAST2()) {
        IExpr a = ast.arg1();
        IExpr b = ast.arg2();
        // SphericalHankelH2(a_,b_):=(Sqrt(Pi/2)*BesselJ(1/2*(1+2*a),b))/Sqrt(b)+(-I*Sqrt(Pi/2)*BesselY(1/2*(1+2*a),b))/Sqrt(b)

        return F.Plus(
            F.Times(Power(b, CN1D2), F.Sqrt(CPiHalf),
                F.BesselJ(F.Times(F.C1D2, F.Plus(F.C1, F.Times(F.C2, a))), b)),
            F.Times(F.CNI, F.Power(b, F.CN1D2), F.Sqrt(F.CPiHalf),
                F.BesselY(F.Times(F.C1D2, F.Plus(F.C1, F.Times(C2, a))), b)));

      }
      return F.NIL;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (engine.isNumericMode() && n.isNumber() && z.isNumber()) {
        try {
          // Complex nc = n.evalComplex();
          // Complex zc = z.evalComplex();
          // return FunctionExpand.callMatcher(F.FunctionExpand(ast), ast, engine);
          return functionExpand(ast, engine);
        } catch (ValidateException ve) {
          ve.printStackTrace();
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          return F.NIL;
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  /**
   *
   *
   * <pre>
   * <code>SphericalBesselY(n, z)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * spherical Bessel function <code>Y(n, x)</code>.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href=
   * "https://en.wikipedia.org/wiki/Bessel_function#Spherical_Bessel_functions">Wikipedia - Bessel
   * function - Spherical Bessel function</a>
   * </ul>
   *
   * <h3>Examples</h3>
   */
  private static final class SphericalBesselY extends AbstractFunctionEvaluator
      implements SphericalBesselYRules {

    @Override
    public IAST getRuleAST() {
      return RULES;
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (z.isZero()) {
        return F.CComplexInfinity;
      }
      if (engine.isDoubleMode() && n.isNumber() && z.isNumber()) {
        try {
          double nDouble = Double.NaN;
          double zDouble = Double.NaN;
          try {
            nDouble = n.evalf();
            zDouble = z.evalf();
          } catch (ValidateException ve) {
          }

          if (Double.isNaN(nDouble) || Double.isNaN(zDouble) || zDouble < 0.0) {
            Complex nc = n.evalfc();
            Complex zc = z.evalfc();
            return F.complexNum(BesselJS.sphericalBesselY(nc, zc));
          } else {
            return F.complexNum(BesselJS.sphericalBesselY(nDouble, zDouble));
          }

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  private static final class WeberE extends AbstractFunctionEvaluator {
    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr n = ast.arg1();
      IExpr z = ast.arg2();
      if (engine.isNumericMode() && n.isNumber() && z.isNumber()) {
        try {
          // side effect - throw ArgumentTypeException if no Complex value can be evaluated
          Complex nc = n.evalfc();
          Complex zc = z.evalfc();
          if (ast.isAST3()) {
            Complex a3 = ast.arg3().evalfc();
          }
          return FunctionExpand.callMatcher(F.FunctionExpand(ast), ast, engine);

        } catch (ValidateException ve) {
          return IOFunctions.printMessage(ast.topHead(), ve, engine);
        } catch (RuntimeException rex) {
          LOGGER.log(engine.getLogLevel(), ast.topHead(), rex);
          return F.NIL;
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_3;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      super.setUp(newSymbol);
      newSymbol.setAttributes(ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);
    }
  }

  public static void initialize() {
    Initializer.init();
  }

  private BesselFunctions() {}
}
