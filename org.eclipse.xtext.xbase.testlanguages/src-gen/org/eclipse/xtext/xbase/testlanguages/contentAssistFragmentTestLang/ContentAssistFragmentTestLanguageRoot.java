/**
 */
package org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Assist Fragment Test Language Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLangPackage#getContentAssistFragmentTestLanguageRoot()
 * @model
 * @generated
 */
public interface ContentAssistFragmentTestLanguageRoot extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLangPackage#getContentAssistFragmentTestLanguageRoot_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLanguageRoot#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // ContentAssistFragmentTestLanguageRoot