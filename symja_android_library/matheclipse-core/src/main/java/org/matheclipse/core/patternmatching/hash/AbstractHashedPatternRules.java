package org.matheclipse.core.patternmatching.hash;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.patternmatching.RulesData;
import org.matheclipse.core.visit.HashValueVisitor;

public abstract class AbstractHashedPatternRules {

  protected int hash1;
  protected int hash2;
  protected int hashSum;
  protected RulesData fRulesData = null;
  protected final IExpr fLHSPattern1;
  protected final IExpr fLHSPattern2;

  /**
   * @param lhsPattern1 first left-hand-side pattern
   * @param lhsPattern2 second left-hand-side pattern
   * @param defaultHashCode if <code>false</code> use a <code>HashValueVisitor()</code> to determine
   *     the tw0 hash values for the lhs... arguments. if <code>true</code> use the default <code>
   *     Object.hashCode()</code> method.
   */
  public AbstractHashedPatternRules(IExpr lhsPattern1, IExpr lhsPattern2, boolean defaultHashCode) {
    fLHSPattern1 = lhsPattern1;
    fLHSPattern2 = lhsPattern2;
    hashValues(lhsPattern1, lhsPattern2, defaultHashCode);
  }

  /**
   * Calculate two hash values <code>hash1</code> for <code>lhsPattern1</code> and <code>hash2
   * </code>for <code>lhsPattern2</code>
   *
   * @param lhsPattern1
   * @param lhsPattern2
   * @param defaultHashCode
   */
  public void hashValues(IExpr lhsPattern1, IExpr lhsPattern2, boolean defaultHashCode) {
    if (defaultHashCode) {
      hash1 = lhsPattern1.head().hashCode();
      hash2 = lhsPattern2.head().hashCode();
    } else {
      hash1 = lhsPattern1.accept(HashValueVisitor.HASH_VALUE_VISITOR);
      hash2 = lhsPattern2.accept(HashValueVisitor.HASH_VALUE_VISITOR);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof AbstractHashedPatternRules) {
      HashedPatternRules other = (HashedPatternRules) obj;
      if (hash1 != other.hash1) {
        return false;
      }
      if (hash2 != other.hash2) {
        return false;
      }
      if (fLHSPattern1 == null) {
        if (other.fLHSPattern1 != null) {
          return false;
        }
      } else if (!fLHSPattern1.equals(other.fLHSPattern1)) {
        return false;
      }
      if (fLHSPattern2 == null) {
        if (other.fLHSPattern2 != null) {
          return false;
        }
      } else if (!fLHSPattern2.equals(other.fLHSPattern2)) {
        return false;
      }
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (hashSum == 0) {
      hashSum = calculateHashcode(hash1, hash2);
    }
    return hashSum;
  }

  /**
   * Symmetric hash code.
   *
   * @param h1
   * @param h2
   * @return
   */
  public static int calculateHashcode(int h1, int h2) {
    return 31 * (h1 + h2);
  }

  /**
   * Get the hash value for the first LHS expression.
   *
   * @return the hash1
   */
  public int getHash1() {
    return hash1;
  }

  /**
   * Get the hash value for the second LHS expression.
   *
   * @return the hash2
   */
  public int getHash2() {
    return hash2;
  }

  /** Test if the first left-hand-side is a pattern object */
  public boolean isPattern1() {
    return fLHSPattern1.isPattern();
  }

  /** Test if the second left-hand-side is a pattern object */
  public boolean isPattern2() {
    return fLHSPattern2.isPattern();
  }

  /**
   * @param e1
   * @param num1
   * @param e2
   * @param num2
   * @param engine
   * @return
   */
  public abstract IExpr evalDownRule(IExpr e1, IExpr num1, IExpr e2, IExpr num2, EvalEngine engine);
}
