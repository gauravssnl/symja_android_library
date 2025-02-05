package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface InterquartileRangeRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 1, 4 };

  final public static IAST RULES = List(
    IInit(InterquartileRange, SIZES),
    // InterquartileRange(BernoulliDistribution(n_)):=Piecewise({{1,1/4<n<=3/4}},0)
    ISetDelayed(InterquartileRange(BernoulliDistribution(n_)),
      Piecewise(list(list(C1,And(Less(C1D4,n),LessEqual(n,QQ(3L,4L))))),C0)),
    // InterquartileRange(ExponentialDistribution(n_))=Log(3)/n
    ISet(InterquartileRange(ExponentialDistribution(n_)),
      Times(Power(n,CN1),Log(C3))),
    // InterquartileRange(GumbelDistribution()):=Log(Log(4)/Log(4/3))
    ISetDelayed(InterquartileRange(GumbelDistribution()),
      Log(Times(Power(Log(QQ(4L,3L)),CN1),Log(C4)))),
    // InterquartileRange(GumbelDistribution(n_,m_)):=m*Log(Log(4)/Log(4/3))
    ISetDelayed(InterquartileRange(GumbelDistribution(n_,m_)),
      Times(m,Log(Times(Power(Log(QQ(4L,3L)),CN1),Log(C4))))),
    // InterquartileRange(NormalDistribution(n_,m_)):=2*Sqrt(2)*m*InverseErfc(1/2)
    ISetDelayed(InterquartileRange(NormalDistribution(n_,m_)),
      Times(C2,CSqrt2,m,InverseErfc(C1D2)))
  );
}
