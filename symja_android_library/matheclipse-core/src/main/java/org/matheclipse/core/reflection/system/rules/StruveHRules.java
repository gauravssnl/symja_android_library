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
public interface StruveHRules {
  /**
   *
   *
   * <ul>
   *   <li>index 0 - number of equal rules in <code>RULES</code>
   * </ul>
   */
  public static final int[] SIZES = {0, 3};

  public static final IAST RULES =
      List(
          IInit(StruveH, SIZES),
          // StruveH(-1/2,z_):=Sqrt(2/(Pi*z))*Sin(z)
          ISetDelayed(StruveH(CN1D2, z_), Times(Sqrt(Times(C2, Power(Times(Pi, z), CN1))), Sin(z))),
          // StruveH(1/2,z_):=Sqrt(2/(Pi*z))*(1-Cos(z))
          ISetDelayed(
              StruveH(C1D2, z_),
              Times(Sqrt(Times(C2, Power(Times(Pi, z), CN1))), Subtract(C1, Cos(z)))),
          // StruveH(Undefined,y_):=Undefined
          ISetDelayed(StruveH(Undefined, y_), Undefined),
          // StruveH(x_,Undefined):=Undefined
          ISetDelayed(StruveH(x_, Undefined), Undefined));
}
