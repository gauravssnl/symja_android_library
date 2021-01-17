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
public class IntRules190 { 
  public static IAST RULES = List( 
IIntegrate(3801,Integrate(Times(Sqrt(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT)),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Dist(Times(CN2,a,Sqrt(Times(a,d,Power(b,CN1))),Power(Times(b,f),CN1)),Subst(Integrate(Power(Plus(C1,Times(Sqr(x),Power(a,CN1))),CN1D2),x),x,Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),CN1D2))),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),GtQ(Times(a,d,Power(b,CN1)),C0)))),
IIntegrate(3802,Integrate(Times(Sqrt(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT)),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Dist(Times(CN2,b,d,Power(f,CN1)),Subst(Integrate(Power(Subtract(b,Times(d,Sqr(x))),CN1),x),x,Times(b,Cot(Plus(e,Times(f,x))),Power(Times(Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Sqrt(Times(d,Csc(Plus(e,Times(f,x)))))),CN1))),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),Not(GtQ(Times(a,d,Power(b,CN1)),C0))))),
IIntegrate(3803,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Plus(Simp(Times(CN2,b,d,Cot(Plus(e,Times(f,x))),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Power(Times(f,Subtract(Times(C2,n),C1),Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))))),CN1)),x),Dist(Times(C2,a,d,Subtract(n,C1),Power(Times(b,Subtract(Times(C2,n),C1)),CN1)),Integrate(Times(Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),GtQ(n,C1),IntegerQ(Times(C2,n))))),
IIntegrate(3804,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),CN1D2),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Simp(Times(CN2,a,Cot(Plus(e,Times(f,x))),Power(Times(f,Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Sqrt(Times(d,Csc(Plus(e,Times(f,x)))))),CN1)),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3805,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Plus(Simp(Times(a,Cot(Plus(e,Times(f,x))),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,n,Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))))),CN1)),x),Dist(Times(a,Plus(Times(C2,n),C1),Power(Times(C2,b,d,n),CN1)),Integrate(Times(Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),LtQ(n,Negate(C1D2)),IntegerQ(Times(C2,n))))),
IIntegrate(3806,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Sqrt(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_))),x_Symbol),
    Condition(Dist(Times(Sqr(a),d,Cot(Plus(e,Times(f,x))),Power(Times(f,Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Sqrt(Subtract(a,Times(b,Csc(Plus(e,Times(f,x))))))),CN1)),Subst(Integrate(Times(Power(Times(d,x),Subtract(n,C1)),Power(Subtract(a,Times(b,x)),CN1D2)),x),x,Csc(Plus(e,Times(f,x)))),x),And(FreeQ(List(a,b,d,e,f,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3807,Integrate(Times(Sqrt(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT)),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1D2)),x_Symbol),
    Condition(Negate(Dist(Times(CSqrt2,Sqrt(a),Power(Times(b,f),CN1)),Subst(Integrate(Power(Plus(C1,Sqr(x)),CN1D2),x),x,Times(b,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),CN1))),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),EqQ(Subtract(d,Times(a,Power(b,CN1))),C0),GtQ(a,C0)))),
IIntegrate(3808,Integrate(Times(Sqrt(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT)),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1D2)),x_Symbol),
    Condition(Dist(Times(CN2,b,d,Power(Times(a,f),CN1)),Subst(Integrate(Power(Subtract(Times(C2,b),Times(d,Sqr(x))),CN1),x),x,Times(b,Cot(Plus(e,Times(f,x))),Power(Times(Sqrt(Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),Sqrt(Times(d,Csc(Plus(e,Times(f,x)))))),CN1))),x),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0)))),
