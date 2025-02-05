package org.matheclipse.core.builtin;

import static org.matheclipse.core.expression.S.Power;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hipparchus.optim.OptimizationData;
import org.hipparchus.optim.PointValuePair;
import org.hipparchus.optim.linear.LinearConstraint;
import org.hipparchus.optim.linear.LinearConstraintSet;
import org.hipparchus.optim.linear.LinearObjectiveFunction;
import org.hipparchus.optim.linear.NonNegativeConstraint;
import org.hipparchus.optim.linear.PivotSelectionRule;
import org.hipparchus.optim.linear.SimplexSolver;
import org.hipparchus.optim.nonlinear.scalar.GoalType;
import org.matheclipse.core.basic.Config;
import org.matheclipse.core.convert.Expr2LP;
import org.matheclipse.core.convert.VariablesSet;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.ArgumentTypeStopException;
import org.matheclipse.core.eval.exception.JASConversionException;
import org.matheclipse.core.eval.exception.ValidateException;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.eval.interfaces.AbstractFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.ID;
import org.matheclipse.core.expression.IntervalDataSym;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IASTAppendable;
import org.matheclipse.core.interfaces.IASTMutable;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.Matcher;
import org.matheclipse.core.polynomials.longexponent.ExprMonomial;
import org.matheclipse.core.polynomials.longexponent.ExprPolynomial;
import org.matheclipse.core.polynomials.longexponent.ExprPolynomialRing;
import org.matheclipse.core.polynomials.longexponent.ExprRingFactory;
import org.matheclipse.core.reflection.system.rules.FunctionRangeRules;
import org.matheclipse.core.visit.VisitorExpr;
import com.google.common.base.Suppliers;

public class MinMaxFunctions {
  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation
   * in static initializer</a>
   */
  private static class Initializer {

    private static void init() {
      S.ArgMax.setEvaluator(new ArgMax());
      S.ArgMin.setEvaluator(new ArgMin());
      S.FunctionDomain.setEvaluator(new FunctionDomain());
      S.FunctionRange.setEvaluator(new FunctionRange());
      S.Maximize.setEvaluator(new Maximize());
      S.Minimize.setEvaluator(new Minimize());
      S.NMaximize.setEvaluator(new NMaximize());
      S.NMinimize.setEvaluator(new NMinimize());
    }
  }

  /**
   *
   *
   * <pre>
   * <code>ArgMax(function, variable)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * returns a maximizer point for a univariate <code>function</code>.
   *
   * </blockquote>
   *
   * <p>
   * See:
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Arg_max">Wikipedia - Arg max</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; ArgMax(x*10-x^2, x)
   * 5
   * </code>
   * </pre>
   */
  private static class ArgMax extends AbstractEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr x = ast.arg2();
      if (x.isSymbol() || (x.isAST() && !x.isList())) {
        IExpr result = maximize(ast.topHead(), ast.arg1(), x, engine);
        if (result.isList() && result.last().isList()) {
          IAST subList = (IAST) result.last();
          if (subList.last().isRule()) {
            return subList.last().second();
          }
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }
  }

  /**
   *
   *
   * <pre>
   * <code>ArgMin(function, variable)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * returns a minimizer point for a univariate <code>function</code>.
   *
   * </blockquote>
   *
   * <p>
   * See:
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Arg_max">Wikipedia - Arg max</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; ArgMin(x*10+x^2, x)
   * -5
   * </code>
   * </pre>
   */
  private static class ArgMin extends AbstractEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr x = ast.arg2();
      if (x.isSymbol() || (x.isAST() && !x.isList())) {
        IExpr result = minimize(ast.topHead(), ast.arg1(), x, engine);
        if (result.isList() && result.last().isList()) {
          IAST subList = (IAST) result.last();
          if (subList.last().isRule()) {
            return subList.last().second();
          }
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }
  }

