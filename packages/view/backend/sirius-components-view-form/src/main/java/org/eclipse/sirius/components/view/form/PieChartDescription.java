/**
 * Copyright (c) 2021, 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *      Obeo - initial API and implementation
 */
package org.eclipse.sirius.components.view.form;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pie Chart Description</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.form.PieChartDescription#getValuesExpression <em>Values
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.PieChartDescription#getKeysExpression <em>Keys
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.PieChartDescription#getStyle <em>Style</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.PieChartDescription#getConditionalStyles <em>Conditional
 * Styles</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.form.FormPackage#getPieChartDescription()
 * @model
 * @generated
 */
public interface PieChartDescription extends WidgetDescription {
    /**
     * Returns the value of the '<em><b>Values Expression</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Values Expression</em>' attribute.
     * @see #setValuesExpression(String)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getPieChartDescription_ValuesExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression"
     * @generated
     */
    String getValuesExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.PieChartDescription#getValuesExpression
     * <em>Values Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Values Expression</em>' attribute.
     * @see #getValuesExpression()
     * @generated
     */
    void setValuesExpression(String value);

    /**
     * Returns the value of the '<em><b>Keys Expression</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Keys Expression</em>' attribute.
     * @see #setKeysExpression(String)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getPieChartDescription_KeysExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression"
     * @generated
     */
    String getKeysExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.PieChartDescription#getKeysExpression
     * <em>Keys Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Keys Expression</em>' attribute.
     * @see #getKeysExpression()
     * @generated
     */
    void setKeysExpression(String value);

    /**
     * Returns the value of the '<em><b>Style</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Style</em>' containment reference.
     * @see #setStyle(PieChartDescriptionStyle)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getPieChartDescription_Style()
     * @model containment="true"
     * @generated
     */
    PieChartDescriptionStyle getStyle();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.PieChartDescription#getStyle
     * <em>Style</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Style</em>' containment reference.
     * @see #getStyle()
     * @generated
     */
    void setStyle(PieChartDescriptionStyle value);

    /**
     * Returns the value of the '<em><b>Conditional Styles</b></em>' containment reference list. The list contents are
     * of type {@link org.eclipse.sirius.components.view.form.ConditionalPieChartDescriptionStyle}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Conditional Styles</em>' containment reference list.
     * @see org.eclipse.sirius.components.view.form.FormPackage#getPieChartDescription_ConditionalStyles()
     * @model containment="true"
     * @generated
     */
    EList<ConditionalPieChartDescriptionStyle> getConditionalStyles();

} // PieChartDescription
