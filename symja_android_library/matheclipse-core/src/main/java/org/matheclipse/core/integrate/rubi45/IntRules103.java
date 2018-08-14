package org.matheclipse.core.integrate.rubi45;


import static org.matheclipse.core.expression.F.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctionCtors.*;
import static org.matheclipse.core.integrate.rubi45.UtilityFunctions.*;
import org.matheclipse.core.interfaces.IAST;

/** 
 * IndefiniteIntegrationRules from the <a href="http://www.apmaths.uwo.ca/~arich/">Rubi -
 * rule-based integrator</a>.
 *  
 */
public class IntRules103 { 
  public static IAST RULES = List( 
ISetDelayed(9110,Int(Times(Power(Times(d_DEFAULT,x_),m_DEFAULT),ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Power(Times(d,Plus(m,C1)),-1)),x),Negate(Dist(Times(c,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(Times(d,x),Plus(m,C1)),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x))),And(FreeQ(List(a,b,c,d,m),x),EqQ(Plus(b,Sqr(c)),C0),NeQ(m,CN1)))),
ISetDelayed(9111,Int(Times(Power(Times(d_DEFAULT,x_),m_DEFAULT),ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Times(d,x),Plus(m,C1)),ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Power(Times(d,Plus(m,C1)),-1)),x),Dist(Times(c,Power(Times(d,Plus(m,C1)),-1)),Int(Times(Power(Times(d,x),Plus(m,C1)),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x)),And(FreeQ(List(a,b,c,d,m),x),EqQ(Plus(b,Sqr(c)),C0),NeQ(m,CN1)))),
ISetDelayed(9112,Int(Power(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_)))),ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)))),-1),x_Symbol),
    Condition(Simp(Times(C1,Log(ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),Power(c,-1)),x),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0)))),
ISetDelayed(9113,Int(Power(Times(Sqrt(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_)))),ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2)))),-1),x_Symbol),
    Condition(Negate(Simp(Times(Log(ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2)))),Power(c,-1)),x)),And(FreeQ(List(a,b,c),x),EqQ(Plus(b,Sqr(c)),C0)))),
ISetDelayed(9114,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2),Power(ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT)),x_Symbol),
    Condition(Simp(Times(Power(ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Plus(m,C1)),Power(Times(c,Plus(m,C1)),-1)),x),And(FreeQ(List(a,b,c,m),x),EqQ(Plus(b,Sqr(c)),C0),NeQ(m,CN1)))),
ISetDelayed(9115,Int(Times(Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2),Power(ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT)),x_Symbol),
    Condition(Negate(Simp(Times(Power(ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),Plus(m,C1)),Power(Times(c,Plus(m,C1)),-1)),x)),And(FreeQ(List(a,b,c,m),x),EqQ(Plus(b,Sqr(c)),C0),NeQ(m,CN1)))),
ISetDelayed(9116,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(ArcTan(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(ArcTan(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),m),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(Plus(b,Sqr(c)),C0),EqQ(Plus(Times(b,d),Times(CN1,a,e)),C0)))),
ISetDelayed(9117,Int(Times(Power(Plus(d_DEFAULT,Times(e_DEFAULT,Sqr(x_))),CN1D2),Power(ArcCot(Times(c_DEFAULT,x_,Power(Plus(a_DEFAULT,Times(b_DEFAULT,Sqr(x_))),CN1D2))),m_DEFAULT)),x_Symbol),
    Condition(Dist(Times(Sqrt(Plus(a,Times(b,Sqr(x)))),Power(Plus(d,Times(e,Sqr(x))),CN1D2)),Int(Times(Power(ArcCot(Times(c,x,Power(Plus(a,Times(b,Sqr(x))),CN1D2))),m),Power(Plus(a,Times(b,Sqr(x))),CN1D2)),x),x),And(FreeQ(List(a,b,c,d,e,m),x),EqQ(Plus(b,Sqr(c)),C0),EqQ(Plus(Times(b,d),Times(CN1,a,e)),C0)))),
ISetDelayed(9118,Int(Times(u_DEFAULT,ArcTan(Plus(v_,Times(s_DEFAULT,Sqrt(w_))))),x_Symbol),
    Condition(Plus(Dist(Times(C1D4,Pi,s),Int(u,x),x),Dist(C1D2,Int(Times(u,ArcTan(v)),x),x)),And(EqQ(Sqr(s),C1),EqQ(w,Plus(Sqr(v),C1))))),
