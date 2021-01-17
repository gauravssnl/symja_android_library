package org.matheclipse.core.integrate.rubi;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="https://rulebasedintegration.org/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules4 { 
  public static IAST RULES = List( 
IIntegrate(81,Integrate(Times(Sqr(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Simp(Times(b,Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Plus(Times(C2,a,d,f,Plus(n,p,C3)),Times(CN1,b,Plus(Times(d,e,Plus(n,C2)),Times(c,f,Plus(p,C2)))),Times(b,d,f,Plus(n,p,C2),x)),Power(Times(Sqr(d),Sqr(f),Plus(n,p,C2),Plus(n,p,C3)),CN1)),x),And(FreeQ(List(a,b,c,d,e,f,n,p),x),NeQ(Plus(n,p,C2),C0),NeQ(Plus(n,p,C3),C0),EqQ(Subtract(Times(d,f,Plus(n,p,C2),Subtract(Times(Sqr(a),d,f,Plus(n,p,C3)),Times(b,Plus(Times(b,c,e),Times(a,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))))))),Times(b,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1))),Subtract(Times(a,d,f,Plus(n,p,C4)),Times(b,Plus(Times(d,e,Plus(n,C2)),Times(c,f,Plus(p,C2))))))),C0)))),
IIntegrate(82,Integrate(Times(Power(Times(f_DEFAULT,x_),p_DEFAULT),Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT)),x_Symbol),
    Condition(Plus(Dist(a,Integrate(Times(Power(Plus(a,Times(b,x)),n),Power(Plus(c,Times(d,x)),n),Power(Times(f,x),p)),x),x),Dist(Times(b,Power(f,CN1)),Integrate(Times(Power(Plus(a,Times(b,x)),n),Power(Plus(c,Times(d,x)),n),Power(Times(f,x),Plus(p,C1))),x),x)),And(FreeQ(List(a,b,c,d,f,m,n,p),x),EqQ(Plus(Times(b,c),Times(a,d)),C0),EqQ(Subtract(Subtract(m,n),C1),C0),Not(RationalQ(p)),Not(IGtQ(m,C0)),NeQ(Plus(m,n,p,C2),C0)))),
IIntegrate(83,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Dist(Times(Subtract(Times(b,e),Times(a,f)),Power(Subtract(Times(b,c),Times(a,d)),CN1)),Integrate(Times(Power(Plus(e,Times(f,x)),Subtract(p,C1)),Power(Plus(a,Times(b,x)),CN1)),x),x),Dist(Times(Subtract(Times(d,e),Times(c,f)),Power(Subtract(Times(b,c),Times(a,d)),CN1)),Integrate(Times(Power(Plus(e,Times(f,x)),Subtract(p,C1)),Power(Plus(c,Times(d,x)),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),LtQ(C0,p,C1)))),
IIntegrate(84,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Plus(e,Times(f,x)),Subtract(p,C1)),Power(Times(b,d,Subtract(p,C1)),CN1)),x),Dist(Power(Times(b,d),CN1),Integrate(Times(Plus(Times(b,d,Sqr(e)),Times(CN1,a,c,Sqr(f)),Times(f,Subtract(Subtract(Times(C2,b,d,e),Times(b,c,f)),Times(a,d,f)),x)),Power(Plus(e,Times(f,x)),Subtract(p,C2)),Power(Times(Plus(a,Times(b,x)),Plus(c,Times(d,x))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),GtQ(p,C1)))),
IIntegrate(85,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_)),x_Symbol),
    Condition(Plus(Simp(Times(f,Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(p,C1),Subtract(Times(b,e),Times(a,f)),Subtract(Times(d,e),Times(c,f))),CN1)),x),Dist(Power(Times(Subtract(Times(b,e),Times(a,f)),Subtract(Times(d,e),Times(c,f))),CN1),Integrate(Times(Subtract(Subtract(Subtract(Times(b,d,e),Times(b,c,f)),Times(a,d,f)),Times(b,d,f,x)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(a,Times(b,x)),Plus(c,Times(d,x))),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),LtQ(p,CN1)))),
IIntegrate(86,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_)),x_Symbol),
    Condition(Subtract(Dist(Times(b,Power(Subtract(Times(b,c),Times(a,d)),CN1)),Integrate(Times(Power(Plus(e,Times(f,x)),p),Power(Plus(a,Times(b,x)),CN1)),x),x),Dist(Times(d,Power(Subtract(Times(b,c),Times(a,d)),CN1)),Integrate(Times(Power(Plus(e,Times(f,x)),p),Power(Plus(c,Times(d,x)),CN1)),x),x)),And(FreeQ(List(a,b,c,d,e,f,p),x),Not(IntegerQ(p))))),
IIntegrate(87,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_)),x_Symbol),
    Condition(Integrate(ExpandIntegrand(Power(Plus(e,Times(f,x)),FractionalPart(p)),Times(Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),IntegerPart(p)),Power(Plus(a,Times(b,x)),CN1)),x),x),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(n,C0),LtQ(p,CN1),FractionQ(p)))),
