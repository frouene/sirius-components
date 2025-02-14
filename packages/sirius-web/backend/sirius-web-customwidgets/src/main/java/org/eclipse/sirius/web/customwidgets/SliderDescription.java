/*******************************************************************************
 * Copyright (c) 2023, 2023 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.customwidgets;

import org.eclipse.emf.common.util.EList;
import org.eclipse.sirius.components.view.Operation;
import org.eclipse.sirius.components.view.form.WidgetDescription;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Slider Description</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getMinValueExpression <em>Min Value
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getMaxValueExpression <em>Max Value
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getCurrentValueExpression <em>Current Value
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription()
 * @model
 * @generated
 */
public interface SliderDescription extends WidgetDescription {

    /**
     * Returns the value of the '<em><b>Min Value Expression</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Min Value Expression</em>' attribute.
     * @see #setMinValueExpression(String)
     * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription_MinValueExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression" required="true"
     * @generated
     */
    String getMinValueExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getMinValueExpression
     * <em>Min Value Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Min Value Expression</em>' attribute.
     * @see #getMinValueExpression()
     * @generated
     */
    void setMinValueExpression(String value);

    /**
     * Returns the value of the '<em><b>Max Value Expression</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Max Value Expression</em>' attribute.
     * @see #setMaxValueExpression(String)
     * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription_MaxValueExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression" required="true"
     * @generated
     */
    String getMaxValueExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getMaxValueExpression
     * <em>Max Value Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Max Value Expression</em>' attribute.
     * @see #getMaxValueExpression()
     * @generated
     */
    void setMaxValueExpression(String value);

    /**
     * Returns the value of the '<em><b>Current Value Expression</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Current Value Expression</em>' attribute.
     * @see #setCurrentValueExpression(String)
     * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription_CurrentValueExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression" required="true"
     * @generated
     */
    String getCurrentValueExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getCurrentValueExpression
     * <em>Current Value Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Current Value Expression</em>' attribute.
     * @see #getCurrentValueExpression()
     * @generated
     */
    void setCurrentValueExpression(String value);

    /**
     * Returns the value of the '<em><b>Body</b></em>' containment reference list. The list contents are of type
     * {@link org.eclipse.sirius.components.view.Operation}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Body</em>' containment reference list.
     * @model containment="true"
     * @generated
     * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription_Body()
     */
    EList<Operation> getBody();

    /**
     * Returns the value of the '<em><b>Is Enabled Expression</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Is Enabled Expression</em>' attribute.
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression"
     * @generated
     * @see #setIsEnabledExpression(String)
     * @see org.eclipse.sirius.web.customwidgets.CustomwidgetsPackage#getSliderDescription_IsEnabledExpression()
     */
    String getIsEnabledExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.web.customwidgets.SliderDescription#getIsEnabledExpression
     * <em>Is Enabled Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value the new value of the '<em>Is Enabled Expression</em>' attribute.
     * @generated
     * @see #getIsEnabledExpression()
     */
    void setIsEnabledExpression(String value);

} // SliderDescription
