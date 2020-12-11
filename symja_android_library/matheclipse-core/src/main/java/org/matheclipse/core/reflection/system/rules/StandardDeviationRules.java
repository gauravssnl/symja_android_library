package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.
 *
 * <p>See GIT repository at: <a
 * href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under
 * the tools directory</a>.
 */
public interface StandardDeviationRules {
  /**
   *
   *
   * <ul>
   *   <li>index 0 - number of equal rules in <code>RULES</code>
   * </ul>
   */
  public static final int[] SIZES = {0, 2};

  public static final IAST RULES =
      List(
          IInit(StandardDeviation, SIZES),
          // StandardDeviation(NormalDistribution()):=1
          ISetDelayed(StandardDeviation(NormalDistribution()), C1),
          // StandardDeviation(NormalDistribution(m_,s_)):=s
          ISetDelayed(StandardDeviation(NormalDistribution(m_, s_)), s));
}