IIntegrate(88,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_DEFAULT),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Integrate(ExpandIntegrand(Times(Power(Plus(a,Times(b,x)),m),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p)),x),x),And(FreeQ(List(a,b,c,d,e,f,p),x),IntegersQ(m,n),Or(IntegerQ(p),And(GtQ(m,C0),GeQ(n,CN1)))))),
IIntegrate(89,Integrate(Times(Sqr(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Sqr(Subtract(Times(b,c),Times(a,d))),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Sqr(d),Subtract(Times(d,e),Times(c,f)),Plus(n,C1)),CN1)),x),Dist(Power(Times(Sqr(d),Subtract(Times(d,e),Times(c,f)),Plus(n,C1)),CN1),Integrate(Times(Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),p),Simp(Subtract(Subtract(Plus(Times(Sqr(a),Sqr(d),f,Plus(n,p,C2)),Times(Sqr(b),c,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1))))),Times(C2,a,b,d,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1))))),Times(Sqr(b),d,Subtract(Times(d,e),Times(c,f)),Plus(n,C1),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,n,p),x),Or(LtQ(n,CN1),And(EqQ(Plus(n,p,C3),C0),NeQ(n,CN1),Or(SumSimplerQ(n,C1),Not(SumSimplerQ(p,C1)))))))),
IIntegrate(90,Integrate(Times(Sqr(Plus(a_DEFAULT,Times(b_DEFAULT,x_))),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(b,Plus(a,Times(b,x)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(d,f,Plus(n,p,C3)),CN1)),x),Dist(Power(Times(d,f,Plus(n,p,C3)),CN1),Integrate(Times(Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(Sqr(a),d,f,Plus(n,p,C3)),Times(CN1,b,Plus(Times(b,c,e),Times(a,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))))),Times(b,Subtract(Times(a,d,f,Plus(n,p,C4)),Times(b,Plus(Times(d,e,Plus(n,C2)),Times(c,f,Plus(p,C2))))),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,n,p),x),NeQ(Plus(n,p,C3),C0)))),
IIntegrate(91,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1D3),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),QQ(-2L,3L)),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1)),x_Symbol),
    Condition(With(List(Set(q,Rt(Times(Subtract(Times(d,e),Times(c,f)),Power(Subtract(Times(b,e),Times(a,f)),CN1)),C3))),Plus(Negate(Simp(Times(CSqrt3,q,ArcTan(Plus(C1DSqrt3,Times(C2,q,Power(Plus(a,Times(b,x)),C1D3),Power(Times(CSqrt3,Power(Plus(c,Times(d,x)),C1D3)),CN1)))),Power(Subtract(Times(d,e),Times(c,f)),CN1)),x)),Simp(Times(q,Log(Plus(e,Times(f,x))),Power(Times(C2,Subtract(Times(d,e),Times(c,f))),CN1)),x),Negate(Simp(Times(C3,q,Log(Subtract(Times(q,Power(Plus(a,Times(b,x)),C1D3)),Power(Plus(c,Times(d,x)),C1D3))),Power(Times(C2,Subtract(Times(d,e),Times(c,f))),CN1)),x)))),FreeQ(List(a,b,c,d,e,f),x))),
IIntegrate(92,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),CN1D2),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),CN1D2),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1)),x_Symbol),
    Condition(Dist(Times(b,f),Subst(Integrate(Power(Plus(Times(d,Sqr(Subtract(Times(b,e),Times(a,f)))),Times(b,Sqr(f),Sqr(x))),CN1),x),x,Times(Sqrt(Plus(a,Times(b,x))),Sqrt(Plus(c,Times(d,x))))),x),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Subtract(Times(C2,b,d,e),Times(f,Plus(Times(b,c),Times(a,d)))),C0)))),
IIntegrate(93,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),CN1)),x_Symbol),
    Condition(With(List(Set(q,Denominator(m))),Dist(q,Subst(Integrate(Times(Power(x,Subtract(Times(q,Plus(m,C1)),C1)),Power(Subtract(Subtract(Times(b,e),Times(a,f)),Times(Subtract(Times(d,e),Times(c,f)),Power(x,q))),CN1)),x),x,Times(Power(Plus(a,Times(b,x)),Power(q,CN1)),Power(Power(Plus(c,Times(d,x)),Power(q,CN1)),CN1))),x)),And(FreeQ(List(a,b,c,d,e,f),x),EqQ(Plus(m,n,C1),C0),RationalQ(n),LtQ(CN1,m,C0),SimplerQ(Plus(a,Times(b,x)),Plus(c,Times(d,x)))))),