  private static final class FunctionRange extends AbstractFunctionEvaluator
      implements FunctionRangeRules {
    private static Supplier<Matcher> LAZY_MATCHER;

    private static class Initializer {

      private static Matcher init() {
        Matcher MATCHER = new Matcher();
        IAST list = RULES;

        for (int i = 1; i < list.size(); i++) {
          IExpr arg = list.get(i);
          if (arg.isAST(S.SetDelayed, 3)) {
            MATCHER.caseOf(arg.first(), arg.second());
          } else if (arg.isAST(S.Set, 3)) {
            MATCHER.caseOf(arg.first(), arg.second());
          }
        }
        return MATCHER;
      }
    }
    private static final class FunctionRangeRealsVisitor extends VisitorExpr {
      final EvalEngine engine;

      public FunctionRangeRealsVisitor(EvalEngine engine) {
        super();
        this.engine = engine;
      }

      // @Override
      // public IExpr visit2(IExpr head, IExpr arg1) {
      // boolean evaled = false;
      // IExpr x = arg1;
      // IExpr result = arg1.accept(this);
      // if (result.isPresent()) {
      // evaled = true;
      // x = result;
      // }
      // if (evaled) {
      // return F.unaryAST1(head, x);
      // }
      // return F.NIL;
      // }

      /** {@inheritDoc} */
      @Override
      public IExpr visit3(IExpr head, IExpr arg1, IExpr arg2) {
        boolean evaled = false;
        IExpr x1 = arg1;
        IExpr result = arg1.accept(this);
        if (result.isPresent()) {
          evaled = true;
          x1 = result;
        }
        IExpr x2 = arg2;
        result = arg2.accept(this);
        if (result.isPresent()) {
          evaled = true;
          x2 = result;
        }
        if (head.equals(Power)) {
          if (x1.isInterval1()) {
            IAST interval = (IAST) x1;
            IExpr l = interval.lower();
            IExpr u = interval.upper();
            if (x2.isMinusOne()) {
              if (S.GreaterEqual.ofQ(engine, l, F.C1)) {
                // [>= 1, u]
                return F.Interval(F.Power(u, x2), F.Power(l, x2));
              }
            }
            if (l.isNegativeResult() && u.isPositiveResult()) {
              if (x2.isPositiveResult()) {
                return F.Interval(F.C0, F.Power(u, x2));
              }
              if (x2.isEvenResult()
                  || (x2.isFraction() && ((IFraction) x2).denominator().isEven())) {
                return F.Interval(F.C0, F.Power(u, x2));
              }
            }
          }
        }
        if (evaled) {
          return F.binaryAST2(head, x1, x2);
        }
        return F.NIL;
      }
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr function = ast.arg1();
      IExpr xExpr = ast.arg2();
      IExpr yExpr = ast.arg3();
      IBuiltInSymbol domain = S.Reals;
      try {
        if (xExpr.isSymbol() && yExpr.isSymbol()) {
          IExpr match = callMatcher(ast, function, engine);
          if (match.isPresent()) {
            return match;
          }
          boolean evaled = true;
          ISymbol x = (ISymbol) xExpr;
          ISymbol y = (ISymbol) yExpr;
          IExpr min = engine.evalQuiet(F.Minimize(function, xExpr));
          IExpr max = engine.evalQuiet(F.Maximize(function, xExpr));
          IASTMutable minMaxList = F.binaryAST2(S.List, F.CNInfinity, F.CInfinity);
          if (min.isAST(S.List, 3)) {
            minMaxList.set(1, min.first());
          } else {
            evaled = false;
          }
          if (max.isAST(S.List, 3)) {
            minMaxList.set(2, max.first());
          } else {
            evaled = false;
          }
          if (evaled) {
            return convertMinMaxList(minMaxList, y);
          }
          IExpr f = function.replaceAll(F.Rule(x, F.Interval(F.CNInfinity, F.CInfinity)))
              .orElse(function);
          IExpr result = engine.evaluate(f);
          if (result.isInterval1()) {
            return convertInterval(result, y);
          } else if (domain.equals(S.Reals)) {
            IExpr temp = result;
            while (temp.isPresent()) {
              temp = temp.accept(new FunctionRangeRealsVisitor(engine));
              if (temp.isPresent()) {
                result = engine.evaluate(temp);
                temp = result;
              }
            }
            if (result.isInterval1()) {
              return convertInterval(result, y);
            }
          }
        }

      } catch (RuntimeException rex) {
        rex.printStackTrace();
        LOGGER.debug("FunctionRange.evaluate() failed", rex);
      }
      return F.NIL;
    }

    private IExpr convertInterval(IExpr result, ISymbol y) {
      IAST list = (IAST) result.first();
      return convertMinMaxList(list, y);
    }

    private IExpr convertMinMaxList(IAST list, ISymbol y) {
      if (list.arg1().isRealResult()) {
        if (list.arg2().isInfinity()) {
          return F.GreaterEqual(y, list.arg1());
        } else if (list.arg2().isRealResult()) {
          return F.LessEqual(list.arg1(), y, list.arg2());
        }
      } else if (list.arg2().isRealResult()) {
        if (list.arg1().isNegativeInfinity()) {
          if (!list.arg2().isInfinity()) {
            return F.LessEqual(y, list.arg2());
          }
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_3_3;
    }

    private static Matcher getMatcher() {
      return LAZY_MATCHER.get();
    }

    public static IExpr callMatcher(final IAST ast, IExpr arg1, EvalEngine engine) {
      IExpr temp = getMatcher().replaceAll(ast);
      if (temp.isPresent()) {
        engine.putCache(ast, temp);
      }
      return temp;
    }

    @Override
    public void setUp(final ISymbol newSymbol) {
      // Initializer.init();
      LAZY_MATCHER = Suppliers.memoize(Initializer::init);
    }
  }
  private static final class FunctionDomain extends AbstractFunctionEvaluator {

    static final class FunctionDomainRealsVisitor extends VisitorExpr {
      final EvalEngine engine;
      IAST resultInterval;
      IASTAppendable notElementList;
      IExpr variable;

      public FunctionDomainRealsVisitor(EvalEngine engine, IExpr variable) {
        super();
        this.engine = engine;
        this.resultInterval = F.IntervalData(F.List(F.CNInfinity, F.Less, F.Less, F.CInfinity));
        this.notElementList = F.ListAlloc();
        this.variable = variable;
      }

      /** {@inheritDoc} */
      @Override
      public IExpr visit(IASTMutable ast) {
        if (ast.isFree(variable)) {
          return F.NIL;
        }
        if (ast.isTimes()) {
          IExpr[] parts = Algebra.fractionalParts(ast, false);
          if (parts != null) {
            IExpr numerator = parts[0];
            IExpr denominator = parts[1];
            if (!denominator.isFree(variable)) {
              numerator.accept(this);
              return roots(denominator);
            }
          }
          determineIntervalSequence(ast);
        } else if (ast.isPlus()) {
          determineIntervalSequence(ast);
        } else {
          int headID = ast.headID();
          if (headID >= 0) {
            int argSize = ast.argSize();
            switch (argSize) {
              case 1:
                arg1FunctionDomain(headID, ast);
                break;
              case 2:
                arg2FunctionDomain(headID, ast);
                break;
              default:
                throw new ArgumentTypeStopException("Not implemented");
            }
          }
        }
        return F.NIL;
      }

      private void arg1FunctionDomain(int headID, IASTMutable ast) {
        IExpr arg1 = ast.arg1();
        arg1.accept(this);
        switch (headID) {
          case ID.ArcCot:
          case ID.ArcTan:
          case ID.ArcSinh:
          case ID.Cos:
          case ID.Sin:
            return;
        }

        if (arg1.isPolynomial(variable)) {
          arg1FunctionDomain(headID, arg1);
          return;
        }

        throw new ArgumentTypeStopException("Not implemented");
      }

      private void arg1FunctionDomain(int headID, IExpr arg1) {

        switch (headID) {
          // case ID.ArcCot:
          // case ID.ArcTan:
          // case ID.ArcSinh:
          // case ID.Cos:
          // case ID.Sin:
          // return;
          case ID.ArcCos:
          case ID.ArcSin:
            // -1 <= x <= 1
            intervalIntersection(
                relationToInterval(arg1, S.GreaterEqual, F.CN1, S.LessEqual, F.C1));
            return;
          case ID.ArcCsc:
          case ID.ArcSec:
            intervalIntersection(intervalUnion(//
                relationToInterval(arg1, S.GreaterEqual, F.C1), //
                relationToInterval(arg1, S.LessEqual, F.CN1)));
            return;
          case ID.ArcCosh:
            intervalIntersection(relationToInterval(arg1, S.GreaterEqual, F.C1));
            return;
          case ID.ArcCoth:
            intervalIntersection(intervalUnion(//
                relationToInterval(arg1, S.Greater, F.C1), //
                relationToInterval(arg1, S.Less, F.CN1)));
            return;
          case ID.ArcTanh:
            intervalIntersection(relationToInterval(arg1, S.Greater, F.CN1, S.Less, F.C1));
            return;
          case ID.Cot:
          case ID.Csc:
            notElementList.append(F.NotElement(F.Times(arg1, F.Power(S.Pi, F.CN1)), S.Integers));
            return;
          case ID.Gamma:
            intervalIntersection(relationToInterval(arg1, S.Greater, F.C0));
            notElementList.append(F.NotElement(arg1, S.Integers));
            return;
          case ID.Sec:
          case ID.Tan:
            notElementList.append(
                F.NotElement(F.Plus(F.C1D2, F.Times(arg1, F.Power(S.Pi, F.CN1))), S.Integers));
            return;
          case ID.Log:
            intervalIntersection(relationToInterval(arg1, S.Greater, F.C0));
            return;
          default:
        }

        throw new ArgumentTypeStopException("Not implemented");
      }

      private void arg2FunctionDomain(int headID, IASTMutable ast) {
        IExpr arg1 = ast.arg1();
        IExpr arg2 = ast.arg2();
        arg1.accept(this);
        arg2.accept(this);

        switch (headID) {
          case ID.Power:
            IExpr base = arg1;
            IExpr exponent = arg2;
            if (base.isFree(variable)) {
              if (base.isPositive()) {
                return;
              }
            } else if (exponent.isFree(variable)) {
              if (exponent.isInteger()) {
                if (exponent.isNegative()) {
                  // exponent < 0 && x != 0
                  intervalIntersection(relationToInterval(base, S.Unequal, F.C0));
                  return;
                }
                return;
              } else if (exponent.isPositive()) {
                intervalIntersection(relationToInterval(base, S.GreaterEqual, F.C0));
                return;
              }
              if (exponent.isNegativeResult()) {
                IExpr denominator = base;
                roots(denominator);
                return;
              }
            }
            throw new ArgumentTypeStopException("Not implemented");
          default:
            throw new ArgumentTypeStopException("Not implemented");
        }
      }

      /**
       * Create an {@link F#IntervalData(IAST...)} from the relation
       * <code>F.binaryAST2(relationalSymbol, expr, value)</code>.
       * 
       * @param expr
       * @param relationalSymbol one of the symbols
       *        {@link S#Greater},{@link S#GreaterEqual}{@link S#Less}{@link S#LessEqual}{@link S#Unequal}
       * @param value
       * @return
       */
      private IAST relationToInterval(IExpr expr, IBuiltInSymbol relationalSymbol, IExpr value) {
        IExpr temp = engine.evaluate(F.Simplify(F.binaryAST2(relationalSymbol, expr, value)));
        if (temp.isAST2() && temp.first().equals(variable)) {
          IExpr rhs = temp.second();
          int headID = temp.headID();
          switch (headID) {
            case ID.Greater:
              return F.IntervalData(//
                  F.List(rhs, S.Less, S.Less, F.CInfinity));
            case ID.GreaterEqual:
              return F.IntervalData(//
                  F.List(rhs, S.LessEqual, S.Less, F.CInfinity));
            case ID.Less:
              return F.IntervalData(//
                  F.List(F.CNInfinity, S.Less, S.Less, rhs));
            case ID.LessEqual:
              return F.IntervalData(//
                  F.List(F.CNInfinity, S.Less, S.LessEqual, rhs));
            case ID.Equal:
              return F.IntervalData(//
                  F.List(rhs, S.LessEqual, S.LessEqual, rhs));
            case ID.Unequal:
              return F.IntervalData(//
                  F.List(F.CNInfinity, S.Less, S.Less, rhs), //
                  F.List(rhs, S.Less, S.Less, F.CInfinity));
          }
        }
        throw new ArgumentTypeStopException("Not implemented");
      }

      private IAST relationToInterval(IExpr expr, IBuiltInSymbol symbol1, IExpr value1,
          IBuiltInSymbol symbol2, IExpr value2) {
        IAST f1 = relationToInterval(expr, symbol1, value1);
        IAST f2 = relationToInterval(expr, symbol2, value2);
        if (f1.isPresent() && f2.isPresent()) {
          IExpr temp = F.IntervalIntersection.of(engine, f1, f2);
          if (temp.isAST(S.IntervalData)) {
            return (IAST) temp;
          }
        }
        throw new ArgumentTypeStopException("IntervalIntersection failed");
      }

      private void intervalIntersection(IAST interval) {
        IExpr temp = F.IntervalIntersection.of(engine, resultInterval, interval);
        if (!temp.isAST(S.IntervalData)) {
          throw new ArgumentTypeStopException("IntervalIntersection failed");
        }
        resultInterval = (IAST) temp;
      }

      private IAST intervalUnion(IAST interval1, IAST interval2) {
        IExpr temp = F.IntervalUnion.of(engine, interval1, interval2);
        if (!temp.isAST(S.IntervalData)) {
          throw new ArgumentTypeStopException("IntervalIntersection failed");
        }
        return (IAST) temp;
      }

      private IExpr roots(IExpr denominator) {
        IExpr roots = RootsFunctions.roots(denominator, false, variable.makeList(), engine);
        if (roots.isNonEmptyList()) {
          IAST list = (IAST) roots;
          for (int i = 1; i < list.size(); i++) {
            IExpr arg = list.get(i);
            if (arg.isRealResult()) {
              IAST notInRange = IntervalDataSym.notInRange(arg);
              IExpr temp = F.IntervalIntersection.of(engine, resultInterval, notInRange);
              if (!temp.isAST(S.IntervalData)) {
                throw new ArgumentTypeStopException("IntervalIntersection failed");
              }
              resultInterval = (IAST) temp;
            }
          }
          return F.NIL;
        }
        throw new ArgumentTypeStopException("Roots failed");
      }

      private void determineIntervalSequence(IAST ast) {
        for (int i = 1; i < ast.size(); i++) {
          IExpr arg = ast.get(i);
          if (arg.isFree(variable)) {
            continue;
          }
          arg.accept(this);
        }
      }
    }

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      IExpr function = ast.arg1();
      IExpr xExpr = ast.arg2();
      // IBuiltInSymbol domain = S.Reals;
      if (xExpr.isVariable()) {
        try {
          VariablesSet vset = new VariablesSet(function);
          if (function.isNumericFunction(vset)) {
            FunctionDomainRealsVisitor domainVisitor = functionDomain(function, xExpr, engine);
            IAST resultInterval = domainVisitor.resultInterval;
            IAST notElementList = domainVisitor.notElementList;
            if (resultInterval.isPresent() && notElementList.isPresent()) {
              return intervalToRelation(resultInterval, notElementList, xExpr);
            }
          }
        } catch (ArgumentTypeStopException atse) {
          if (Config.SHOW_STACKTRACE) {
            atse.printStackTrace();
          }
          // Unable to find the domain with the available methods.
          return IOFunctions.printMessage(S.FunctionDomain, "nmet", F.CEmptyList, engine);
        }
      }
      return F.NIL;
    }

    public IExpr intervalToRelation(IAST interval, IAST notElementList, IExpr variable) {
      if (interval.isRealsIntervalData() && notElementList.argSize() == 0) {
        return S.True;
      }

      IASTAppendable andAST = F.ast(S.And, notElementList.argSize() + 2);
      andAST.appendArgs(notElementList);
      IASTAppendable orAST = F.ast(S.Or, interval.argSize());
      for (int i = 1; i < interval.size(); i++) {
        IAST list = (IAST) interval.get(i);
        if (list.isEmptyList() || list.argSize() != 4) {
          return S.False;
        }
        IASTAppendable andArg = andAST.copyAppendable();
        if (list.arg1().isNegativeInfinity()) {
          if (list.arg4().isInfinity()) {
            //
          } else if (list.arg3() == S.Less) {
            andArg.append(F.Less(variable, list.arg4()));
          } else if (list.arg3() == S.LessEqual) {
            andArg.append(F.LessEqual(variable, list.arg4()));
          }
        } else if (list.arg4().isInfinity()) {
          if (list.arg2() == S.Less) {
            andArg.append(F.Greater(variable, list.arg1()));
          } else if (list.arg2() == S.LessEqual) {
            andArg.append(F.GreaterEqual(variable, list.arg1()));
          }
        } else {
          andArg.append(F.binaryAST2(list.arg2(), list.arg1(), variable));
          andArg.append(F.binaryAST2(list.arg3(), variable, list.arg4()));
        }
        orAST.append(andArg);
      }
      return orAST;
    }


    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }


  }