ISetDelayed(9119,Int(Times(u_DEFAULT,ArcCot(Plus(v_,Times(s_DEFAULT,Sqrt(w_))))),x_Symbol),
    Condition(Plus(Dist(Times(C1D4,Pi,s),Int(u,x),x),Negate(Dist(C1D2,Int(Times(u,ArcTan(v)),x),x))),And(EqQ(Sqr(s),C1),EqQ(w,Plus(Sqr(v),C1))))),
ISetDelayed(9120,Int(Times(u_,Power(v_,n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("tmp"),InverseFunctionOfLinear(u,x))),Condition(Dist(Times(Power(Times(CN1,Discriminant(v,x),Power(Times(C4,Coefficient(v,x,C2)),-1)),n),Power(Coefficient(Part($s("tmp"),C1),x,C1),-1)),Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u,$s("tmp"),x),Power(Sec(x),Times(C2,Plus(n,C1)))),x),x),x,$s("tmp")),x),And(Not(FalseQ($s("tmp"))),EqQ(Head($s("tmp")),$s("ArcTan")),EqQ(Plus(Times(Discriminant(v,x),Sqr(Part($s("tmp"),C1))),Sqr(D(v,x))),C0)))),And(QuadraticQ(v,x),ILtQ(n,C0),NegQ(Discriminant(v,x)),MatchQ(u,Condition(Times(r_DEFAULT,Power(f_,w_)),FreeQ(f,x)))))),
ISetDelayed(9121,Int(Times(u_,Power(v_,n_DEFAULT)),x_Symbol),
    Condition(With(List(Set($s("tmp"),InverseFunctionOfLinear(u,x))),Condition(Negate(Dist(Times(Power(Times(CN1,Discriminant(v,x),Power(Times(C4,Coefficient(v,x,C2)),-1)),n),Power(Coefficient(Part($s("tmp"),C1),x,C1),-1)),Subst(Int(SimplifyIntegrand(Times(SubstForInverseFunction(u,$s("tmp"),x),Power(Csc(x),Times(C2,Plus(n,C1)))),x),x),x,$s("tmp")),x)),And(Not(FalseQ($s("tmp"))),EqQ(Head($s("tmp")),$s("ArcCot")),EqQ(Plus(Times(Discriminant(v,x),Sqr(Part($s("tmp"),C1))),Sqr(D(v,x))),C0)))),And(QuadraticQ(v,x),ILtQ(n,C0),NegQ(Discriminant(v,x)),MatchQ(u,Condition(Times(r_DEFAULT,Power(f_,w_)),FreeQ(f,x)))))),
