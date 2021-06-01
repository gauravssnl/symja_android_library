package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface DRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 135 };

  final public static IAST RULES = List(
    IInit(D, SIZES),
    // D(Integrate(f_,x_),x_?NotListQ):=f
    ISetDelayed(D(Integrate(f_,x_),PatternTest(x_,NotListQ)),
      f),
    // D(Abs(f_),x_?NotListQ):=D(f,x)*x/Abs(x)/;x∈Reals
    ISetDelayed(D(Abs(f_),PatternTest(x_,NotListQ)),
      Condition(Times(D(f,x),x,Power(Abs(x),CN1)),Element(x,Reals))),
    // D(AiryAi(f_),x_?NotListQ):=D(f,x)*AiryAiPrime(f)
    ISetDelayed(D(AiryAi(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),AiryAiPrime(f))),
    // D(AiryAiPrime(f_),x_?NotListQ):=D(f,x)*AiryAi(f)*f
    ISetDelayed(D(AiryAiPrime(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),AiryAi(f),f)),
    // D(AiryBi(f_),x_?NotListQ):=D(f,x)*AiryBiPrime(f)
    ISetDelayed(D(AiryBi(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),AiryBiPrime(f))),
    // D(AiryBiPrime(f_),x_?NotListQ):=D(f,x)*AiryBi(f)*f
    ISetDelayed(D(AiryBiPrime(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),AiryBi(f),f)),
    // D(ArcCos(f_),x_?NotListQ):=(D(f,x)*(-1))/Sqrt(1-f^2)
    ISetDelayed(D(ArcCos(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Power(Subtract(C1,Sqr(f)),CN1D2))),
    // D(ArcCosh(f_),x_?NotListQ):=D(f,x)/Sqrt(-1+f^2)
    ISetDelayed(D(ArcCosh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Plus(CN1,Sqr(f)),CN1D2))),
    // D(ArcCot(f_),x_?NotListQ):=(D(f,x)*(-1))/(1+f^2)
    ISetDelayed(D(ArcCot(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Power(Plus(C1,Sqr(f)),CN1))),
    // D(ArcCoth(f_),x_?NotListQ):=D(f,x)/(1-f^2)
    ISetDelayed(D(ArcCoth(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Subtract(C1,Sqr(f)),CN1))),
    // D(ArcCsc(f_),x_?NotListQ):=(-D(f,x)*1)/(f^2*Sqrt(1-1/x^2))
    ISetDelayed(D(ArcCsc(f_),PatternTest(x_,NotListQ)),
      Times(CN1,D(f,x),C1,Power(f,CN2),Power(Subtract(C1,Power(x,CN2)),CN1D2))),
    // D(ArcCsch(f_),x_?NotListQ):=(D(f,x)*(-1))/(Abs(f)*Sqrt(1+f^2))
    ISetDelayed(D(ArcCsch(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Power(Abs(f),CN1),Power(Plus(C1,Sqr(f)),CN1D2))),
    // D(ArcSin(f_),x_?NotListQ):=D(f,x)/Sqrt(1-f^2)
    ISetDelayed(D(ArcSin(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Subtract(C1,Sqr(f)),CN1D2))),
    // D(ArcSinh(f_),x_?NotListQ):=D(f,x)/Sqrt(1+f^2)
    ISetDelayed(D(ArcSinh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Plus(C1,Sqr(f)),CN1D2))),
    // D(ArcTan(f_),x_?NotListQ):=D(f,x)/(1+f^2)
    ISetDelayed(D(ArcTan(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Plus(C1,Sqr(f)),CN1))),
    // D(ArcTanh(f_),x_?NotListQ):=D(f,x)/(1-f^2)
    ISetDelayed(D(ArcTanh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(Subtract(C1,Sqr(f)),CN1))),
    // D(ArcSec(f_),x_?NotListQ):=D(f,x)/(x^2*Sqrt(1-1/f^2))
    ISetDelayed(D(ArcSec(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(x,CN2),Power(Subtract(C1,Power(f,CN2)),CN1D2))),
    // D(ArcSech(f_),x_?NotListQ):=(D(f,x)*(-1))/(f*Sqrt(1-f^2))
    ISetDelayed(D(ArcSech(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Power(f,CN1),Power(Subtract(C1,Sqr(f)),CN1D2))),
    // D(Ceiling(f_),x_?NotListQ):=D(f,x)*Piecewise({{0,f<Ceiling(f)}},Indeterminate)
    ISetDelayed(D(Ceiling(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Piecewise(List(List(C0,Less(f,Ceiling(f)))),Indeterminate))),
    // D(EllipticE(f_),x_?NotListQ):=(D(f,x)*(EllipticE(f)-EllipticK(f)))/(2*f)
    ISetDelayed(D(EllipticE(f_),PatternTest(x_,NotListQ)),
      Times(Power(Times(C2,f),CN1),D(f,x),Subtract(EllipticE(f),EllipticK(f)))),
    // D(EllipticK(f_),x_?NotListQ):=(D(f,x)*(EllipticE(f)-(1-f)*EllipticK(f)))/(2*(1-f)*f)
    ISetDelayed(D(EllipticK(f_),PatternTest(x_,NotListQ)),
      Times(Power(Times(C2,Subtract(C1,f),f),CN1),D(f,x),Plus(EllipticE(f),Times(CN1,Subtract(C1,f),EllipticK(f))))),
    // D(Erf(f_),x_?NotListQ):=D(f,x)*2*1/(E^f^2*Sqrt(Pi))
    ISetDelayed(D(Erf(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),C2,Exp(Negate(Sqr(f))),Power(Pi,CN1D2))),
    // D(Erfc(f_),x_?NotListQ):=D(f,x)*-2*1/(E^f^2*Sqrt(Pi))
    ISetDelayed(D(Erfc(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN2,Exp(Negate(Sqr(f))),Power(Pi,CN1D2))),
    // D(Erfi(f_),x_?NotListQ):=D(f,x)*2*E^f^2/Sqrt(Pi)
    ISetDelayed(D(Erfi(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),C2,Exp(Sqr(f)),Power(Pi,CN1D2))),
    // D(ExpIntegralEi(f_),x_?NotListQ):=D(f,x)*E^f/f
    ISetDelayed(D(ExpIntegralEi(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Exp(f),Power(f,CN1))),
    // D(f_!,x_?NotListQ):=D(f,x)*Gamma(1+f)*PolyGamma(0,1+f)
    ISetDelayed(D(Factorial(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Gamma(Plus(C1,f)),PolyGamma(C0,Plus(C1,f)))),
    // D(Floor(f_),x_?NotListQ):=D(f,x)*Piecewise({{0,f>Floor(f)}},Indeterminate)
    ISetDelayed(D(Floor(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Piecewise(List(List(C0,Greater(f,Floor(f)))),Indeterminate))),
    // D(FractionalPart(f_),x_?NotListQ):=D(f,x)*1
    ISetDelayed(D(FractionalPart(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),C1)),
    // D(FresnelC(f_),x_?NotListQ):=D(f,x)*Cos(1/2*f^2*Pi)
    ISetDelayed(D(FresnelC(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Cos(Times(C1D2,Sqr(f),Pi)))),
    // D(FresnelS(f_),x_?NotListQ):=D(f,x)*Sin(1/2*f^2*Pi)
    ISetDelayed(D(FresnelS(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sin(Times(C1D2,Sqr(f),Pi)))),
    // D(Gamma(f_),x_?NotListQ):=D(f,x)*Gamma(f)*PolyGamma(f)
    ISetDelayed(D(Gamma(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Gamma(f),PolyGamma(f))),
    // D(Gudermannian(f_),x_?NotListQ):=Sech(f)*D(f,x)
    ISetDelayed(D(Gudermannian(f_),PatternTest(x_,NotListQ)),
      Times(Sech(f),D(f,x))),
    // D(HarmonicNumber(f_),x_?NotListQ):=D(f,x)*(Pi^2/6-HarmonicNumber(f,2))
    ISetDelayed(D(HarmonicNumber(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Subtract(Times(QQ(1L,6L),Sqr(Pi)),HarmonicNumber(f,C2)))),
    // D(HarmonicNumber(f_,g_),x_?NotListQ):=D(f,x)*g*(-HarmonicNumber(f,1+g)+Zeta(1+g))/;FreeQ({g},x)
    ISetDelayed(D(HarmonicNumber(f_,g_),PatternTest(x_,NotListQ)),
      Condition(Times(D(f,x),g,Plus(Negate(HarmonicNumber(f,Plus(C1,g))),Zeta(Plus(C1,g)))),FreeQ(List(g),x))),
    // D(Haversine(f_),x_?NotListQ):=1/2*Sin(f)*D(f,x)
    ISetDelayed(D(Haversine(f_),PatternTest(x_,NotListQ)),
      Times(C1D2,Sin(f),D(f,x))),
    // D(HeavisideTheta(f_),x_?NotListQ):=D(f,x)*DiracDelta(f)
    ISetDelayed(D(HeavisideTheta(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),DiracDelta(f))),
    // D(IntegerPart(f_),x_?NotListQ):=0
    ISetDelayed(D(IntegerPart(f_),PatternTest(x_,NotListQ)),
      C0),
    // D(InverseErf(f_),x_?NotListQ):=D(f,x)*1/2*Sqrt(Pi)*E^InverseErf(f)^2
    ISetDelayed(D(InverseErf(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),C1D2,Sqrt(Pi),Exp(Sqr(InverseErf(f))))),
    // D(InverseErfc(f_),x_?NotListQ):=D(f,x)*(-1/2)*E^InverseErfc(f)^2*Sqrt(Pi)
    ISetDelayed(D(InverseErfc(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1D2,Exp(Sqr(InverseErfc(f))),Sqrt(Pi))),
    // D(InverseHaversine(f_),x_?NotListQ):=D(f,x)/Sqrt((1-f)*f)
    ISetDelayed(D(InverseHaversine(f_),PatternTest(x_,NotListQ)),
      Times(Power(Times(Subtract(C1,f),f),CN1D2),D(f,x))),
    // D(InverseGudermannian(f_),x_?NotListQ):=Sec(f)*D(f,x)
    ISetDelayed(D(InverseGudermannian(f_),PatternTest(x_,NotListQ)),
      Times(Sec(f),D(f,x))),
    // D(Log(f_),x_?NotListQ):=D(f,x)/f
    ISetDelayed(D(Log(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(f,CN1))),
    // D(LogGamma(f_),x_?NotListQ):=D(f,x)*PolyGamma(0,f)
    ISetDelayed(D(LogGamma(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),PolyGamma(C0,f))),
    // D(LogisticSigmoid(f_),x_?NotListQ):=D(f,x)*LogisticSigmoid(f)*(1-LogisticSigmoid(f))
    ISetDelayed(D(LogisticSigmoid(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),LogisticSigmoid(f),Subtract(C1,LogisticSigmoid(f)))),
    // D(PolyGamma(0,f_),x_?NotListQ):=D(f,x)*PolyGamma(1,f)
    ISetDelayed(D(PolyGamma(C0,f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),PolyGamma(C1,f))),
    // D(Cot(f_),x_?NotListQ):=D(f,x)*(-1)*Csc(f)^2
    ISetDelayed(D(Cot(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Sqr(Csc(f)))),
    // D(Coth(f_),x_?NotListQ):=(D(f,x)*(-1))/Sinh(f)^2
    ISetDelayed(D(Coth(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Power(Sinh(f),CN2))),
    // D(Cos(f_),x_?NotListQ):=D(f,x)*(-1)*Sin(f)
    ISetDelayed(D(Cos(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Sin(f))),
    // D(Cosh(f_),x_?NotListQ):=D(f,x)*Sinh(f)
    ISetDelayed(D(Cosh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sinh(f))),
    // D(Csc(f_),x_?NotListQ):=D(f,x)*(-1)*Cot(f)*Csc(f)
    ISetDelayed(D(Csc(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Cot(f),Csc(f))),
    // D(Csch(f_),x_?NotListQ):=D(f,x)*(-1)*Coth(f)*Csch(f)
    ISetDelayed(D(Csch(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Coth(f),Csch(f))),
    // D(Round(f_),x_?NotListQ):=D(f,x)*Piecewise({{0,NotElement(-1/2+Re(f),Integers)&&NotElement(-1/2+Im(f),Integers)}},Indeterminate)
    ISetDelayed(D(Round(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Piecewise(List(List(C0,And(NotElement(Plus(CN1D2,Re(f)),Integers),NotElement(Plus(CN1D2,Im(f)),Integers)))),Indeterminate))),
    // D(Sin(f_),x_?NotListQ):=D(f,x)*Cos(f)
    ISetDelayed(D(Sin(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Cos(f))),
    // D(Sinc(f_),x_?NotListQ):=D(f,x)*(Cos(f)/f-Sin(f)/f^2)
    ISetDelayed(D(Sinc(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Plus(Times(Power(f,CN1),Cos(f)),Times(CN1,Power(f,CN2),Sin(f))))),
    // D(Sinh(f_),x_?NotListQ):=D(f,x)*Cosh(f)
    ISetDelayed(D(Sinh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Cosh(f))),
    // D(Tan(f_),x_?NotListQ):=D(f,x)*Sec(f)^2
    ISetDelayed(D(Tan(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sqr(Sec(f)))),
    // D(Tanh(f_),x_?NotListQ):=D(f,x)*Sech(f)^2
    ISetDelayed(D(Tanh(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sqr(Sech(f)))),
    // D(Sec(f_),x_?NotListQ):=D(f,x)*Sec(f)*Tan(f)
    ISetDelayed(D(Sec(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sec(f),Tan(f))),
    // D(Sech(f_),x_?NotListQ):=D(f,x)*(-1)*Tanh(f)*Sech(f)
    ISetDelayed(D(Sech(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),CN1,Tanh(f),Sech(f))),
    // D(CosIntegral(f_),x_?NotListQ):=D(f,x)*Cos(f)/f
    ISetDelayed(D(CosIntegral(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(f,CN1),Cos(f))),
    // D(CoshIntegral(f_),x_?NotListQ):=D(f,x)*Cosh(f)/f
    ISetDelayed(D(CoshIntegral(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(f,CN1),Cosh(f))),
    // D(SinIntegral(f_),x_?NotListQ):=D(f,x)*Sinc(f)
    ISetDelayed(D(SinIntegral(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Sinc(f))),
    // D(SinhIntegral(f_),x_?NotListQ):=D(f,x)*Sinh(f)/f
    ISetDelayed(D(SinhIntegral(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Power(f,CN1),Sinh(f))),
    // D(UnitStep(f_),x_?NotListQ):=D(f,x)*Piecewise({{Indeterminate,f==0}},0)
    ISetDelayed(D(UnitStep(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),Piecewise(List(List(Indeterminate,Equal(f,C0))),C0))),
    // D(ExpIntegralE(g_,f_),x_?NotListQ):=-ExpIntegralE(-1+g,f)*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(ExpIntegralE(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,ExpIntegralE(Plus(CN1,g),f),D(f,x)),FreeQ(List(g),x))),
    // D(JacobiAmplitude(g_,f_),x_?NotListQ):=JacobiDN(f,g)*D(f,x)+(D(g,x)*(JacobiDN(f,g)*(f*(-1+g)+JacobiEpsilon(f,g))-g*JacobiCN(f,g)*JacobiSN(f,g)))/(2*(-1+g)*g)
    ISetDelayed(D(JacobiAmplitude(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiDN(f,g),D(f,x)),Times(Power(Times(C2,Plus(CN1,g),g),CN1),D(g,x),Plus(Times(JacobiDN(f,g),Plus(Times(f,Plus(CN1,g)),JacobiEpsilon(f,g))),Times(CN1,g,JacobiCN(f,g),JacobiSN(f,g)))))),
    // D(JacobiCD(g_,f_),x_?NotListQ):=(-1+g)*JacobiND(f,g)*JacobiSD(f,g)*D(f,x)+(D(g,x)*(f*(-1+g)+JacobiEpsilon(f,g))*JacobiND(f,g)*JacobiSD(f,g))/(2*g)
    ISetDelayed(D(JacobiCD(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(Plus(CN1,g),JacobiND(f,g),JacobiSD(f,g),D(f,x)),Times(Power(Times(C2,g),CN1),D(g,x),Plus(Times(f,Plus(CN1,g)),JacobiEpsilon(f,g)),JacobiND(f,g),JacobiSD(f,g)))),
    // D(JacobiCN(g_,f_),x_?NotListQ):=-JacobiDN(f,g)*JacobiSN(f,g)*D(f,x)+(D(g,x)*JacobiDN(f,g)*JacobiSN(f,g)*(f*(-1+g)+JacobiEpsilon(f,g)-g*JacobiCD(f,g)*JacobiSN(f,g)))/(2*(1-g)*g)
    ISetDelayed(D(JacobiCN(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(CN1,JacobiDN(f,g),JacobiSN(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g),g),CN1),D(g,x),JacobiDN(f,g),JacobiSN(f,g),Plus(Times(f,Plus(CN1,g)),JacobiEpsilon(f,g),Times(CN1,g,JacobiCD(f,g),JacobiSN(f,g)))))),
    // D(JacobiDC(g_,f_),x_?NotListQ):=(1-g)*JacobiNC(f,g)*JacobiSC(f,g)*D(f,x)+(D(g,x)*(f*(1-g)-JacobiEpsilon(f,g))*JacobiNC(f,g)*JacobiSC(f,g))/(2*g)
    ISetDelayed(D(JacobiDC(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(Subtract(C1,g),JacobiNC(f,g),JacobiSC(f,g),D(f,x)),Times(Power(Times(C2,g),CN1),D(g,x),Subtract(Times(f,Subtract(C1,g)),JacobiEpsilon(f,g)),JacobiNC(f,g),JacobiSC(f,g)))),
    // D(JacobiDN(g_,f_),x_?NotListQ):=-g*JacobiCN(f,g)*JacobiSN(f,g)*D(f,x)+(D(g,x)*JacobiCN(f,g)*(f*(-1+g)+JacobiEpsilon(f,g)-JacobiDN(f,g)*JacobiSC(f,g))*JacobiSN(f,g))/(2*(1-g))
    ISetDelayed(D(JacobiDN(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(CN1,g,JacobiCN(f,g),JacobiSN(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g)),CN1),D(g,x),JacobiCN(f,g),Plus(Times(f,Plus(CN1,g)),JacobiEpsilon(f,g),Times(CN1,JacobiDN(f,g),JacobiSC(f,g))),JacobiSN(f,g)))),
    // D(JacobiNC(g_,f_),x_?NotListQ):=JacobiDC(f,g)*JacobiSC(f,g)*D(f,x)+(D(g,x)*JacobiDC(f,g)*JacobiSC(f,g)*(f*(1-g)-JacobiEpsilon(f,g)+g*JacobiCD(f,g)*JacobiSN(f,g)))/(2*(1-g)*g)
    ISetDelayed(D(JacobiNC(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiDC(f,g),JacobiSC(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g),g),CN1),D(g,x),JacobiDC(f,g),JacobiSC(f,g),Plus(Times(f,Subtract(C1,g)),Negate(JacobiEpsilon(f,g)),Times(g,JacobiCD(f,g),JacobiSN(f,g)))))),
    // D(JacobiND(g_,f_),x_?NotListQ):=g*JacobiCD(f,g)*JacobiSD(f,g)*D(f,x)+(D(g,x)*JacobiCD(f,g)*(f*(1-g)-JacobiEpsilon(f,g)+JacobiDN(f,g)*JacobiSC(f,g))*JacobiSD(f,g))/(2*(1-g))
    ISetDelayed(D(JacobiND(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(g,JacobiCD(f,g),JacobiSD(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g)),CN1),D(g,x),JacobiCD(f,g),Plus(Times(f,Subtract(C1,g)),Negate(JacobiEpsilon(f,g)),Times(JacobiDN(f,g),JacobiSC(f,g))),JacobiSD(f,g)))),
    // D(JacobiSC(g_,f_),x_?NotListQ):=JacobiDC(f,g)*JacobiNC(f,g)*D(f,x)+(D(g,x)*JacobiDC(f,g)*JacobiNC(f,g)*(f*(1-g)-JacobiEpsilon(f,g)+g*JacobiCD(f,g)*JacobiSN(f,g)))/(2*(1-g)*g)
    ISetDelayed(D(JacobiSC(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiDC(f,g),JacobiNC(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g),g),CN1),D(g,x),JacobiDC(f,g),JacobiNC(f,g),Plus(Times(f,Subtract(C1,g)),Negate(JacobiEpsilon(f,g)),Times(g,JacobiCD(f,g),JacobiSN(f,g)))))),
    // D(JacobiSD(g_,f_),x_?NotListQ):=JacobiCD(f,g)*JacobiND(f,g)*D(f,x)+(D(g,x)*JacobiCD(f,g)*JacobiND(f,g)*(f*(1-g)-JacobiEpsilon(f,g)+g*JacobiDN(f,g)*JacobiSC(f,g)))/(2*(1-g)*g)
    ISetDelayed(D(JacobiSD(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiCD(f,g),JacobiND(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g),g),CN1),D(g,x),JacobiCD(f,g),JacobiND(f,g),Plus(Times(f,Subtract(C1,g)),Negate(JacobiEpsilon(f,g)),Times(g,JacobiDN(f,g),JacobiSC(f,g)))))),
    // D(JacobiSN(g_,f_),x_?NotListQ):=JacobiCN(f,g)*JacobiDN(f,g)*D(f,x)+(D(g,x)*JacobiCN(f,g)*JacobiDN(f,g)*(f*(1-g)-JacobiEpsilon(f,g)+g*JacobiCD(f,g)*JacobiSN(f,g)))/(2*(1-g)*g)
    ISetDelayed(D(JacobiSN(g_,f_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiCN(f,g),JacobiDN(f,g),D(f,x)),Times(Power(Times(C2,Subtract(C1,g),g),CN1),D(g,x),JacobiCN(f,g),JacobiDN(f,g),Plus(Times(f,Subtract(C1,g)),Negate(JacobiEpsilon(f,g)),Times(g,JacobiCD(f,g),JacobiSN(f,g)))))),
    // D(BernoulliB(g_,f_),x_?NotListQ):=BernoulliB(-1+g,f)*g*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(BernoulliB(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(BernoulliB(Plus(CN1,g),f),g,D(f,x)),FreeQ(List(g),x))),
    // D(ChebyshevT(g_,f_),x_?NotListQ):=ChebyshevU(-1+g,f)*g*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(ChebyshevT(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(ChebyshevU(Plus(CN1,g),f),g,D(f,x)),FreeQ(List(g),x))),
    // D(ChebyshevU(g_,f_),x_?NotListQ):=((ChebyshevU(-1+g,f)*(-1-g)+ChebyshevU(g,f)*f*g)*D(f,x))/(-1+f^2)/;FreeQ({g},x)
    ISetDelayed(D(ChebyshevU(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(Power(Plus(CN1,Sqr(f)),CN1),Plus(Times(ChebyshevU(Plus(CN1,g),f),Subtract(CN1,g)),Times(ChebyshevU(g,f),f,g)),D(f,x)),FreeQ(List(g),x))),
    // D(GegenbauerC(g_,f_),x_?NotListQ):=2*ChebyshevU(-1+g,f)*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(GegenbauerC(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(C2,ChebyshevU(Plus(CN1,g),f),D(f,x)),FreeQ(List(g),x))),
    // D(GegenbauerC(g_,h_,f_),x_?NotListQ):=2*GegenbauerC(-1+g,1+h,f)*h*D(f,x)/;FreeQ({g,h},x)
    ISetDelayed(D(GegenbauerC(g_,h_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(C2,GegenbauerC(Plus(CN1,g),Plus(C1,h),f),h,D(f,x)),FreeQ(List(g,h),x))),
    // D(LaguerreL(g_,f_),x_?NotListQ):=-LaguerreL(-1+g,1,f)*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(LaguerreL(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,LaguerreL(Plus(CN1,g),C1,f),D(f,x)),FreeQ(List(g),x))),
    // D(LaguerreL(g_,h_,f_),x_?NotListQ):=-LaguerreL(-1+g,1+h,f)*c/;FreeQ({g,h},x)
    ISetDelayed(D(LaguerreL(g_,h_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,LaguerreL(Plus(CN1,g),Plus(C1,h),f),c),FreeQ(List(g,h),x))),
    // D(LegendreP(g_,f_),x_?NotListQ):=(D(f,x)*(f*(-1-g)*LegendreP(g,f)+(1+g)*LegendreP(1+g,f)))/(-1+f^2)/;FreeQ({g},x)
    ISetDelayed(D(LegendreP(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(Power(Plus(CN1,Sqr(f)),CN1),D(f,x),Plus(Times(f,Subtract(CN1,g),LegendreP(g,f)),Times(Plus(C1,g),LegendreP(Plus(C1,g),f)))),FreeQ(List(g),x))),
    // D(LegendreP(g_,h_,f_),x_?NotListQ):=(D(f,x)*(f*(-1-g)*LegendreP(g,h,f)+(1+g-h)*LegendreP(1+g,h,f)))/(-1+f^2)/;FreeQ({g,h},x)
    ISetDelayed(D(LegendreP(g_,h_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(Power(Plus(CN1,Sqr(f)),CN1),D(f,x),Plus(Times(f,Subtract(CN1,g),LegendreP(g,h,f)),Times(Plus(C1,g,Negate(h)),LegendreP(Plus(C1,g),h,f)))),FreeQ(List(g,h),x))),
    // D(LegendreQ(g_,f_),x_?NotListQ):=(D(f,x)*(f*(-1-g)*LegendreQ(g,f)+(1+g)*LegendreQ(1+g,f)))/(-1+f^2)/;FreeQ({g},x)
    ISetDelayed(D(LegendreQ(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(Power(Plus(CN1,Sqr(f)),CN1),D(f,x),Plus(Times(f,Subtract(CN1,g),LegendreQ(g,f)),Times(Plus(C1,g),LegendreQ(Plus(C1,g),f)))),FreeQ(List(g),x))),
    // D(LegendreQ(g_,h_,f_),x_?NotListQ):=(D(f,x)*(f*(-1-g)*LegendreQ(g,h,f)+(1+g-h)*LegendreQ(1+g,h,f)))/(-1+f^2)/;FreeQ({g,h},x)
    ISetDelayed(D(LegendreQ(g_,h_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(Power(Plus(CN1,Sqr(f)),CN1),D(f,x),Plus(Times(f,Subtract(CN1,g),LegendreQ(g,h,f)),Times(Plus(C1,g,Negate(h)),LegendreQ(Plus(C1,g),h,f)))),FreeQ(List(g,h),x))),
    // D(PolyGamma(g_,f_),x_?NotListQ):=PolyGamma(1+g,f)*D(f,x)/;FreeQ({g},x)
    ISetDelayed(D(PolyGamma(g_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(PolyGamma(Plus(C1,g),f),D(f,x)),FreeQ(List(g),x))),
    // D(HurwitzZeta(f_,g_),x_?NotListQ):=-f*HurwitzZeta(1+f,g)*D(g,x)/;FreeQ({f},x)
    ISetDelayed(D(HurwitzZeta(f_,g_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,f,HurwitzZeta(Plus(C1,f),g),D(g,x)),FreeQ(List(f),x))),
    // D(Zeta(f_,g_),x_?NotListQ):=-f*Zeta(1+f,g)*D(g,x)/;FreeQ({f},x)
    ISetDelayed(D(Zeta(f_,g_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,f,Zeta(Plus(C1,f),g),D(g,x)),FreeQ(List(f),x))),
    // D(Hypergeometric2F1(a_,b_,c_,f_),x_?NotListQ):=(a*b*D(f,x)*Hypergeometric2F1(1+a,1+b,1+c,f))/c/;FreeQ({a,b,c},x)
    ISetDelayed(D(Hypergeometric2F1(a_,b_,c_,f_),PatternTest(x_,NotListQ)),
      Condition(Times(a,b,Power(c,CN1),D(f,x),Hypergeometric2F1(Plus(C1,a),Plus(C1,b),Plus(C1,c),f)),FreeQ(List(a,b,c),x))),
    // D(Hypergeometric2F1(a_,b_,c_,x_),{x_,n_}):=Hypergeometric2F1(a+n,b+n,c+n,x)*(Pochhammer(a,n)*Pochhammer(b,n))/Pochhammer(c,n)/;FreeQ({a,b,c,n},x)&&Negative(n)=!=True
    ISetDelayed(D(Hypergeometric2F1(a_,b_,c_,x_),List(x_,n_)),
      Condition(Times(Hypergeometric2F1(Plus(a,n),Plus(b,n),Plus(c,n),x),Pochhammer(a,n),Pochhammer(b,n),Power(Pochhammer(c,n),CN1)),And(FreeQ(List(a,b,c,n),x),UnsameQ(Negative(n),True)))),
    // D(HypergeometricU(f_,g_,h_),x_?NotListQ):=-f*HypergeometricU(1+f,1+g,h)*D(h,x)/;FreeQ({f,g},x)
    ISetDelayed(D(HypergeometricU(f_,g_,h_),PatternTest(x_,NotListQ)),
      Condition(Times(CN1,f,HypergeometricU(Plus(C1,f),Plus(C1,g),h),D(h,x)),FreeQ(List(f,g),x))),
    // D(WhittakerM(f_,g_,h_),x_?NotListQ):=((1/2-f/h)*WhittakerM(f,g,h)+((1/2+f+g)*WhittakerM(1+f,g,h))/h)*D(h,x)/;FreeQ({f,g},x)
    ISetDelayed(D(WhittakerM(f_,g_,h_),PatternTest(x_,NotListQ)),
      Condition(Times(Plus(Times(Plus(C1D2,Times(CN1,f,Power(h,CN1))),WhittakerM(f,g,h)),Times(Plus(C1D2,f,g),Power(h,CN1),WhittakerM(Plus(C1,f),g,h))),D(h,x)),FreeQ(List(f,g),x))),
    // D(WhittakerW(f_,g_,h_),x_?NotListQ):=((1/2-f/h)*WhittakerW(f,g,h)-WhittakerW(1+f,g,h)/h)*D(h,x)/;FreeQ({f,g},x)
    ISetDelayed(D(WhittakerW(f_,g_,h_),PatternTest(x_,NotListQ)),
      Condition(Times(Plus(Times(Plus(C1D2,Times(CN1,f,Power(h,CN1))),WhittakerW(f,g,h)),Times(CN1,Power(h,CN1),WhittakerW(Plus(C1,f),g,h))),D(h,x)),FreeQ(List(f,g),x))),
    // D(InverseFunction(f_)[x_],x_):=1/f'(InverseFunction(f)[x])/;FreeQ(f,x)
    ISetDelayed(D($(InverseFunction(f_),x_),x_),
      Condition(Power($($(Derivative(C1),f),$(InverseFunction(f),x)),CN1),FreeQ(f,x))),
    // D(ArcCos(x_),{x_,2}):=-x/(1-x^2)^(3/2)
    ISetDelayed(D(ArcCos(x_),List(x_,C2)),
      Times(CN1,x,Power(Subtract(C1,Sqr(x)),QQ(-3L,2L)))),
    // D(ArcCot(x_),{x_,2}):=(2*x)/(1+x^2)^2
    ISetDelayed(D(ArcCot(x_),List(x_,C2)),
      Times(C2,x,Power(Plus(C1,Sqr(x)),CN2))),
    // D(ArcSin(x_),{x_,2}):=x/(1-x^2)^(3/2)
    ISetDelayed(D(ArcSin(x_),List(x_,C2)),
      Times(x,Power(Subtract(C1,Sqr(x)),QQ(-3L,2L)))),
    // D(ArcTan(x_),{x_,2}):=((-1)*2*x)/(1+x^2)^2
    ISetDelayed(D(ArcTan(x_),List(x_,C2)),
      Times(CN1,C2,x,Power(Plus(C1,Sqr(x)),CN2))),
    // D(ArcCosh(x_),{x_,2}):=-x/((-1+x)^(3/2)*(1+x)^(3/2))
    ISetDelayed(D(ArcCosh(x_),List(x_,C2)),
      Times(CN1,x,Power(Times(Power(Plus(CN1,x),QQ(3L,2L)),Power(Plus(C1,x),QQ(3L,2L))),CN1))),
    // D(ArcCoth(x_),{x_,2}):=(2*x)/(1-x^2)^2
    ISetDelayed(D(ArcCoth(x_),List(x_,C2)),
      Times(C2,x,Power(Subtract(C1,Sqr(x)),CN2))),
    // D(ArcSinh(x_),{x_,2}):=-x/(1+x^2)^(3/2)
    ISetDelayed(D(ArcSinh(x_),List(x_,C2)),
      Times(CN1,x,Power(Plus(C1,Sqr(x)),QQ(-3L,2L)))),
    // D(ArcTanh(x_),{x_,2}):=(2*x)/(1-x^2)^2
    ISetDelayed(D(ArcTanh(x_),List(x_,C2)),
      Times(C2,x,Power(Subtract(C1,Sqr(x)),CN2))),
    // D(ArcCsc(x_),{x_,2}):=(-1+2*x^2)/(Sqrt(1-1/x^2)*x^3*(-1+x^2))
    ISetDelayed(D(ArcCsc(x_),List(x_,C2)),
      Times(Plus(CN1,Times(C2,Sqr(x))),Power(Times(Sqrt(Subtract(C1,Power(x,CN2))),Power(x,C3),Plus(CN1,Sqr(x))),CN1))),
    // D(ArcSec(x_),{x_,2}):=(1-2*x^2)/(Sqrt(1-1/x^2)*x^3*(-1+x^2))
    ISetDelayed(D(ArcSec(x_),List(x_,C2)),
      Times(Plus(C1,Times(CN2,Sqr(x))),Power(Times(Sqrt(Subtract(C1,Power(x,CN2))),Power(x,C3),Plus(CN1,Sqr(x))),CN1))),
    // D(Cos(x_),{x_,2}):=-Cos(x)
    ISetDelayed(D(Cos(x_),List(x_,C2)),
      Negate(Cos(x))),
    // D(Cot(x_),{x_,2}):=2*Cot(x)*Csc(x)^2
    ISetDelayed(D(Cot(x_),List(x_,C2)),
      Times(C2,Cot(x),Sqr(Csc(x)))),
    // D(Sin(x_),{x_,2}):=-Sin(x)
    ISetDelayed(D(Sin(x_),List(x_,C2)),
      Negate(Sin(x))),
    // D(Tan(x_),{x_,2}):=2*Sec(x)^2*Tan(x)
    ISetDelayed(D(Tan(x_),List(x_,C2)),
      Times(C2,Sqr(Sec(x)),Tan(x))),
    // D(Csc(x_),{x_,2}):=Csc(x)^3+Csc(x)*Cot(x)^2
    ISetDelayed(D(Csc(x_),List(x_,C2)),
      Plus(Power(Csc(x),C3),Times(Csc(x),Sqr(Cot(x))))),
    // D(Sec(x_),{x_,2}):=Sec(x)^3+Sec(x)*Tan(x)^2
    ISetDelayed(D(Sec(x_),List(x_,C2)),
      Plus(Power(Sec(x),C3),Times(Sec(x),Sqr(Tan(x))))),
    // D(x_^a_,{x_,n_}):=If(IntegerQ(n),Pochhammer(a-n+1,n)*x^(a-n),FactorialPower(a,n)*x^(a-n))/;((IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ))&&FreeQ(a,x)
    ISetDelayed(D(Power(x_,a_),List(x_,n_)),
      Condition(If(IntegerQ(n),Times(Pochhammer(Plus(a,Negate(n),C1),n),Power(x,Subtract(a,n))),Times(FactorialPower(a,n),Power(x,Subtract(a,n)))),And(Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))),FreeQ(a,x)))),
    // D(a_^x_,{x_,n_Integer}):=a^x*Log(a)^n/;((IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ))&&FreeQ(a,x)
    ISetDelayed(D(Power(a_,x_),List(x_,$p(n, Integer))),
      Condition(Times(Power(a,x),Power(Log(a),n)),And(Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))),FreeQ(a,x)))),
    // D(ArcCos(x_),{x_,n_Integer}):=KroneckerDelta(n)*ArcCos(x)-1/((-1)^(1-n)*(1-x^2)^(-1/2+n))*Sum((Pochhammer(1-n,k)*Pochhammer(1/2,k)*2^(1+2*k-n)*x^(1+2*k-n)*(-1+x^2)^(-1-k+n))/(2*k-n+1)!,{k,0,-1+n})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(ArcCos(x_),List(x_,$p(n, Integer))),
      Condition(Plus(Times(KroneckerDelta(n),ArcCos(x)),Times(CN1,Power(CN1,Plus(CN1,n)),Power(Power(Subtract(C1,Sqr(x)),Plus(CN1D2,n)),CN1),Sum(Times(Power(Factorial(Plus(Times(C2,k),Negate(n),C1)),CN1),Pochhammer(Subtract(C1,n),k),Pochhammer(C1D2,k),Power(C2,Plus(C1,Times(C2,k),Negate(n))),Power(x,Plus(C1,Times(C2,k),Negate(n))),Power(Plus(CN1,Sqr(x)),Plus(CN1,Negate(k),n))),List(k,C0,Plus(CN1,n))))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(ArcCot(x_),{x_,n_Integer}):=KroneckerDelta(n)*ArcCot(x)-Sum(((-1)^k*1/((-1-k+n)!/(2*x)^(1+2*k-n))*k!*Pochhammer(2*k-n+2,-2+2*(-k+n)))/(1+x^2)^(1+k),{k,0,-1+n})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(ArcCot(x_),List(x_,$p(n, Integer))),
      Condition(Subtract(Times(KroneckerDelta(n),ArcCot(x)),Sum(Times(Power(CN1,k),Power(Times(Factorial(Plus(CN1,Negate(k),n)),Power(Times(C2,x),Plus(CN1,Times(CN2,k),n))),CN1),Factorial(k),Pochhammer(Plus(Times(C2,k),Negate(n),C2),Plus(CN2,Times(C2,Plus(Negate(k),n)))),Power(Plus(C1,Sqr(x)),Subtract(CN1,k))),List(k,C0,Plus(CN1,n)))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(ArcSin(x_),{x_,n_Integer}):=KroneckerDelta(n)*ArcSin(x)+1/((-1)^(1-n)*(1-x^2)^(-1/2+n))*Sum((2^(1+2*k-n)*x^(1+2*k-n)*Pochhammer(1/2,k)*Pochhammer(1-n,k))/((-1+x^2)^(1+k-n)*(2*k-n+1)!),{k,0,-1+n})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(ArcSin(x_),List(x_,$p(n, Integer))),
      Condition(Plus(Times(KroneckerDelta(n),ArcSin(x)),Times(Power(CN1,Plus(CN1,n)),Power(Power(Subtract(C1,Sqr(x)),Plus(CN1D2,n)),CN1),Sum(Times(Power(C2,Plus(C1,Times(C2,k),Negate(n))),Power(x,Plus(C1,Times(C2,k),Negate(n))),Power(Plus(CN1,Sqr(x)),Plus(CN1,Negate(k),n)),Power(Factorial(Plus(Times(C2,k),Negate(n),C1)),CN1),Pochhammer(C1D2,k),Pochhammer(Subtract(C1,n),k)),List(k,C0,Plus(CN1,n))))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(ArcTan(x_),{x_,n_Integer}):=KroneckerDelta(n)*ArcTan(x)+Sum(((-1)^k*1/((-1-k+n)!/(2*x)^(1+2*k-n))*k!*Pochhammer(2*k-n+2,-2+2*(-k+n)))/(1+x^2)^(1+k),{k,0,-1+n})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(ArcTan(x_),List(x_,$p(n, Integer))),
      Condition(Plus(Times(KroneckerDelta(n),ArcTan(x)),Sum(Times(Power(CN1,k),Power(Times(Factorial(Plus(CN1,Negate(k),n)),Power(Times(C2,x),Plus(CN1,Times(CN2,k),n))),CN1),Factorial(k),Pochhammer(Plus(Times(C2,k),Negate(n),C2),Plus(CN2,Times(C2,Plus(Negate(k),n)))),Power(Plus(C1,Sqr(x)),Subtract(CN1,k))),List(k,C0,Plus(CN1,n)))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(Cos(x_),{x_,n_Integer}):=Cos(x+1/2*n*Pi)/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(Cos(x_),List(x_,$p(n, Integer))),
      Condition(Cos(Plus(x,Times(C1D2,n,Pi))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(Cot(x_),{x_,n_Integer}):=-Csc(x)^2*KroneckerDelta(-1+n)+Cot(x)*KroneckerDelta(n)-n*Sum((((-1)^j*Binomial(-1+n,k))/(k+1)*Binomial(2*k,j)*Sin(1/2*n*Pi+2*(-j+k)*x))/(Sin(x)^(2+2*k)*2^(2*k-n)*(-j+k)^(1-n)),{k,0,-1+n},{j,0,-1+k})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(Cot(x_),List(x_,$p(n, Integer))),
      Condition(Plus(Times(CN1,Sqr(Csc(x)),KroneckerDelta(Plus(CN1,n))),Times(Cot(x),KroneckerDelta(n)),Times(CN1,n,Sum(Times(Power(CN1,j),Power(Plus(k,C1),CN1),Binomial(Plus(CN1,n),k),Power(Sin(x),Plus(CN2,Times(CN2,k))),Power(C2,Plus(Times(CN2,k),n)),Binomial(Times(C2,k),j),Power(Plus(Negate(j),k),Plus(CN1,n)),Sin(Plus(Times(C1D2,n,Pi),Times(C2,Plus(Negate(j),k),x)))),List(k,C0,Plus(CN1,n)),List(j,C0,Plus(CN1,k))))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(Sin(x_),{x_,n_}):=Sin(x+1/2*n*Pi)/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(Sin(x_),List(x_,n_)),
      Condition(Sin(Plus(x,Times(C1D2,n,Pi))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(Tan(x_),{x_,n_Integer}):=Tan(x)*KroneckerDelta(n)+Sec(x)^2*KroneckerDelta(-1+n)+n*Sum((((-1)^k*Binomial(-1+n,k))/(k+1)*Binomial(2*k,j)*Sin(1/2*n*Pi+2*(-j+k)*x))/(Cos(x)^(2+2*k)*2^(2*k-n)*(-j+k)^(1-n)),{k,0,-1+n},{j,0,-1+k})/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(Tan(x_),List(x_,$p(n, Integer))),
      Condition(Plus(Times(Tan(x),KroneckerDelta(n)),Times(Sqr(Sec(x)),KroneckerDelta(Plus(CN1,n))),Times(n,Sum(Times(Power(CN1,k),Power(Plus(k,C1),CN1),Binomial(Plus(CN1,n),k),Power(Cos(x),Plus(CN2,Times(CN2,k))),Power(C2,Plus(Times(CN2,k),n)),Binomial(Times(C2,k),j),Power(Plus(Negate(j),k),Plus(CN1,n)),Sin(Plus(Times(C1D2,n,Pi),Times(C2,Plus(Negate(j),k),x)))),List(k,C0,Plus(CN1,n)),List(j,C0,Plus(CN1,k))))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(Log(x_),{x_,n_Integer}):=(-1+n)!/((-1)^(1-n)*x^n)/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(Log(x_),List(x_,$p(n, Integer))),
      Condition(Times(Power(CN1,Plus(CN1,n)),Power(Power(x,n),CN1),Factorial(Plus(CN1,n))),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(PolyGamma(0,x_),{x_,n_}):=PolyGamma(n,x)/;(IntegerQ(n)&&n>=0)||FreeQ(n,_?NumberQ)
    ISetDelayed(D(PolyGamma(C0,x_),List(x_,n_)),
      Condition(PolyGamma(n,x),Or(And(IntegerQ(n),GreaterEqual(n,C0)),FreeQ(n,PatternTest($b(),NumberQ))))),
    // D(ArcTan(f_,g_),x_?NotListQ):=With({d=(-g*D(f,x)+f*D(g,x))/(f^2+g^2)},If(PossibleZeroQ(d),0,d))
    ISetDelayed(D(ArcTan(f_,g_),PatternTest(x_,NotListQ)),
      With(List(Set(d,Times(Power(Plus(Sqr(f),Sqr(g)),CN1),Plus(Times(CN1,g,D(f,x)),Times(f,D(g,x)))))),If(PossibleZeroQ(d),C0,d))),
    // D(BesselJ(f_,g_),x_?NotListQ):=1/2*(BesselJ(-1+f,g)-BesselJ(1+f,g))*D(g,x)+D(f,x)*Derivative(1,0)[BesselJ][f,g]
    ISetDelayed(D(BesselJ(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(C1D2,Subtract(BesselJ(Plus(CN1,f),g),BesselJ(Plus(C1,f),g)),D(g,x)),Times(D(f,x),$($(Derivative(C1,C0),BesselJ),f,g)))),
    // D(BesselY(f_,g_),x_?NotListQ):=1/2*(BesselY(-1+f,g)-BesselY(1+f,g))*D(g,x)+D(f,x)*Derivative(1,0)[BesselY][f,g]
    ISetDelayed(D(BesselY(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(C1D2,Subtract(BesselY(Plus(CN1,f),g),BesselY(Plus(C1,f),g)),D(g,x)),Times(D(f,x),$($(Derivative(C1,C0),BesselY),f,g)))),
    // D(CarlsonRC(f_,g_),x_?NotListQ):=Piecewise({{(-CarlsonRC(f,g)+1/Sqrt(f))/(2*(f-g)),f!=g},{-1/(6*f^(3/2)),f==g&&(Im(g)!=0||Re(g)>0)}},ComplexInfinity)*D(f,x)+Piecewise({{(-Sqrt(f)/g+CarlsonRC(f,g))/(2*(f-g)),f!=g},{-1/(3*f^(3/2)),f==g&&(Im(g)!=0||Re(g)>0)}},ComplexInfinity)*D(g,x)
    ISetDelayed(D(CarlsonRC(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(Piecewise(List(List(Times(Plus(Negate(CarlsonRC(f,g)),Power(f,CN1D2)),Power(Times(C2,Subtract(f,g)),CN1)),Unequal(f,g)),List(Negate(Power(Times(C6,Power(f,QQ(3L,2L))),CN1)),And(Equal(f,g),Or(Unequal(Im(g),C0),Greater(Re(g),C0))))),CComplexInfinity),D(f,x)),Times(Piecewise(List(List(Times(Power(Times(C2,Subtract(f,g)),CN1),Plus(Times(CN1,Sqrt(f),Power(g,CN1)),CarlsonRC(f,g))),Unequal(f,g)),List(Negate(Power(Times(C3,Power(f,QQ(3L,2L))),CN1)),And(Equal(f,g),Or(Unequal(Im(g),C0),Greater(Re(g),C0))))),CComplexInfinity),D(g,x)))),
    // D(CarlsonRD(f_,g_,h_),x_?NotListQ):=-1/6*CarlsonRD(g,h,f)*D(f,x)-1/6*CarlsonRD(f,h,g)*D(g,x)-1/6*CarlsonRD(f,g,h)*D(h,x)
    ISetDelayed(D(CarlsonRD(f_,g_,h_),PatternTest(x_,NotListQ)),
      Plus(Times(QQ(-1L,6L),CarlsonRD(g,h,f),D(f,x)),Times(QQ(-1L,6L),CarlsonRD(f,h,g),D(g,x)),Times(QQ(-1L,6L),CarlsonRD(f,g,h),D(h,x)))),
    // D(CarlsonRF(f_,g_,h_),x_?NotListQ):=-1/6*CarlsonRD(g,h,f)*D(f,x)-1/6*CarlsonRD(f,h,g)*D(g,x)-1/6*CarlsonRD(f,g,h)*D(h,x)
    ISetDelayed(D(CarlsonRF(f_,g_,h_),PatternTest(x_,NotListQ)),
      Plus(Times(QQ(-1L,6L),CarlsonRD(g,h,f),D(f,x)),Times(QQ(-1L,6L),CarlsonRD(f,h,g),D(g,x)),Times(QQ(-1L,6L),CarlsonRD(f,g,h),D(h,x)))),
    // D(CarlsonRG(f_,g_,h_),x_?NotListQ):=1/12*(-f*CarlsonRD(g,h,f)+3*CarlsonRF(f,g,h))*D(f,x)+1/12*(-g*CarlsonRD(f,h,g)+3*CarlsonRF(f,g,h))*D(g,x)+1/12*(-h*CarlsonRD(f,g,h)+3*CarlsonRF(f,g,h))*D(h,x)
    ISetDelayed(D(CarlsonRG(f_,g_,h_),PatternTest(x_,NotListQ)),
      Plus(Times(QQ(1L,12L),Plus(Times(CN1,f,CarlsonRD(g,h,f)),Times(C3,CarlsonRF(f,g,h))),D(f,x)),Times(QQ(1L,12L),Plus(Times(CN1,g,CarlsonRD(f,h,g)),Times(C3,CarlsonRF(f,g,h))),D(g,x)),Times(QQ(1L,12L),Plus(Times(CN1,h,CarlsonRD(f,g,h)),Times(C3,CarlsonRF(f,g,h))),D(h,x)))),
    // D(PolyLog(f_,g_),x_?NotListQ):=(D(g,x)*PolyLog(-1+f,g))/g+D(f,x)*Derivative(1,0)[PolyLog][f,g]
    ISetDelayed(D(PolyLog(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(Power(g,CN1),D(g,x),PolyLog(Plus(CN1,f),g)),Times(D(f,x),$($(Derivative(C1,C0),PolyLog),f,g)))),
    // D(ProductLog(f_),x_?NotListQ):=(D(f,x)*ProductLog(f))/(f*(1+ProductLog(f)))
    ISetDelayed(D(ProductLog(f_),PatternTest(x_,NotListQ)),
      Times(D(f,x),ProductLog(f),Power(Times(f,Plus(C1,ProductLog(f))),CN1))),
    // D(ProductLog(f_,g_),x_?NotListQ):=ProductLog(f,g)*D(g,x)/(g*(1+ProductLog(f,g)))+D(f,x)*Derivative(1,0)[ProductLog][f,g]
    ISetDelayed(D(ProductLog(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(ProductLog(f,g),D(g,x),Power(Times(g,Plus(C1,ProductLog(f,g))),CN1)),Times(D(f,x),$($(Derivative(C1,C0),ProductLog),f,g)))),
    // D(JacobiAmplitude(f_,g_),x_?NotListQ):=JacobiDN(f,g)*D(f,x)+(D(g,x)*((EllipticE(JacobiAmplitude(f,g),g)+f*(-1+g))*JacobiDN(f,g)-g*JacobiCN(f,g)*JacobiSN(f,g)))/(2*(-1+g)*g)
    ISetDelayed(D(JacobiAmplitude(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(JacobiDN(f,g),D(f,x)),Times(Power(Times(C2,Plus(CN1,g),g),CN1),D(g,x),Plus(Times(Plus(EllipticE(JacobiAmplitude(f,g),g),Times(f,Plus(CN1,g))),JacobiDN(f,g)),Times(CN1,g,JacobiCN(f,g),JacobiSN(f,g)))))),
    // D(StruveH(f_,g_),x_?NotListQ):=1/2*(g^f/(2^f*Sqrt(Pi)*Gamma(3/2+f))+StruveH(-1+f,g)-StruveH(1+f,g))*D(g,x)+D(f,x)*Derivative(1,0)[StruveH][f,g]
    ISetDelayed(D(StruveH(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(C1D2,Plus(Times(Power(g,f),Power(Times(Power(C2,f),Sqrt(Pi),Gamma(Plus(QQ(3L,2L),f))),CN1)),StruveH(Plus(CN1,f),g),Negate(StruveH(Plus(C1,f),g))),D(g,x)),Times(D(f,x),$($(Derivative(C1,C0),StruveH),f,g)))),
    // D(StruveL(f_,g_),x_?NotListQ):=1/2*(g^f/(2^f*Sqrt(Pi)*Gamma(3/2+f))+StruveL(-1+f,g)+StruveL(1+f,g))*D(g,x)+D(f,x)*Derivative(1,0)[StruveL][f,g]
    ISetDelayed(D(StruveL(f_,g_),PatternTest(x_,NotListQ)),
      Plus(Times(C1D2,Plus(Times(Power(g,f),Power(Times(Power(C2,f),Sqrt(Pi),Gamma(Plus(QQ(3L,2L),f))),CN1)),StruveL(Plus(CN1,f),g),StruveL(Plus(C1,f),g)),D(g,x)),Times(D(f,x),$($(Derivative(C1,C0),StruveL),f,g))))
  );
}