IIntegrate(3809,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(a,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,m),CN1)),x)),Dist(Times(b,Subtract(Times(C2,m),C1),Power(Times(d,m),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),EqQ(Plus(m,n),C0),GtQ(m,C1D2),IntegerQ(Times(C2,m))))),
IIntegrate(3810,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Simp(Times(b,d,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Power(Times(a,f,Plus(Times(C2,m),C1)),CN1)),x),Dist(Times(d,Plus(m,C1),Power(Times(b,Plus(Times(C2,m),C1)),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),EqQ(Plus(m,n),C0),LtQ(m,Negate(C1D2)),IntegerQ(Times(C2,m))))),
IIntegrate(3811,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,Plus(Times(C2,m),C1)),CN1)),x)),Dist(Times(m,Power(Times(a,Plus(Times(C2,m),C1)),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n)),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),EqQ(Plus(m,n,C1),C0),LtQ(m,Negate(C1D2))))),
IIntegrate(3812,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,Plus(m,C1)),CN1)),x)),Dist(Times(a,m,Power(Times(b,d,Plus(m,C1)),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1))),x),x)),And(FreeQ(List(a,b,d,e,f,m,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),EqQ(Plus(m,n,C1),C0),Not(LtQ(m,Negate(C1D2)))))),
IIntegrate(3813,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Subtract(Simp(Times(Sqr(b),Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C2)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,n),CN1)),x),Dist(Times(a,Power(Times(d,n),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C2)),Power(Times(d,Csc(Plus(e,Times(f,x)))),Plus(n,C1)),Subtract(Times(b,Subtract(Subtract(m,Times(C2,n)),C2)),Times(a,Subtract(Plus(m,Times(C2,n)),C1),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),GtQ(m,C1),Or(LtQ(n,CN1),And(EqQ(m,QQ(3L,2L)),EqQ(n,Negate(C1D2)))),IntegerQ(Times(C2,m))))),
IIntegrate(3814,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(b),Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C2)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,Subtract(Plus(m,n),C1)),CN1)),x)),Dist(Times(b,Power(Subtract(Plus(m,n),C1),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Subtract(m,C2)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Plus(Times(b,Subtract(Plus(m,Times(C2,n)),C1)),Times(a,Subtract(Plus(Times(C3,m),Times(C2,n)),C4),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),GtQ(m,C1),NeQ(Subtract(Plus(m,n),C1),C0),IntegerQ(Times(C2,m))))),
IIntegrate(3815,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Subtract(Simp(Times(b,d,Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Power(Times(a,f,Plus(Times(C2,m),C1)),CN1)),x),Dist(Times(d,Power(Times(a,b,Plus(Times(C2,m),C1)),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Subtract(Times(a,Subtract(n,C1)),Times(b,Plus(m,n),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),LtQ(m,CN1),LtQ(C1,n,C2),Or(IntegersQ(Times(C2,m),Times(C2,n)),IntegerQ(m))))),
IIntegrate(3816,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Sqr(d),Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C2)),Power(Times(f,Plus(Times(C2,m),C1)),CN1)),x)),Dist(Times(Sqr(d),Power(Times(a,b,Plus(Times(C2,m),C1)),CN1)),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C2)),Plus(Times(b,Subtract(n,C2)),Times(a,Plus(m,Negate(n),C2),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),LtQ(m,CN1),GtQ(n,C2),Or(IntegersQ(Times(C2,m),Times(C2,n)),IntegerQ(m))))),
IIntegrate(3817,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),m_)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),m),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,Plus(Times(C2,m),C1)),CN1)),x)),Dist(Power(Times(Sqr(a),Plus(Times(C2,m),C1)),CN1),Integrate(Times(Power(Plus(a,Times(b,Csc(Plus(e,Times(f,x))))),Plus(m,C1)),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Subtract(Times(a,Plus(Times(C2,m),n,C1)),Times(b,Plus(m,n,C1),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),LtQ(m,CN1),Or(IntegersQ(Times(C2,m),Times(C2,n)),IntegerQ(m))))),
IIntegrate(3818,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1)),x_Symbol),
    Condition(Subtract(Simp(Times(Sqr(d),Cot(Plus(e,Times(f,x))),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C2)),Power(Times(f,Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),CN1)),x),Dist(Times(Sqr(d),Power(Times(a,b),CN1)),Integrate(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C2)),Subtract(Times(b,Subtract(n,C2)),Times(a,Subtract(n,C1),Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),GtQ(n,C1)))),
IIntegrate(3819,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1)),x_Symbol),
    Condition(Subtract(Simp(Times(Cot(Plus(e,Times(f,x))),Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Power(Times(f,Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),CN1)),x),Dist(Power(a,CN2),Integrate(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),n),Subtract(Times(a,Subtract(n,C1)),Times(b,n,Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0),LtQ(n,C0)))),
IIntegrate(3820,Integrate(Times(Power(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),d_DEFAULT),n_),Power(Plus(Times($($s("§csc"),Plus(e_DEFAULT,Times(f_DEFAULT,x_))),b_DEFAULT),a_),CN1)),x_Symbol),
    Condition(Plus(Negate(Simp(Times(b,d,Cot(Plus(e,Times(f,x))),Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Power(Times(a,f,Plus(a,Times(b,Csc(Plus(e,Times(f,x)))))),CN1)),x)),Dist(Times(d,Subtract(n,C1),Power(Times(a,b),CN1)),Integrate(Times(Power(Times(d,Csc(Plus(e,Times(f,x)))),Subtract(n,C1)),Subtract(a,Times(b,Csc(Plus(e,Times(f,x)))))),x),x)),And(FreeQ(List(a,b,d,e,f,n),x),EqQ(Subtract(Sqr(a),Sqr(b)),C0))))
  );
}
