/**
 * Copyright (c) 2023 Obeo.
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
package org.eclipse.sirius.components.view.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.sirius.components.view.diagram.DiagramPackage;
import org.eclipse.sirius.components.view.diagram.EdgeReconnectionTool;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Edge Reconnection Tool</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public abstract class EdgeReconnectionToolImpl extends ToolImpl implements EdgeReconnectionTool {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EdgeReconnectionToolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DiagramPackage.Literals.EDGE_RECONNECTION_TOOL;
    }

} // EdgeReconnectionToolImpl
