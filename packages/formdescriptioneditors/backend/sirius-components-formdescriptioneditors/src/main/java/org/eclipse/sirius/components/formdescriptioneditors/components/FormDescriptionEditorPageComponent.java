/*******************************************************************************
 * Copyright (c) 2022, 2023 Obeo.
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
package org.eclipse.sirius.components.formdescriptioneditors.components;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.components.forms.components.ToolbarActionComponent;
import org.eclipse.sirius.components.forms.components.ToolbarActionComponentProps;
import org.eclipse.sirius.components.forms.description.AbstractWidgetDescription;
import org.eclipse.sirius.components.forms.description.ButtonDescription;
import org.eclipse.sirius.components.forms.elements.PageElementProps;
import org.eclipse.sirius.components.representations.Element;
import org.eclipse.sirius.components.representations.IComponent;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.view.PageDescription;

/**
 * The component used to render the form description editor page.
 *
 * @author arichard
 */
public class FormDescriptionEditorPageComponent implements IComponent {

    private static final String AQL_PREFIX = "aql:";

    private final FormDescriptionEditorPageComponentProps props;

    private final ViewFormDescriptionEditorConverterSwitch converter;

    public FormDescriptionEditorPageComponent(FormDescriptionEditorPageComponentProps props) {
        this.props = props;
        this.converter = new ViewFormDescriptionEditorConverterSwitch(props.formDescriptionEditorDescription(), props.variableManager());
    }

    @Override
    public Element render() {
        VariableManager variableManager = this.props.variableManager();
        var pageDescription = variableManager.get(VariableManager.SELF, PageDescription.class).get();
        String id = this.props.formDescriptionEditorDescription().getTargetObjectIdProvider().apply(variableManager);
        String label = this.getPageLabel(pageDescription, "Page");
        List<Element> childrenWidgets = new ArrayList<>();

        pageDescription.getToolbarActions().forEach(viewToolbarActionDescription -> {
            VariableManager childVariableManager = variableManager.createChild();
            childVariableManager.put(VariableManager.SELF, viewToolbarActionDescription);
            AbstractWidgetDescription toolbarActionDescription = this.converter.doSwitch(viewToolbarActionDescription);
            if (toolbarActionDescription instanceof ButtonDescription) {
                ToolbarActionComponentProps toolbarActionComponentProps = new ToolbarActionComponentProps(childVariableManager, (ButtonDescription) toolbarActionDescription);
                childrenWidgets.add(new Element(ToolbarActionComponent.class, toolbarActionComponentProps));
            }
        });

        pageDescription.getGroups().forEach(viewGroupDescription -> {
            VariableManager childVariableManager = variableManager.createChild();
            childVariableManager.put(VariableManager.SELF, viewGroupDescription);
            FormDescriptionEditorGroupComponentProps fdeGroupComponentProps = new FormDescriptionEditorGroupComponentProps(childVariableManager, this.props.formDescriptionEditorDescription());
            childrenWidgets.add(new Element(FormDescriptionEditorGroupComponent.class, fdeGroupComponentProps));
        });

        PageElementProps pageElementProps = PageElementProps.newPageElementProps(id)
                .label(label)
                .children(childrenWidgets)
                .build();

        return new Element(PageElementProps.TYPE, pageElementProps);
    }


    public String getPageLabel(PageDescription pageDescription, String defaultLabel) {
        String widgetLabel = defaultLabel;
        String name = pageDescription.getName();
        String labelExpression = pageDescription.getLabelExpression();
        if (labelExpression != null && !labelExpression.isBlank() && !labelExpression.startsWith(AQL_PREFIX)) {
            widgetLabel = labelExpression;
        } else if (name != null && !name.isBlank()) {
            widgetLabel = name;
        }
        return widgetLabel;
    }

}
