package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface FunctionRangeRules {
  final public static IAST RULES = List(
    // FunctionRange(LogIntegral(x_),x_,y_):=True
    SetDelayed(FunctionRange(LogIntegral(x_),x_,y_),
      True),
    // FunctionRange(ExpIntegralEi(x_),x_,y_):=True
    SetDelayed(FunctionRange(ExpIntegralEi(x_),x_,y_),
      True),
    // FunctionRange(Re(x_),x_,y_):=True
    SetDelayed(FunctionRange(Re(x_),x_,y_),
      True),
    // FunctionRange(Re(x_),x_,y_,Complexes):=Im(y)==0
    SetDelayed(FunctionRange(Re(x_),x_,y_,Complexes),
      Equal(Im(y),C0)),
    // FunctionRange(Im(x_),x_,y_):=y==0
    SetDelayed(FunctionRange(Im(x_),x_,y_),
      Equal(y,C0)),
    // FunctionRange(Im(x_),x_,y_,Complexes):=Im(y)==0
    SetDelayed(FunctionRange(Im(x_),x_,y_,Complexes),
      Equal(Im(y),C0))
  );
}