IIntegrate(94,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Subtract(Times(b,e),Times(a,f))),CN1)),x),Dist(Times(n,Subtract(Times(d,e),Times(c,f)),Power(Times(Plus(m,C1),Subtract(Times(b,e),Times(a,f))),CN1)),Integrate(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C1)),Power(Plus(e,Times(f,x)),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,p),x),EqQ(Plus(m,n,p,C2),C0),GtQ(n,C0),Not(And(SumSimplerQ(p,C1),Not(SumSimplerQ(m,C1))))))),
IIntegrate(95,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Simp(Times(b,Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Subtract(Times(b,e),Times(a,f))),CN1)),x),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),EqQ(Simplify(Plus(m,n,p,C3)),C0),EqQ(Plus(Times(a,d,f,Plus(m,C1)),Times(b,c,f,Plus(n,C1)),Times(b,d,e,Plus(p,C1))),C0),NeQ(m,CN1)))),
IIntegrate(96,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Subtract(Times(b,e),Times(a,f))),CN1)),x),Dist(Times(Plus(Times(a,d,f,Plus(m,C1)),Times(b,c,f,Plus(n,C1)),Times(b,d,e,Plus(p,C1))),Power(Times(Plus(m,C1),Subtract(Times(b,c),Times(a,d)),Subtract(Times(b,e),Times(a,f))),CN1)),Integrate(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p)),x),x)),And(FreeQ(List(a,b,c,d,e,f,m,n,p),x),EqQ(Simplify(Plus(m,n,p,C3)),C0),Or(LtQ(m,CN1),SumSimplerQ(m,C1))))),
IIntegrate(97,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Power(Times(b,Plus(m,C1)),CN1)),x),Dist(Power(Times(b,Plus(m,C1)),CN1),Integrate(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C1)),Power(Plus(e,Times(f,x)),Subtract(p,C1)),Simp(Plus(Times(d,e,n),Times(c,f,p),Times(d,f,Plus(n,p),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),LtQ(m,CN1),GtQ(n,C0),GtQ(p,C0),Or(IntegersQ(Times(C2,m),Times(C2,n),Times(C2,p)),IntegersQ(m,Plus(n,p)),IntegersQ(p,Plus(m,n)))))),
IIntegrate(98,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(Subtract(Times(b,c),Times(a,d)),Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(b,Subtract(Times(b,e),Times(a,f)),Plus(m,C1)),CN1)),x),Dist(Power(Times(b,Subtract(Times(b,e),Times(a,f)),Plus(m,C1)),CN1),Integrate(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C2)),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(a,d,Plus(Times(d,e,Subtract(n,C1)),Times(c,f,Plus(p,C1)))),Times(b,c,Subtract(Times(d,e,Plus(m,Negate(n),C2)),Times(c,f,Plus(m,p,C2)))),Times(d,Plus(Times(a,d,f,Plus(n,p)),Times(b,Subtract(Times(d,e,Plus(m,C1)),Times(c,f,Plus(m,n,p,C1))))),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,p),x),LtQ(m,CN1),GtQ(n,C1),Or(IntegersQ(Times(C2,m),Times(C2,n),Times(C2,p)),IntegersQ(m,Plus(n,p)),IntegersQ(p,Plus(m,n)))))),
IIntegrate(99,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Subtract(Simp(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(Plus(m,C1),Subtract(Times(b,e),Times(a,f))),CN1)),x),Dist(Power(Times(Plus(m,C1),Subtract(Times(b,e),Times(a,f))),CN1),Integrate(Times(Power(Plus(a,Times(b,x)),Plus(m,C1)),Power(Plus(c,Times(d,x)),Subtract(n,C1)),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(d,e,n),Times(c,f,Plus(m,p,C2)),Times(d,f,Plus(m,n,p,C2),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,p),x),LtQ(m,CN1),GtQ(n,C0),Or(IntegersQ(Times(C2,m),Times(C2,n),Times(C2,p)),IntegersQ(m,Plus(n,p)),IntegersQ(p,Plus(m,n)))))),
IIntegrate(100,Integrate(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,x_)),m_),Power(Plus(c_DEFAULT,Times(d_DEFAULT,x_)),n_DEFAULT),Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),p_DEFAULT)),x_Symbol),
    Condition(Plus(Simp(Times(b,Power(Plus(a,Times(b,x)),Subtract(m,C1)),Power(Plus(c,Times(d,x)),Plus(n,C1)),Power(Plus(e,Times(f,x)),Plus(p,C1)),Power(Times(d,f,Plus(m,n,p,C1)),CN1)),x),Dist(Power(Times(d,f,Plus(m,n,p,C1)),CN1),Integrate(Times(Power(Plus(a,Times(b,x)),Subtract(m,C2)),Power(Plus(c,Times(d,x)),n),Power(Plus(e,Times(f,x)),p),Simp(Plus(Times(Sqr(a),d,f,Plus(m,n,p,C1)),Times(CN1,b,Plus(Times(b,c,e,Subtract(m,C1)),Times(a,Plus(Times(d,e,Plus(n,C1)),Times(c,f,Plus(p,C1)))))),Times(b,Subtract(Times(a,d,f,Plus(Times(C2,m),n,p)),Times(b,Plus(Times(d,e,Plus(m,n)),Times(c,f,Plus(m,p))))),x)),x)),x),x)),And(FreeQ(List(a,b,c,d,e,f,n,p),x),GtQ(m,C1),NeQ(Plus(m,n,p,C1),C0),IntegerQ(m))))
  );
}