  /**
   *
   *
   * <pre>
   * <code>Maximize(unary-function, variable)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * returns the maximum of the unary function for the given <code>variable</code>.
   *
   * </blockquote>
   *
   * <p>
   * See
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Derivative_test">Wikipedia - Derivative test</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; Maximize(-x^4-7*x^3+2*x^2 - 42,x)
   * {-42-7*(-21/8-Sqrt(505)/8)^3+2*(21/8+Sqrt(505)/8)^2-(21/8+Sqrt(505)/8)^4,{x-&gt;-21/8-Sqrt(505)/8}}
   * </code>
   * </pre>
   *
   * <p>
   * Print a message if no maximum can be found
   *
   * <pre>
   * <code>&gt;&gt; Maximize(x^4+7*x^3-2*x^2 + 42, x)
   * {Infinity,{x-&gt;-Infinity}}
   * </code>
   * </pre>
   *
   * <h3>Related terms</h3>
   *
   * <p>
   * <a href="Minimize.md">Minimize</a>
   */
  private static final class Maximize extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.size() == 3) {
        IExpr function = ast.arg1();
        IExpr x = ast.arg2();
        if (x.isAST(S.List, 2)) {
          x = ast.arg2().first();
        }
        ISymbol head = ast.topHead();
        if (x.isSymbol() || (x.isAST() && !x.isList())) {
          return maximize(head, function, x, engine);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }
  }


  /**
   *
   *
   * <pre>
   * <code>Minimize(unary-function, variable)
   * </code>
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * returns the minimum of the unary function for the given <code>variable</code>.
   *
   * </blockquote>
   *
   * <p>
   * See:
   *
   * <ul>
   * <li><a href="https://en.wikipedia.org/wiki/Derivative_test">Wikipedia - Derivative test</a>
   * </ul>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * <code>&gt;&gt; Minimize(x^4+7*x^3-2*x^2 + 42, x)
   * {42+7*(-21/8-Sqrt(505)/8)^3-2*(21/8+Sqrt(505)/8)^2+(21/8+Sqrt(505)/8)^4,{x-&gt;-21/8-Sqrt(505)/8}}
   * </code>
   * </pre>
   *
   * <h3>Related terms</h3>
   *
   * <p>
   * <a href="Maximize.md">Maximize</a>
   */
  private static final class Minimize extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      if (ast.size() == 3) {
        IExpr function = ast.arg1();
        IExpr x = ast.arg2();
        if (x.isAST(S.List, 2)) {
          x = ast.arg2().first();
        }
        ISymbol head = ast.topHead();
        if (x.isSymbol() || (x.isAST() && !x.isList())) {
          return minimize(head, function, x, engine);
        }
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }
  }


  /**
   *
   *
   * <pre>
   * NMaximize(maximize_function, constraints, variables_list)
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * the <code>NMaximize</code> function provides an implementation of
   * <a href="http://en.wikipedia.org/wiki/Simplex_algorithm">George Dantzig's simplex algorithm</a>
   * for solving linear optimization problems with linear equality and inequality constraints and
   * implicit non-negative variables.
   *
   * </blockquote>
   *
   * <p>
   * See:<br>
   *
   * <ul>
   * <li><a href="http://en.wikipedia.org/wiki/Linear_programming">Wikipedia - Linear
   * programming</a>
   * </ul>
   *
   * <p>
   * See also: <a href="LinearProgramming.md">LinearProgramming</a>,
   * <a href="NMinimize.md">NMinimize</a>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; NMaximize({-2*x+y-5, x+2*y&lt;=6 &amp;&amp; 3*x + 2*y &lt;= 12 }, {x, y})
   * {-2.0,{x-&gt;0.0,y-&gt;3.0}}
   * </pre>
   *
   * <p>
   * solves the linear problem:
   *
   * <pre>
   * Maximize -2x + y - 5
   * </pre>
   *
   * <p>
   * with the constraints:
   *
   * <pre>
   *   x  + 2y &lt;=  6
   *   3x + 2y &lt;= 12
   *         x &gt;= 0
   *         y &gt;= 0
   * </pre>
   */
  private static final class NMaximize extends NMinimize {

    @Override
    public IExpr numericEval(final IAST ast, EvalEngine engine) {
      try {
        if (ast.arg1().isList() && ast.arg2().isList()) {
          IAST list1 = (IAST) ast.arg1();
          IAST list2 = (IAST) ast.arg2();
          VariablesSet vars = new VariablesSet(list2);
          if (list1.isAST2()) {
            IExpr function = list1.arg1();
            IExpr listOfconstraints = list1.arg2();
            if (listOfconstraints.isAnd()) {
              // lc1 && lc2 && lc3...
              LinearObjectiveFunction objectiveFunction = getObjectiveFunction(vars, function);
              List<LinearConstraint> constraints = getConstraints(vars, (IAST) listOfconstraints);
              return simplexSolver(vars, objectiveFunction, objectiveFunction,
                  new LinearConstraintSet(constraints), GoalType.MAXIMIZE,
                  new NonNegativeConstraint(true), PivotSelectionRule.BLAND);
            }
          }
        }
      } catch (ValidateException ve) {
        return IOFunctions.printMessage(ast.topHead(), ve, engine);
      } catch (org.hipparchus.exception.MathRuntimeException e) {
        LOGGER.log(engine.getLogLevel(), ast.topHead(), e);
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }
  }


  /**
   *
   *
   * <pre>
   * NMinimize(coefficientsOfLinearObjectiveFunction, constraintList, constraintRelationList)
   * </pre>
   *
   * <blockquote>
   *
   * <p>
   * the <code>NMinimize</code> function provides an implementation of
   * <a href="http://en.wikipedia.org/wiki/Simplex_algorithm">George Dantzig's simplex algorithm</a>
   * for solving linear optimization problems with linear equality and inequality constraints and
   * implicit non-negative variables.
   *
   * </blockquote>
   *
   * <p>
   * See:<br>
   *
   * <ul>
   * <li><a href="http://en.wikipedia.org/wiki/Linear_programming">Wikipedia - Linear
   * programming</a>
   * </ul>
   *
   * <p>
   * See also: <a href="LinearProgramming.md">LinearProgramming</a>,
   * <a href="NMaximize.md">NMaximize</a>
   *
   * <h3>Examples</h3>
   *
   * <pre>
   * &gt;&gt; NMinimize({-2*x+y-5, x+2*y&lt;=6 &amp;&amp; 3*x + 2*y &lt;= 12}, {x, y})
   * {-13.0,{x-&gt;4.0,y-&gt;0.0}
   * </pre>
   *
   * <p>
   * solves the linear problem:
   *
   * <pre>
   * Minimize -2x + y - 5
   * </pre>
   *
   * <p>
   * with the constraints:
   *
   * <pre>
   *   x  + 2y &lt;=  6
   *   3x + 2y &lt;= 12
   *         x &gt;= 0
   *         y &gt;= 0
   * </pre>
   */
  private static class NMinimize extends AbstractFunctionEvaluator {

    @Override
    public IExpr evaluate(final IAST ast, EvalEngine engine) {
      // switch to numeric calculation
      return numericEval(ast, engine);
    }

    @Override
    public IExpr numericEval(final IAST ast, EvalEngine engine) {
      try {
        if (ast.arg1().isList() && ast.arg2().isList()) {
          IAST list1 = (IAST) ast.arg1();
          IAST list2 = (IAST) ast.arg2();
          VariablesSet vars = new VariablesSet(list2);
          if (list1.isAST2()) {
            IExpr function = list1.arg1();
            IExpr listOfconstraints = list1.arg2();
            if (listOfconstraints.isAnd()) {
              // lc1 && lc2 && lc3...
              LinearObjectiveFunction objectiveFunction = getObjectiveFunction(vars, function);
              List<LinearConstraint> constraints = getConstraints(vars, (IAST) listOfconstraints);
              return simplexSolver(vars, objectiveFunction, objectiveFunction,
                  new LinearConstraintSet(constraints), GoalType.MINIMIZE,
                  new NonNegativeConstraint(true), PivotSelectionRule.BLAND);
            }
          }
        }
      } catch (ValidateException ve) {
        return IOFunctions.printMessage(ast.topHead(), ve, engine);
      } catch (org.hipparchus.exception.MathRuntimeException e) {
        LOGGER.log(engine.getLogLevel(), ast.topHead(), e);
      }
      return F.NIL;
    }

    @Override
    public int[] expectedArgSize(IAST ast) {
      return ARGS_2_2;
    }

    protected static LinearObjectiveFunction getObjectiveFunction(VariablesSet vars,
        IExpr objectiveFunction) {
      Expr2LP x2LP = new Expr2LP(objectiveFunction, vars);
      return x2LP.expr2ObjectiveFunction();
    }

    protected static List<LinearConstraint> getConstraints(VariablesSet vars,
        IAST listOfconstraints) {
      List<LinearConstraint> constraints =
          new ArrayList<LinearConstraint>(listOfconstraints.size());
      listOfconstraints.forEach(x -> {
        Expr2LP x2LP = new Expr2LP(x, vars);
        constraints.add(x2LP.expr2Constraint());
      });
      return constraints;
    }

    protected static IExpr simplexSolver(VariablesSet vars, LinearObjectiveFunction f,
        OptimizationData... optData) throws org.hipparchus.exception.MathRuntimeException {
      SimplexSolver solver = new SimplexSolver();
      PointValuePair solution = solver.optimize(optData);
      double[] values = solution.getPointRef();
      List<IExpr> varList = vars.getArrayList();
      IASTAppendable list =
          F.mapRange(0, values.length, i -> F.Rule(varList.get(i), F.num(values[i])));
      IAST result = F.list(F.num(f.value(values)), list);
      return result;
    }
  }

  /**
   * Determine the domain of a function by creating {@link S.IntervalData} results for the
   * <code>function</code>.
   * 
   * @param function
   * @param xExpr
   * @param engine
   * @return {@link F#NIL} if the domain couldn't be determined by current methods
   */
  public static FunctionDomain.FunctionDomainRealsVisitor functionDomain(IExpr function,
      IExpr variable, EvalEngine engine) {
    FunctionDomain.FunctionDomainRealsVisitor visitor =
        new FunctionDomain.FunctionDomainRealsVisitor(engine, variable);
    function.accept(visitor);
    return visitor;
  }

  private static IExpr maximize(ISymbol head, IExpr function, IExpr x, EvalEngine engine) {
    try {
      IExpr temp = maximizeExprPolynomial(function, F.list(x));
      if (temp.isPresent()) {
        return temp;
      }

      IExpr yNInf = S.Limit.of(function, F.Rule(x, F.CNInfinity));
      if (yNInf.isInfinity()) {
        LOGGER.log(engine.getLogLevel(), "{}: the maximum cannot be found.", head);
        return F.list(F.CInfinity, F.list(F.Rule(x, F.CNInfinity)));
      }
      IExpr yInf = S.Limit.of(function, F.Rule(x, F.CInfinity));
      if (yInf.isInfinity()) {
        LOGGER.log(engine.getLogLevel(), "{}: the maximum cannot be found.", head);
        return F.list(F.CInfinity, F.list(F.Rule(x, F.CInfinity)));
      }

      IExpr first_derivative = S.D.of(engine, function, x);
      IExpr second_derivative = S.D.of(engine, first_derivative, x);
      IExpr candidates = S.Solve.of(engine, F.Equal(first_derivative, F.C0), x, S.Reals);
      if (candidates.isFree(S.Solve)) {
        IExpr maxCandidate = F.NIL;
        IExpr maxValue = F.CNInfinity;
        if (candidates.isListOfLists()) {
          for (int i = 1; i < candidates.size(); i++) {
            IExpr candidate = ((IAST) candidates).get(i).first().second();
            IExpr value = engine.evaluate(F.subs(second_derivative, x, candidate));
            if (value.isNegative()) {
              IExpr functionValue = engine.evaluate(F.subs(function, x, candidate));
              if (S.Greater.ofQ(functionValue, maxValue)) {
                maxValue = functionValue;
                maxCandidate = candidate;
              }
            }
          }
          if (maxCandidate.isPresent()) {
            return F.list(maxValue, F.list(F.Rule(x, maxCandidate)));
          }
        }
        return F.CEmptyList;
      }
    } catch (RuntimeException rex) {
      LOGGER.log(engine.getLogLevel(), head, rex);
    }
    return F.NIL;
  }

  private static IAST maximizeExprPolynomial(final IExpr expr, IAST varList) {
    IAST result = F.NIL;
    try {
      // try to generate a common expression polynomial
      ExprPolynomialRing ring = new ExprPolynomialRing(ExprRingFactory.CONST, varList);
      ExprPolynomial ePoly = ring.create(expr, false, false, false);
      ePoly = ePoly.multiplyByMinimumNegativeExponents();
      result = maximizeCubicPolynomial(ePoly, varList.arg1());

      // result = QuarticSolver.sortASTArguments(result);
      return result;
    } catch (ArithmeticException | JASConversionException e2) {
      LOGGER.debug("MinMaxFunctions.maximizeExprPolynomial() failed", e2);
    }
    return result;
  }

  private static IAST maximizeCubicPolynomial(ExprPolynomial polynomial, IExpr x) {
    long varDegree = polynomial.degree(0);
    IExpr a;
    IExpr b;
    IExpr c;
    IExpr d;
    IExpr e;
    if (varDegree <= 3) {
      // solve cubic or quadratic maximize:
      a = F.C0;
      b = F.C0;
      c = F.C0;
      d = F.C0;
      e = F.C0;
      for (ExprMonomial monomial : polynomial) {
        IExpr coeff = monomial.coefficient();
        long lExp = monomial.exponent().getVal(0);
        if (lExp == 4) {
          a = coeff;
        } else if (lExp == 3) {
          b = coeff;
        } else if (lExp == 2) {
          c = coeff;
        } else if (lExp == 1) {
          d = coeff;
        } else if (lExp == 0) {
          e = coeff;
        } else {
          throw new ArithmeticException("Maximize::Unexpected exponent value: " + lExp);
        }
      }
      if (a.isPossibleZero(false)) {
        if (b.isPossibleZero(false)) {
          // quadratic
          if (c.isPossibleZero(false)) {
            if (d.isPossibleZero(false)) {
              return F.list(e, F.CEmptyList);
            } else {
              // linear
              return F.list(F.Piecewise(F.list(F.list(e, F.Equal(d, F.C0))), F.CInfinity), F.list(
                  F.Rule(x, F.Piecewise(F.list(F.list(F.C0, F.Equal(d, F.C0))), S.Indeterminate))));
            }
          } else {
            return F
                .List(
                    F.Piecewise(
                        F.list(F.list(e, F.And(F.Equal(d, 0), F.LessEqual(c, 0))), F.list(
                                F.Times(F.C1D4, F.Power(c, -1),
                                    F.Plus(F.Times(-1, F.Power(d, 2)), F.Times(4, c, e))),
                                F.Or(F.And(F.Greater(d, 0), F.Less(c, 0)),
                                    F.And(F.Less(d, 0), F.Less(c, 0))))),
                        F.CInfinity),
                    F.list(F.Rule(x,
                        F.Piecewise(
                            F.list(F.list(F.Times(F.CN1D2, F.Power(c, -1), d),
                                    F.Or(F.And(F.Greater(d, 0), F.Less(c, 0)),
                                        F.And(F.Less(d, 0), F.Less(c, 0)))),
                                F.list(F.C0, F.And(F.Equal(d, 0), F.LessEqual(c, 0)))),
                            S.Indeterminate))));
          }
        } else {
          // cubic
          return F.list(
              F.Piecewise(
                  F.list(F.list(e,
                          F.Or(F.And(F.Equal(d, F.C0), F.Equal(c, F.C0), F.Equal(b, F.C0)),
                              F.And(F.Equal(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0)))),
                      F.list(
                          F.Times(F.C1D4, F.Power(c, F.CN1),
                              F.Plus(F.Negate(F.Sqr(d)), F.Times(F.C4, c, e))),
                          F.Or(F.And(F.Greater(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0)),
                              F.And(F.Less(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0))))),
                  F.oo),
              F.list(F.Rule(x,
                  F.Piecewise(
                      F.list(F.list(F.Times(F.CN1D2, F.Power(c, F.CN1), d),
                              F.Or(F.And(F.Greater(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0)),
                                  F.And(F.Less(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0)))),
                          F.list(F.C0,
                              F.Or(F.And(F.Equal(d, F.C0), F.Equal(c, F.C0), F.Equal(b, F.C0)),
                                  F.And(F.Equal(d, F.C0), F.Less(c, F.C0), F.Equal(b, F.C0))))),
                      F.Indeterminate))));
        }
      }
    }

    return F.NIL;
  }

  private static final IExpr minimize(ISymbol head, IExpr function, IExpr x, EvalEngine engine) {
    try {
      IExpr temp = minimizeExprPolynomial(function, F.list(x));
      if (temp.isPresent()) {
        return temp;
      }

      IExpr yNInf = S.Limit.of(function, F.Rule(x, F.CNInfinity));
      if (yNInf.isNegativeInfinity()) {
        LOGGER.log(engine.getLogLevel(), "{}: the maximum cannot be found.", head);
        return F.list(F.CNInfinity, F.list(F.Rule(x, F.CNInfinity)));
      }
      IExpr yInf = S.Limit.of(function, F.Rule(x, F.CInfinity));
      if (yInf.isNegativeInfinity()) {
        LOGGER.log(engine.getLogLevel(), "{}: the maximum cannot be found.", head);
        return F.list(F.CNInfinity, F.list(F.Rule(x, F.CInfinity)));
      }

      IExpr first_derivative = S.D.of(engine, function, x);
      IExpr second_derivative = S.D.of(engine, first_derivative, x);
      IExpr candidates = S.Solve.of(engine, F.Equal(first_derivative, F.C0), x, S.Reals);
      if (candidates.isFree(S.Solve)) {
        IExpr minCandidate = F.NIL;
        IExpr minValue = F.CInfinity;
        if (candidates.isListOfLists()) {
          for (int i = 1; i < candidates.size(); i++) {
            IExpr candidate = ((IAST) candidates).get(i).first().second();
            IExpr value = engine.evaluate(F.subs(second_derivative, x, candidate));
            if (value.isPositiveResult()) {
              IExpr functionValue = engine.evaluate(F.subs(function, x, candidate));
              if (S.Less.ofQ(functionValue, minValue)) {
                minValue = functionValue;
                minCandidate = candidate;
              }
            }
          }
          if (minCandidate.isPresent()) {
            return F.list(minValue, F.list(F.Rule(x, minCandidate)));
          }
        }
        return F.CEmptyList;
      }
    } catch (RuntimeException rex) {
      LOGGER.log(engine.getLogLevel(), head, rex);
    }
    return F.NIL;
  }

  private static IAST minimizeExprPolynomial(final IExpr expr, IAST varList) {
    IAST result = F.NIL;
    try {
      // try to generate a common expression polynomial
      ExprPolynomialRing ring = new ExprPolynomialRing(ExprRingFactory.CONST, varList);
      ExprPolynomial ePoly = ring.create(expr, false, false, false);
      ePoly = ePoly.multiplyByMinimumNegativeExponents();
      result = minimizeCubicPolynomial(ePoly, varList.arg1());

      // result = QuarticSolver.sortASTArguments(result);
      return result;
    } catch (ArithmeticException | JASConversionException e2) {
      LOGGER.debug("MinMaxFunctions.minimizeExprPolynomial() failed", e2);
    }
    return result;
  }

  private static IAST minimizeCubicPolynomial(ExprPolynomial polynomial, IExpr x) {
    long varDegree = polynomial.degree(0);
    IExpr a;
    IExpr b;
    IExpr c;
    IExpr d;
    IExpr e;
    if (varDegree <= 3) {
      // solve cubic or quadratic minimize:
      a = F.C0;
      b = F.C0;
      c = F.C0;
      d = F.C0;
      e = F.C0;
      for (ExprMonomial monomial : polynomial) {
        IExpr coeff = monomial.coefficient();
        long lExp = monomial.exponent().getVal(0);
        if (lExp == 4) {
          a = coeff;
        } else if (lExp == 3) {
          b = coeff;
        } else if (lExp == 2) {
          c = coeff;
        } else if (lExp == 1) {
          d = coeff;
        } else if (lExp == 0) {
          e = coeff;
        } else {
          throw new ArithmeticException("Minimize::Unexpected exponent value: " + lExp);
        }
      }
      if (a.isPossibleZero(false)) {
        if (b.isPossibleZero(false)) {
          // quadratic
          if (c.isPossibleZero(false)) {
            if (d.isPossibleZero(false)) {
              return F.list(e, F.CEmptyList);
            } else {
              // linear
              return F.list(F.Piecewise(F.list(F.list(e, F.Equal(d, F.C0))), F.CNInfinity), F.list(
                  F.Rule(x, F.Piecewise(F.list(F.list(F.C0, F.Equal(d, F.C0))), S.Indeterminate))));
            }
          } else {
            return F
                .List(
                    F.Piecewise(
                        F.list(F.list(e, F.And(F.Equal(d, 0),
                                F.GreaterEqual(c, 0))),
                            F.list(
                                F.Times(
                                    F.C1D4, F.Power(c, -1), F.Plus(F.Times(-1, F.Power(d, 2)),
                                        F.Times(4, c, e))),
                                F.Or(F.And(F.Greater(d, 0), F.Greater(c, 0)),
                                    F.And(F.Less(d, 0), F.Greater(c, 0))))),
                        F.CNInfinity),
                    F.list(F.Rule(x,
                        F.Piecewise(
                            F.list(F.list(F.Times(F.CN1D2, F.Power(c, -1), d),
                                    F.Or(F.And(F.Greater(d, 0), F.Greater(c, 0)),
                                        F.And(F.Less(d, 0), F.Greater(c, 0)))),
                                F.list(F.C0, F.And(F.Equal(d, 0), F.GreaterEqual(c, 0)))),
                            S.Indeterminate))));
          }
        } else {
          // cubic
          return F.list(
              F.Piecewise(
                  F.list(F.list(e,
                          F.Or(F.And(F.Equal(d, F.C0), F.Equal(c, F.C0), F.Equal(b, F.C0)),
                              F.And(F.Equal(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0)))),
                      F.list(
                          F.Times(F.C1D4, F.Power(c, F.CN1),
                              F.Plus(F.Negate(F.Sqr(d)), F.Times(F.C4, c, e))),
                          F.Or(F.And(F.Greater(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0)),
                              F.And(F.Less(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0))))),
                  F.Noo),
              F.list(F.Rule(x,
                  F.Piecewise(
                      F.list(F.list(F.Times(F.CN1D2, F.Power(c, F.CN1), d),
                              F.Or(F.And(F.Greater(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0)),
                                  F.And(F.Less(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0)))),
                          F.list(F.C0,
                              F.Or(F.And(F.Equal(d, F.C0), F.Equal(c, F.C0), F.Equal(b, F.C0)),
                                  F.And(F.Equal(d, F.C0), F.Greater(c, F.C0), F.Equal(b, F.C0))))),
                      F.Indeterminate))));
        }
      }
    }

    return F.NIL;
  }

  public static void initialize() {
    Initializer.init();
  }

  private MinMaxFunctions() {}
}
