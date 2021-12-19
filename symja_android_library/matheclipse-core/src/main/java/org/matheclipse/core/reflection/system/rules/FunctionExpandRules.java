package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface FunctionExpandRules {
  final public static IAST RULES = List(
    // ArcCos(1/x_):=ArcSec(x)
    SetDelayed(ArcCos(Power(x_,CN1)),
      ArcSec(x)),
    // ArcSec(1/x_):=ArcCos(x)
    SetDelayed(ArcSec(Power(x_,CN1)),
      ArcCos(x)),
    // ArcCot(Sqrt(x_^2)):=(Sqrt(x^2)*ArcCot(x))/x
    SetDelayed(ArcCot(Sqrt(Sqr(x_))),
      Times(Power(x,CN1),Sqrt(Sqr(x)),ArcCot(x))),
    // ArcCot(1/x_):=ArcTan(x)
    SetDelayed(ArcCot(Power(x_,CN1)),
      ArcTan(x)),
    // ArcTan(Sqrt(x_^2)):=(Sqrt(x^2)*ArcTan(x))/x
    SetDelayed(ArcTan(Sqrt(Sqr(x_))),
      Times(Power(x,CN1),Sqrt(Sqr(x)),ArcTan(x))),
    // ArcTan(1/x_):=ArcCot(x)
    SetDelayed(ArcTan(Power(x_,CN1)),
      ArcCot(x)),
    // ArcCsc(Sqrt(x_^2)):=(Sqrt(x^2)*ArcCsc(x))/x
    SetDelayed(ArcCsc(Sqrt(Sqr(x_))),
      Times(Power(x,CN1),Sqrt(Sqr(x)),ArcCsc(x))),
    // ArcCsc(1/x_):=ArcSin(x)
    SetDelayed(ArcCsc(Power(x_,CN1)),
      ArcSin(x)),
    // ArcSin(Sqrt(x_^2)):=(Sqrt(x^2)*ArcSin(x))/x
    SetDelayed(ArcSin(Sqrt(Sqr(x_))),
      Times(Power(x,CN1),Sqrt(Sqr(x)),ArcSin(x))),
    // ArcSin(1/x_):=ArcCsc(x)
    SetDelayed(ArcSin(Power(x_,CN1)),
      ArcCsc(x)),
    // BetaRegularized(z_,a_,b_):=(Beta(z,a,b)*Gamma(a+b))/(Gamma(a)*Gamma(b))
    SetDelayed(BetaRegularized(z_,a_,b_),
      Times(Beta(z,a,b),Power(Times(Gamma(a),Gamma(b)),CN1),Gamma(Plus(a,b)))),
    // BetaRegularized(y_,z_,a_,b_):=((-Beta(y,a,b)+Beta(z,a,b))*Gamma(a+b))/(Gamma(a)*Gamma(b))
    SetDelayed(BetaRegularized(y_,z_,a_,b_),
      Times(Plus(Negate(Beta(y,a,b)),Beta(z,a,b)),Power(Times(Gamma(a),Gamma(b)),CN1),Gamma(Plus(a,b)))),
    // ChebyshevT(n_,x_):=Cos(n*ArcCos(x))
    SetDelayed(ChebyshevT(n_,x_),
      Cos(Times(n,ArcCos(x)))),
    // ChebyshevU(n_,x_):=Sin((1+n)*ArcCos(x))/(Sqrt(1-x)*Sqrt(1+x))
    SetDelayed(ChebyshevU(n_,x_),
      Times(Power(Times(Sqrt(Subtract(C1,x)),Sqrt(Plus(C1,x))),CN1),Sin(Times(Plus(C1,n),ArcCos(x))))),
    // Cos(n_Integer*ArcSin(z_)):=ChebyshevT(n,Sqrt(1-z^2))/;n>0
    SetDelayed(Cos(Times(ArcSin(z_),$p(n, Integer))),
      Condition(ChebyshevT(n,Sqrt(Subtract(C1,Sqr(z)))),Greater(n,C0))),
    // ExpIntegralE(n_,z_):=Gamma(1-n,z)/z^(1-n)
    SetDelayed(ExpIntegralE(n_,z_),
      Times(Power(z,Plus(CN1,n)),Gamma(Subtract(C1,n),z))),
    // z_!:=Gamma(1+z)
    SetDelayed(Factorial(z_),
      Gamma(Plus(C1,z))),
    // n_!!:=2^(n/2+1/4*(1-Cos(n*Pi)))*Pi^(1/4*(-1+Cos(n*Pi)))*Gamma(1+n/2)
    SetDelayed(Factorial2(n_),
      Times(Power(C2,Plus(Times(C1D2,n),Times(C1D4,Subtract(C1,Cos(Times(n,Pi)))))),Power(Pi,Times(C1D4,Plus(CN1,Cos(Times(n,Pi))))),Gamma(Plus(C1,Times(C1D2,n))))),
    // Fibonacci(m_Integer+n_):=1/2*Fibonacci(m)*LucasL(n)+1/2*Fibonacci(n)*LucasL(m)/;n∈Integers
    SetDelayed(Fibonacci(Plus($p(m, Integer),n_)),
      Condition(Plus(Times(C1D2,Fibonacci(m),LucasL(n)),Times(C1D2,Fibonacci(n),LucasL(m))),Element(n,Integers))),
    // Fibonacci(n_+a_):=((2/(1+Sqrt(5)))^(-a-n)-Cos((a+n)*Pi)/(1/2*(1+Sqrt(5)))^(a+n))/Sqrt(5)/;n∈Integers
    SetDelayed(Fibonacci(Plus(a_,n_)),
      Condition(Times(C1DSqrt5,Plus(Power(Times(C2,Power(Plus(C1,CSqrt5),CN1)),Subtract(Negate(a),n)),Times(CN1,Power(Times(C1D2,Plus(C1,CSqrt5)),Subtract(Negate(a),n)),Cos(Times(Plus(a,n),Pi))))),Element(n,Integers))),
    // Gamma(-1,z_):=1/(E^z*z)+ExpIntegralEi(-z)+1/2*(Log(-1/z)-Log(-z))+Log(z)
    SetDelayed(Gamma(CN1,z_),
      Plus(Power(Times(Exp(z),z),CN1),ExpIntegralEi(Negate(z)),Times(C1D2,Subtract(Log(Negate(Power(z,CN1))),Log(Negate(z)))),Log(z))),
    // Gamma(-1/2,z_):=2/(E^z*Sqrt(z))-2*Sqrt(Pi)*(1-Erf(Sqrt(z)))
    SetDelayed(Gamma(CN1D2,z_),
      Plus(Times(C2,Power(Times(Exp(z),Sqrt(z)),CN1)),Times(CN2,Sqrt(Pi),Subtract(C1,Erf(Sqrt(z)))))),
    // Gamma(0,z_):=-ExpIntegralEi(-z)+1/2*(-Log(-1/z)+Log(-z))-Log(z)
    SetDelayed(Gamma(C0,z_),
      Plus(Negate(ExpIntegralEi(Negate(z))),Times(C1D2,Plus(Negate(Log(Negate(Power(z,CN1)))),Log(Negate(z)))),Negate(Log(z)))),
    // Gamma(1/2,z_):=Sqrt(Pi)*(1-Erf(Sqrt(z)))
    SetDelayed(Gamma(C1D2,z_),
      Times(Sqrt(Pi),Subtract(C1,Erf(Sqrt(z))))),
    // GammaRegularized(a_,z_):=Gamma(a,z)/Gamma(a)
    SetDelayed(GammaRegularized(a_,z_),
      Times(Power(Gamma(a),CN1),Gamma(a,z))),
    // GegenbauerC(n_,x_):=(2*Cos(n*ArcCos(x)))/n
    SetDelayed(GegenbauerC(n_,x_),
      Times(C2,Power(n,CN1),Cos(Times(n,ArcCos(x))))),
    // Gudermannian(z_):=Piecewise({{1/2*(Pi-4*ArcCot(E^z)),Re(z)>0||(Re(z)==0&&Im(z)>=0)}},1/2*(-Pi+4*ArcTan(E^z)))
    SetDelayed(Gudermannian(z_),
      Piecewise(List(List(Times(C1D2,Plus(Pi,Times(CN4,ArcCot(Exp(z))))),Or(Greater(Re(z),C0),And(Equal(Re(z),C0),GreaterEqual(Im(z),C0))))),Times(C1D2,Plus(CNPi,Times(C4,ArcTan(Exp(z))))))),
    // HarmonicNumber(n_):=EulerGamma+PolyGamma(0,1+n)
    SetDelayed(HarmonicNumber(n_),
      Plus(EulerGamma,PolyGamma(C0,Plus(C1,n)))),
    // HarmonicNumber(z_,n_):=-HurwitzZeta(n,1+z)+Zeta(n)
    SetDelayed(HarmonicNumber(z_,n_),
      Plus(Negate(HurwitzZeta(n,Plus(C1,z))),Zeta(n))),
    // Haversine(z_):=1/2*(1-Cos(z))
    SetDelayed(Haversine(z_),
      Times(C1D2,Subtract(C1,Cos(z)))),
    // HurwitzZeta(n_Integer,a_):=(-1)^n/(-1+n)!*PolyGamma(-1+n,a)/;n>1
    SetDelayed(HurwitzZeta($p(n, Integer),a_),
      Condition(Times(Power(CN1,n),Power(Factorial(Plus(CN1,n)),CN1),PolyGamma(Plus(CN1,n),a)),Greater(n,C1))),
    // HypergeometricPFQ({1/2},{1,1},z_):=BesselI(0,Sqrt(z))^2
    SetDelayed(HypergeometricPFQ(List(C1D2),List(C1,C1),z_),
      Sqr(BesselI(C0,Sqrt(z)))),
    // Hypergeometric2F1(a_,b_,b_+n_Integer,z_):=Sum((z^k*Pochhammer(n,k)*Pochhammer(-a+b+n,k))/(Pochhammer(b+n,k)*k!),{k,0,-n})/(1-z)^(a-n)/;n<0
    SetDelayed(Hypergeometric2F1(a_,b_,Plus(b_,$p(n, Integer)),z_),
      Condition(Times(Power(Subtract(C1,z),Plus(Negate(a),n)),Sum(Times(Power(z,k),Power(Times(Pochhammer(Plus(b,n),k),Factorial(k)),CN1),Pochhammer(n,k),Pochhammer(Plus(Negate(a),b,n),k)),List(k,C0,Negate(n)))),Less(n,C0))),
    // InverseGudermannian(z_):=Log(Tan(Pi/4+z/2))
    SetDelayed(InverseGudermannian(z_),
      Log(Tan(Plus(Times(C1D4,Pi),Times(C1D2,z))))),
    // InverseHaversine(z_):=2*ArcSin(Sqrt(z))
    SetDelayed(InverseHaversine(z_),
      Times(C2,ArcSin(Sqrt(z)))),
    // JacobiCD(f_,g_):=JacobiCN(f,g)/JacobiDN(f,g)
    SetDelayed(JacobiCD(f_,g_),
      Times(JacobiCN(f,g),Power(JacobiDN(f,g),CN1))),
    // JacobiDC(f_,g_):=JacobiDN(f,g)/JacobiCN(f,g)
    SetDelayed(JacobiDC(f_,g_),
      Times(Power(JacobiCN(f,g),CN1),JacobiDN(f,g))),
    // JacobiNC(f_,g_):=1/JacobiCN(f,g)
    SetDelayed(JacobiNC(f_,g_),
      Power(JacobiCN(f,g),CN1)),
    // JacobiND(f_,g_):=1/JacobiDN(f,g)
    SetDelayed(JacobiND(f_,g_),
      Power(JacobiDN(f,g),CN1)),
    // JacobiSC(f_,g_):=JacobiSN(f,g)/JacobiCN(f,g)
    SetDelayed(JacobiSC(f_,g_),
      Times(Power(JacobiCN(f,g),CN1),JacobiSN(f,g))),
    // JacobiSD(f_,g_):=JacobiSN(f,g)/JacobiDN(f,g)
    SetDelayed(JacobiSD(f_,g_),
      Times(Power(JacobiDN(f,g),CN1),JacobiSN(f,g))),
    // LegendreQ(l_,m_,x_):=(-Pi*Csc(m*Pi)*Gamma(1+l+m)*LegendreP(l,-m,x))/(2*Gamma(1+l-m))+1/2*Pi*Cot(m*Pi)*LegendreP(l,m,x)
    SetDelayed(LegendreQ(l_,m_,x_),
      Plus(Times(CN1,Pi,Csc(Times(m,Pi)),Power(Times(C2,Gamma(Plus(C1,l,Negate(m)))),CN1),Gamma(Plus(C1,l,m)),LegendreP(l,Negate(m),x)),Times(C1D2,Pi,Cot(Times(m,Pi)),LegendreP(l,m,x)))),
    // Log(1/2*(1+I*Sqrt(3)))=I*Pi/3
    Set(Log(Times(C1D2,Plus(C1,Times(CI,CSqrt3)))),
      Times(CC(0L,1L,1L,3L),Pi)),
    // Log(ProductLog(x_))=x
    Set(Log(ProductLog(x_)),
      x),
    // LogisticSigmoid(x_):=1/(1+E^(-x))
    SetDelayed(LogisticSigmoid(x_),
      Power(Plus(C1,Exp(Negate(x))),CN1)),
    // LogGamma(x_):=Log(Gamma(x))/;x>0
    SetDelayed(LogGamma(x_),
      Condition(Log(Gamma(x)),Greater(x,C0))),
    // PolyGamma(n_Integer,1/2):=(-1)^(n+1)*n!*(-1+2^(n+1))*Zeta(n+1)/;n>0
    SetDelayed(PolyGamma($p(n, Integer),C1D2),
      Condition(Times(Power(CN1,Plus(n,C1)),Factorial(n),Plus(CN1,Power(C2,Plus(n,C1))),Zeta(Plus(n,C1))),Greater(n,C0))),
    // Abs(x_)^y_Integer:=x^y/;EvenQ(y)&&x∈Reals
    SetDelayed(Power(Abs(x_),$p(y, Integer)),
      Condition(Power(x,y),And(EvenQ(y),Element(x,Reals)))),
    // ProductLog(x_*Log(x_)):=Log(x)/;x>1/E
    SetDelayed(ProductLog(Times(Log(x_),x_)),
      Condition(Log(x),Greater(x,Exp(CN1)))),
    // E^ProductLog(x_):=x/ProductLog(x)
    SetDelayed(Exp(ProductLog(x_)),
      Times(x,Power(ProductLog(x),CN1))),
    // Sin(n_Integer*ArcSin(z_)):=z*ChebyshevU(-1+n,Sqrt(1-z^2))/;n>0
    SetDelayed(Sin(Times(ArcSin(z_),$p(n, Integer))),
      Condition(Times(z,ChebyshevU(Plus(CN1,n),Sqrt(Subtract(C1,Sqr(z))))),Greater(n,C0))),
    // Sin(n_Integer*ArcTan(z_)):=Sum((-1)^k*Binomial(n,2*k+1)*z^(2*k+1),{k,0,Floor(1/2*(-1+n))})/(1+z^2)^(n/2)/;n>0
    SetDelayed(Sin(Times(ArcTan(z_),$p(n, Integer))),
      Condition(Times(Power(Power(Plus(C1,Sqr(z)),Times(C1D2,n)),CN1),Sum(Times(Power(CN1,k),Binomial(n,Plus(Times(C2,k),C1)),Power(z,Plus(Times(C2,k),C1))),List(k,C0,Floor(Times(C1D2,Plus(CN1,n)))))),Greater(n,C0))),
    // Sinc(z_):=Sin(z)/z/;z!=0
    SetDelayed(Sinc(z_),
      Condition(Times(Power(z,CN1),Sin(z)),Unequal(z,C0))),
    // SphericalBesselJ(a_,b_):=(Sqrt(Pi/2)*BesselJ(1/2*(1+2*a),b))/Sqrt(b)
    SetDelayed(SphericalBesselJ(a_,b_),
      Times(Power(b,CN1D2),Sqrt(CPiHalf),BesselJ(Times(C1D2,Plus(C1,Times(C2,a))),b))),
    // SphericalBesselY(a_,b_):=(Sqrt(Pi/2)*BesselY(1/2*(1+2*a),b))/Sqrt(b)
    SetDelayed(SphericalBesselY(a_,b_),
      Times(Power(b,CN1D2),Sqrt(CPiHalf),BesselY(Times(C1D2,Plus(C1,Times(C2,a))),b))),
    // SphericalHankelH1(a_,b_):=(Sqrt(Pi/2)*BesselJ(1/2*(1+2*a),b))/Sqrt(b)+(I*Sqrt(Pi/2)*BesselY(1/2*(1+2*a),b))/Sqrt(b)
    SetDelayed(SphericalHankelH1(a_,b_),
      Plus(Times(Power(b,CN1D2),Sqrt(CPiHalf),BesselJ(Times(C1D2,Plus(C1,Times(C2,a))),b)),Times(CI,Power(b,CN1D2),Sqrt(CPiHalf),BesselY(Times(C1D2,Plus(C1,Times(C2,a))),b)))),
    // SphericalHankelH2(a_,b_):=(Sqrt(Pi/2)*BesselJ(1/2*(1+2*a),b))/Sqrt(b)+(-I*Sqrt(Pi/2)*BesselY(1/2*(1+2*a),b))/Sqrt(b)
    SetDelayed(SphericalHankelH2(a_,b_),
      Plus(Times(Power(b,CN1D2),Sqrt(CPiHalf),BesselJ(Times(C1D2,Plus(C1,Times(C2,a))),b)),Times(CNI,Power(b,CN1D2),Sqrt(CPiHalf),BesselY(Times(C1D2,Plus(C1,Times(C2,a))),b)))),
    // SphericalHarmonicY(a_,1,t_,p_):=(-a*(1+a)*Sqrt(1+2*a)*E^(I*p)*Sqrt(1-Cos(t))*Sqrt(1+Cos(t))*Sqrt(Gamma(a))*Hypergeometric2F1(1-a,2+a,2,Sin(t/2)^2)*Sin(t))/(4*Sqrt(Pi)*Sqrt(1-Cos(t)^2)*Sqrt(Gamma(2+a)))
    SetDelayed(SphericalHarmonicY(a_,C1,t_,p_),
      Times(CN1,a,Plus(C1,a),Sqrt(Plus(C1,Times(C2,a))),Exp(Times(CI,p)),Sqrt(Subtract(C1,Cos(t))),Sqrt(Plus(C1,Cos(t))),Sqrt(Gamma(a)),Power(Times(C4,Sqrt(Pi),Sqrt(Subtract(C1,Sqr(Cos(t)))),Sqrt(Gamma(Plus(C2,a)))),CN1),Hypergeometric2F1(Subtract(C1,a),Plus(C2,a),C2,Sqr(Sin(Times(C1D2,t)))),Sin(t))),
    // SphericalHarmonicY(a_,b_,t_,p_):=(Sqrt(1+2*a)*E^(I*b*p)*(1+Cos(t))^(b/2)*Sqrt(Gamma(1+a-b))*Hypergeometric2F1(-a,1+a,1-b,Sin(t/2)^2)*Sin(t)^b)/((1-Cos(t))^(b/2)*(1-Cos(t)^2)^(b/2)*2*Sqrt(Pi)*Gamma(1-b)*Sqrt(Gamma(1+a+b)))
    SetDelayed(SphericalHarmonicY(a_,b_,t_,p_),
      Times(Sqrt(Plus(C1,Times(C2,a))),Exp(Times(CI,b,p)),Power(Plus(C1,Cos(t)),Times(C1D2,b)),Sqrt(Gamma(Plus(C1,a,Negate(b)))),Power(Times(Power(Subtract(C1,Cos(t)),Times(C1D2,b)),Power(Subtract(C1,Sqr(Cos(t))),Times(C1D2,b)),C2,Sqrt(Pi),Gamma(Subtract(C1,b)),Sqrt(Gamma(Plus(C1,a,b)))),CN1),Hypergeometric2F1(Negate(a),Plus(C1,a),Subtract(C1,b),Sqr(Sin(Times(C1D2,t)))),Power(Sin(t),b))),
    // WeberE(a_,b_):=(2*b*Cos(1/2*a*Pi)^2*HypergeometricPFQ({1},{3/2-a/2,3/2+a/2},(-1)*1/4*b^2))/((-1+a)*(1+a)*Pi)+(2*HypergeometricPFQ({1},{1-a/2,1+a/2},(-1)*1/4*b^2)*Sin(1/2*a*Pi)^2)/(a*Pi)
    SetDelayed(WeberE(a_,b_),
      Plus(Times(C2,b,Power(Times(Plus(CN1,a),Plus(C1,a),Pi),CN1),Sqr(Cos(Times(C1D2,a,Pi))),HypergeometricPFQ(List(C1),List(Plus(QQ(3L,2L),Times(CN1D2,a)),Plus(QQ(3L,2L),Times(C1D2,a))),Times(CN1,C1D4,Sqr(b)))),Times(C2,Power(Times(a,Pi),CN1),HypergeometricPFQ(List(C1),List(Plus(C1,Times(CN1D2,a)),Plus(C1,Times(C1D2,a))),Times(CN1,C1D4,Sqr(b))),Sqr(Sin(Times(C1D2,a,Pi)))))),
    // WeberE(a_,b_,c_):=(-c*Cos(1/2*a*Pi)*Gamma(2+b)*HypergeometricPFQ({1+b/2,3/2+b/2},{3/2,3/2-a/2+b/2,3/2+a/2+b/2},(-1)*1/4*c^2))/(2*Gamma(3/2-a/2+b/2)*Gamma(3/2+a/2+b/2))+(Gamma(1+b)*HypergeometricPFQ({1/2+b/2,1+b/2},{1/2,1-a/2+b/2,1+a/2+b/2},(-1)*1/4*c^2)*Sin(1/2*a*Pi))/(Gamma(1-a/2+b/2)*Gamma(1+a/2+b/2))
    SetDelayed(WeberE(a_,b_,c_),
      Plus(Times(CN1,c,Cos(Times(C1D2,a,Pi)),Power(Times(C2,Gamma(Plus(QQ(3L,2L),Times(CN1D2,a),Times(C1D2,b))),Gamma(Plus(QQ(3L,2L),Times(C1D2,a),Times(C1D2,b)))),CN1),Gamma(Plus(C2,b)),HypergeometricPFQ(List(Plus(C1,Times(C1D2,b)),Plus(QQ(3L,2L),Times(C1D2,b))),List(QQ(3L,2L),Plus(QQ(3L,2L),Times(CN1D2,a),Times(C1D2,b)),Plus(QQ(3L,2L),Times(C1D2,a),Times(C1D2,b))),Times(CN1,C1D4,Sqr(c)))),Times(Power(Times(Gamma(Plus(C1,Times(CN1D2,a),Times(C1D2,b))),Gamma(Plus(C1,Times(C1D2,a),Times(C1D2,b)))),CN1),Gamma(Plus(C1,b)),HypergeometricPFQ(List(Plus(C1D2,Times(C1D2,b)),Plus(C1,Times(C1D2,b))),List(C1D2,Plus(C1,Times(CN1D2,a),Times(C1D2,b)),Plus(C1,Times(C1D2,a),Times(C1D2,b))),Times(CN1,C1D4,Sqr(c))),Sin(Times(C1D2,a,Pi))))),
    // WhittakerM(k_,m_,z_):=(z^(1/2+m)*Hypergeometric1F1(1/2-k+m,1+2*m,z))/E^(z/2)
    SetDelayed(WhittakerM(k_,m_,z_),
      Times(Power(Exp(Times(C1D2,z)),CN1),Power(z,Plus(C1D2,m)),Hypergeometric1F1(Plus(C1D2,Negate(k),m),Plus(C1,Times(C2,m)),z))),
    // WhittakerW(k_,m_,z_):=(z^(1/2+m)*HypergeometricU(1/2-k+m,1+2*m,z))/E^(z/2)
    SetDelayed(WhittakerW(k_,m_,z_),
      Times(Power(Exp(Times(C1D2,z)),CN1),Power(z,Plus(C1D2,m)),HypergeometricU(Plus(C1D2,Negate(k),m),Plus(C1,Times(C2,m)),z)))
  );
}