ISetDelayed(9122,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9123,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9124,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9125,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b),Int(Times(x,Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9126,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Dist(Times(b,Plus(C1,Times(CN1,CI,c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),d,Times(Plus(C1,Times(CN1,CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,Times(CI,c),d)),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),Negate(d),Times(Plus(C1,Times(CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9127,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Tan(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(b,Plus(C1,Times(CN1,CI,c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),d,Times(Plus(C1,Times(CN1,CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,Times(CI,c),d)),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),Negate(d),Times(Plus(C1,Times(CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9128,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Dist(Times(b,Plus(C1,Times(CI,c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),d,Times(CN1,Plus(C1,Times(CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,Times(CN1,CI,c),d)),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),Negate(d),Times(CN1,Plus(C1,Times(CN1,CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9129,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Cot(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(b,Plus(C1,Times(CI,c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),d,Times(CN1,Plus(C1,Times(CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,Times(CN1,CI,c),d)),Int(Times(x,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),Negate(d),Times(CN1,Plus(C1,Times(CN1,CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9130,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9131,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CI,d),Times(c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9132,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9133,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Times(CN1,CI,d),Times(CN1,c,Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9134,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Plus(C1,Times(CN1,CI,c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),d,Times(Plus(C1,Times(CN1,CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,Times(CI,c),d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),Negate(d),Times(Plus(C1,Times(CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9135,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tan(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Tan(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(C1,Times(CN1,CI,c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),d,Times(Plus(C1,Times(CN1,CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,Times(CI,c),d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),Negate(d),Times(Plus(C1,Times(CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CI,d))),CN1)))),
ISetDelayed(9136,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Plus(C1,Times(CI,c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),d,Times(CN1,Plus(C1,Times(CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x),Negate(Dist(Times(b,Plus(C1,Times(CN1,CI,c),d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),Negate(d),Times(CN1,Plus(C1,Times(CN1,CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9137,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Cot(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Cot(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Plus(C1,Times(CI,c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CI,c),d,Times(CN1,Plus(C1,Times(CI,c),Negate(d)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),Dist(Times(b,Plus(C1,Times(CN1,CI,c),d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))),Power(Plus(C1,Times(CN1,CI,c),Negate(d),Times(CN1,Plus(C1,Times(CN1,CI,c),d),Exp(Plus(Times(C2,CI,a),Times(C2,CI,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Times(CN1,CI,d))),CN1)))),
ISetDelayed(9138,Int(ArcTan(Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Tanh(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x))),
ISetDelayed(9139,Int(ArcCot(Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Tanh(Plus(a,Times(b,x))))),x),Dist(b,Int(Times(x,Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x)),FreeQ(List(a,b),x))),
ISetDelayed(9140,Int(ArcTan(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Coth(Plus(a,Times(b,x))))),x),Dist(b,Int(Times(x,Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x)),FreeQ(List(a,b),x))),
ISetDelayed(9141,Int(ArcCot(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Coth(Plus(a,Times(b,x))))),x),Negate(Dist(b,Int(Times(x,Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),FreeQ(List(a,b),x))),
ISetDelayed(9142,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Tanh(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
ISetDelayed(9143,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Tanh(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x)),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
ISetDelayed(9144,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Coth(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x)),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
ISetDelayed(9145,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Coth(Plus(a,Times(b,x)))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Sech(Plus(Times(C2,a),Times(C2,b,x)))),x),x))),And(FreeQ(List(a,b,e,f),x),IGtQ(m,C0)))),
ISetDelayed(9146,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Negate(Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9147,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9148,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Negate(Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9149,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Dist(b,Int(Times(x,Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9150,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(CI,b,Plus(CI,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9151,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Tanh(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(CI,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9152,Int(ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcTan(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Negate(Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(CN1,Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(CI,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(CN1,Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9153,Int(ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_)))))),x_Symbol),
    Condition(Plus(Simp(Times(x,ArcCot(Plus(c,Times(d,Coth(Plus(a,Times(b,x))))))),x),Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d))),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(CN1,Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(CI,b,Plus(CI,c,d)),Int(Times(x,Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(CN1,Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d),x),NeQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9154,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9155,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9156,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9157,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Coth(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Coth(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(b,Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Power(Plus(c,Negate(d),Times(CN1,c,Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),EqQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9158,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcTan(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcTan(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x),Negate(Dist(Times(CI,b,Plus(CI,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x))),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),CN1)))),
ISetDelayed(9159,Int(Times(Power(Plus(e_DEFAULT,Times(f_DEFAULT,x_)),m_DEFAULT),ArcCot(Plus(c_DEFAULT,Times(d_DEFAULT,Tanh(Plus(a_DEFAULT,Times(b_DEFAULT,x_))))))),x_Symbol),
    Condition(Plus(Simp(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),ArcCot(Plus(c,Times(d,Tanh(Plus(a,Times(b,x)))))),Power(Times(f,Plus(m,C1)),-1)),x),Negate(Dist(Times(CI,b,Plus(CI,Negate(c),Negate(d)),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,Negate(c),d,Times(Plus(CI,Negate(c),Negate(d)),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),Dist(Times(CI,b,Plus(CI,c,d),Power(Times(f,Plus(m,C1)),-1)),Int(Times(Power(Plus(e,Times(f,x)),Plus(m,C1)),Exp(Plus(Times(C2,a),Times(C2,b,x))),Power(Plus(CI,c,Negate(d),Times(Plus(CI,c,d),Exp(Plus(Times(C2,a),Times(C2,b,x))))),-1)),x),x)),And(FreeQ(List(a,b,c,d,e,f),x),IGtQ(m,C0),NeQ(Sqr(Plus(c,Negate(d))),CN1))))
  );
}
