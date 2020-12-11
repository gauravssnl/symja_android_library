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
public interface CosRules {
  /**
   *
   *
   * <ul>
   *   <li>index 0 - number of equal rules in <code>RULES</code>
   * </ul>
   */
  public static final int[] SIZES = {56, 12};

  public static final IAST RULES =
      List(
          IInit(Cos, SIZES),
          // Cos(Undefined)=Undefined
          ISet(Cos(Undefined), Undefined),
          // Cos(0)=1
          ISet(Cos(C0), C1),
          // Cos(Pi/12)=(1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(1L, 12L), Pi)), Times(C1D2, C1DSqrt2, Plus(C1, CSqrt3))),
          // Cos(Pi/10)=Sqrt(1/2*(5+Sqrt(5)))/2
          ISet(Cos(Times(QQ(1L, 10L), Pi)), Times(C1D2, Sqrt(Times(C1D2, Plus(C5, CSqrt5))))),
          // Cos(Pi/8)=Sqrt(2+Sqrt(2))/2
          ISet(Cos(Times(QQ(1L, 8L), Pi)), Times(C1D2, Sqrt(Plus(C2, CSqrt2)))),
          // Cos(Pi/6)=Sqrt(3)/2
          ISet(Cos(Times(QQ(1L, 6L), Pi)), Times(C1D2, CSqrt3)),
          // Cos(Pi/5)=1/4*(Sqrt(5)+1)
          ISet(Cos(Times(QQ(1L, 5L), Pi)), Times(C1D4, Plus(C1, CSqrt5))),
          // Cos(Pi/4)=1/Sqrt(2)
          ISet(Cos(Times(C1D4, Pi)), C1DSqrt2),
          // Cos(3/10*Pi)=Sqrt(1/2*(5-Sqrt(5)))/2
          ISet(Cos(Times(QQ(3L, 10L), Pi)), Times(C1D2, Sqrt(Times(C1D2, Subtract(C5, CSqrt5))))),
          // Cos(Pi/3)=1/2
          ISet(Cos(Times(C1D3, Pi)), C1D2),
          // Cos(3/8*Pi)=Sqrt(2-Sqrt(2))/2
          ISet(Cos(Times(QQ(3L, 8L), Pi)), Times(C1D2, Sqrt(Subtract(C2, CSqrt2)))),
          // Cos(2/5*Pi)=1/4*(-1+Sqrt(5))
          ISet(Cos(Times(QQ(2L, 5L), Pi)), Times(C1D4, Plus(CN1, CSqrt5))),
          // Cos(5/12*Pi)=(-1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(5L, 12L), Pi)), Times(C1D2, C1DSqrt2, Plus(CN1, CSqrt3))),
          // Cos(Pi/2)=0
          ISet(Cos(CPiHalf), C0),
          // Cos(7/12*Pi)=-(-1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(7L, 12L), Pi)), Times(C1D2, C1DSqrt2, Subtract(C1, CSqrt3))),
          // Cos(3/5*Pi)=-(-1+Sqrt(5))/4
          ISet(Cos(Times(QQ(3L, 5L), Pi)), Times(C1D4, Subtract(C1, CSqrt5))),
          // Cos(5/8*Pi)=-Sqrt(2-Sqrt(2))/2
          ISet(Cos(Times(QQ(5L, 8L), Pi)), Times(CN1D2, Sqrt(Subtract(C2, CSqrt2)))),
          // Cos(2/3*Pi)=-1/2
          ISet(Cos(Times(QQ(2L, 3L), Pi)), CN1D2),
          // Cos(7/10*Pi)=-Sqrt(1/2*(5-Sqrt(5)))/2
          ISet(Cos(Times(QQ(7L, 10L), Pi)), Times(CN1D2, Sqrt(Times(C1D2, Subtract(C5, CSqrt5))))),
          // Cos(3/4*Pi)=-1/Sqrt(2)
          ISet(Cos(Times(QQ(3L, 4L), Pi)), Negate(C1DSqrt2)),
          // Cos(4/5*Pi)=-(Sqrt(5)+1)/4
          ISet(Cos(Times(QQ(4L, 5L), Pi)), Times(C1D4, Subtract(CN1, CSqrt5))),
          // Cos(5/6*Pi)=-Sqrt(3)/2
          ISet(Cos(Times(QQ(5L, 6L), Pi)), Times(CN1D2, CSqrt3)),
          // Cos(7/8*Pi)=-Sqrt(2+Sqrt(2))/2
          ISet(Cos(Times(QQ(7L, 8L), Pi)), Times(CN1D2, Sqrt(Plus(C2, CSqrt2)))),
          // Cos(9/10*Pi)=-Sqrt(1/2*(5+Sqrt(5)))/2
          ISet(Cos(Times(QQ(9L, 10L), Pi)), Times(CN1D2, Sqrt(Times(C1D2, Plus(C5, CSqrt5))))),
          // Cos(11/12*Pi)=-(1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(11L, 12L), Pi)), Times(C1D2, C1DSqrt2, Subtract(CN1, CSqrt3))),
          // Cos(Pi)=-1
          ISet(Cos(Pi), CN1),
          // Cos(13/12*Pi)=-(1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(13L, 12L), Pi)), Times(C1D2, C1DSqrt2, Subtract(CN1, CSqrt3))),
          // Cos(11/10*Pi)=-Sqrt(1/2*(5+Sqrt(5)))/2
          ISet(Cos(Times(QQ(11L, 10L), Pi)), Times(CN1D2, Sqrt(Times(C1D2, Plus(C5, CSqrt5))))),
          // Cos(9/8*Pi)=-Sqrt(2+Sqrt(2))/2
          ISet(Cos(Times(QQ(9L, 8L), Pi)), Times(CN1D2, Sqrt(Plus(C2, CSqrt2)))),
          // Cos(7/6*Pi)=-Sqrt(3)/2
          ISet(Cos(Times(QQ(7L, 6L), Pi)), Times(CN1D2, CSqrt3)),
          // Cos(6/5*Pi)=-(Sqrt(5)+1)/4
          ISet(Cos(Times(QQ(6L, 5L), Pi)), Times(C1D4, Subtract(CN1, CSqrt5))),
          // Cos(5/4*Pi)=-1/Sqrt(2)
          ISet(Cos(Times(QQ(5L, 4L), Pi)), Negate(C1DSqrt2)),
          // Cos(13/10*Pi)=-Sqrt(1/2*(5-Sqrt(5)))/2
          ISet(Cos(Times(QQ(13L, 10L), Pi)), Times(CN1D2, Sqrt(Times(C1D2, Subtract(C5, CSqrt5))))),
          // Cos(4/3*Pi)=-1/2
          ISet(Cos(Times(QQ(4L, 3L), Pi)), CN1D2),
          // Cos(11/8*Pi)=-Sqrt(2-Sqrt(2))/2
          ISet(Cos(Times(QQ(11L, 8L), Pi)), Times(CN1D2, Sqrt(Subtract(C2, CSqrt2)))),
          // Cos(7/5*Pi)=-(-1+Sqrt(5))/4
          ISet(Cos(Times(QQ(7L, 5L), Pi)), Times(C1D4, Subtract(C1, CSqrt5))),
          // Cos(17/12*Pi)=-(-1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(17L, 12L), Pi)), Times(C1D2, C1DSqrt2, Subtract(C1, CSqrt3))),
          // Cos(3/2*Pi)=0
          ISet(Cos(Times(QQ(3L, 2L), Pi)), C0),
          // Cos(19/12*Pi)=(-1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(19L, 12L), Pi)), Times(C1D2, C1DSqrt2, Plus(CN1, CSqrt3))),
          // Cos(8/5*Pi)=1/4*(-1+Sqrt(5))
          ISet(Cos(Times(QQ(8L, 5L), Pi)), Times(C1D4, Plus(CN1, CSqrt5))),
          // Cos(13/8*Pi)=Sqrt(2-Sqrt(2))/2
          ISet(Cos(Times(QQ(13L, 8L), Pi)), Times(C1D2, Sqrt(Subtract(C2, CSqrt2)))),
          // Cos(5/3*Pi)=1/2
          ISet(Cos(Times(QQ(5L, 3L), Pi)), C1D2),
          // Cos(17/10*Pi)=Sqrt(1/2*(5-Sqrt(5)))/2
          ISet(Cos(Times(QQ(17L, 10L), Pi)), Times(C1D2, Sqrt(Times(C1D2, Subtract(C5, CSqrt5))))),
          // Cos(7/4*Pi)=1/Sqrt(2)
          ISet(Cos(Times(QQ(7L, 4L), Pi)), C1DSqrt2),
          // Cos(9/5*Pi)=1/4*(Sqrt(5)+1)
          ISet(Cos(Times(QQ(9L, 5L), Pi)), Times(C1D4, Plus(C1, CSqrt5))),
          // Cos(11/6*Pi)=Sqrt(3)/2
          ISet(Cos(Times(QQ(11L, 6L), Pi)), Times(C1D2, CSqrt3)),
          // Cos(15/8*Pi)=Sqrt(2+Sqrt(2))/2
          ISet(Cos(Times(QQ(15L, 8L), Pi)), Times(C1D2, Sqrt(Plus(C2, CSqrt2)))),
          // Cos(19/10*Pi)=Sqrt(1/2*(5+Sqrt(5)))/2
          ISet(Cos(Times(QQ(19L, 10L), Pi)), Times(C1D2, Sqrt(Times(C1D2, Plus(C5, CSqrt5))))),
          // Cos(23/12*Pi)=(1+Sqrt(3))/(2*Sqrt(2))
          ISet(Cos(Times(QQ(23L, 12L), Pi)), Times(C1D2, C1DSqrt2, Plus(C1, CSqrt3))),
          // Cos(2*Pi)=1
          ISet(Cos(C2Pi), C1),
          // Cos(I)=Cosh(1)
          ISet(Cos(CI), Cosh(C1)),
          // Cos(ArcSin(x_)):=Sqrt(1-x^2)
          ISetDelayed(Cos(ArcSin(x_)), Sqrt(Subtract(C1, Sqr(x)))),
          // Cos(2*ArcSin(x_)):=1-2*x^2
          ISetDelayed(Cos(Times(C2, ArcSin(x_))), Plus(C1, Times(CN2, Sqr(x)))),
          // Cos(ArcCos(x_)):=x
          ISetDelayed(Cos(ArcCos(x_)), x),
          // Cos(2*ArcCos(x_)):=-1+2*x^2
          ISetDelayed(Cos(Times(C2, ArcCos(x_))), Plus(CN1, Times(C2, Sqr(x)))),
          // Cos(ArcTan(x_)):=1/Sqrt(1+x^2)
          ISetDelayed(Cos(ArcTan(x_)), Power(Plus(C1, Sqr(x)), CN1D2)),
          // Cos(2*ArcTan(x_)):=(1-x^2)/(1+x^2)
          ISetDelayed(
              Cos(Times(C2, ArcTan(x_))),
              Times(Subtract(C1, Sqr(x)), Power(Plus(C1, Sqr(x)), CN1))),
          // Cos(ArcCot(x_)):=1/Sqrt(1+1/x^2)
          ISetDelayed(Cos(ArcCot(x_)), Power(Plus(C1, Power(x, CN2)), CN1D2)),
          // Cos(2*ArcCot(x_)):=(-1+x^2)/(1+x^2)
          ISetDelayed(
              Cos(Times(C2, ArcCot(x_))), Times(Plus(CN1, Sqr(x)), Power(Plus(C1, Sqr(x)), CN1))),
          // Cos(ArcCsc(x_)):=Sqrt(1-1/x^2)
          ISetDelayed(Cos(ArcCsc(x_)), Sqrt(Subtract(C1, Power(x, CN2)))),
          // Cos(2*ArcCsc(x_)):=(-2+x^2)/x^2
          ISetDelayed(Cos(Times(C2, ArcCsc(x_))), Times(Power(x, CN2), Plus(CN2, Sqr(x)))),
          // Cos(ArcSec(x_)):=1/x
          ISetDelayed(Cos(ArcSec(x_)), Power(x, CN1)),
          // Cos(2*ArcSec(x_)):=(2-x^2)/x^2
          ISetDelayed(Cos(Times(C2, ArcSec(x_))), Times(Power(x, CN2), Subtract(C2, Sqr(x)))),
          // Cos(I*Infinity)=Infinity
          ISet(Cos(DirectedInfinity(CI)), oo),
          // Cos(-I*Infinity)=Infinity
          ISet(Cos(DirectedInfinity(CNI)), oo),
          // Cos(ComplexInfinity)=Indeterminate
          ISet(Cos(CComplexInfinity), Indeterminate),
          // Cos(Infinity)=Interval({-1,1})
          ISet(Cos(oo), Interval(List(CN1, C1))),
          // Cos(-Infinity)=Interval({-1,1})
          ISet(Cos(Noo), Interval(List(CN1, C1))));
}
