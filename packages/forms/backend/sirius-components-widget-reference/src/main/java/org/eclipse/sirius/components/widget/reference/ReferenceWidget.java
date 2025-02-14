/*******************************************************************************
 * Copyright (c) 2023 Obeo.
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
package org.eclipse.sirius.components.widget.reference;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.sirius.components.annotations.Immutable;
import org.eclipse.sirius.components.forms.AbstractWidget;
import org.eclipse.sirius.components.forms.validation.Diagnostic;

/**
 * A widget to view/edit an EMF reference.
 *
 * @author pcdavid
 */
@Immutable
public final class ReferenceWidget extends AbstractWidget {
    private List<ReferenceValue> referenceValues;

    private boolean container;

    private boolean manyValued;

    private Setting setting;

    private ReferenceWidget() {
        // Prevent instantiation
    }

    public List<ReferenceValue> getReferenceValues() {
        return this.referenceValues;
    }

    public boolean isContainer() {
        return this.container;
    }

    public boolean isManyValued() {
        return this.manyValued;
    }

    public Setting getSetting() {
        return this.setting;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}'}'";
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.id);
    }

    public static Builder newMultiValuedReferenceWidget(String id) {
        return new Builder(id);
    }

    /**
     * Builder used to create the MultiValuedReferenceWidget.
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class Builder {

        private String id;

        private String label;

        private String iconURL;

        private List<Diagnostic> diagnostics;

        private Supplier<String> helpTextProvider;

        private boolean readOnly;

        private List<ReferenceValue> referenceValues;

        private boolean container;

        private boolean manyValued;

        private Setting setting;

        public Builder(String id) {
            this.id = Objects.requireNonNull(id);
        }

        public Builder label(String label) {
            this.label = Objects.requireNonNull(label);
            return this;
        }

        public Builder iconURL(String iconURL) {
            this.iconURL = Objects.requireNonNull(iconURL);
            return this;
        }

        public Builder helpTextProvider(Supplier<String> helpTextProvider) {
            this.helpTextProvider = Objects.requireNonNull(helpTextProvider);
            return this;
        }

        public Builder readOnly(boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public Builder diagnostics(List<Diagnostic> diagnostics) {
            this.diagnostics = Objects.requireNonNull(diagnostics);
            return this;
        }

        public Builder referenceValues(List<ReferenceValue> values) {
            this.referenceValues = Objects.requireNonNull(values);
            return this;
        }

        public Builder container(boolean containment) {
            this.container = Objects.requireNonNull(containment);
            return this;
        }

        public Builder manyValued(boolean manyValued) {
            this.manyValued = manyValued;
            return this;
        }

        public Builder setting(Setting setting) {
            this.setting = Objects.requireNonNull(setting);
            return this;
        }

        public ReferenceWidget build() {
            ReferenceWidget referenceWidget = new ReferenceWidget();
            referenceWidget.id = Objects.requireNonNull(this.id);
            referenceWidget.label = Objects.requireNonNull(this.label);
            referenceWidget.iconURL = this.iconURL;
            referenceWidget.diagnostics = Objects.requireNonNull(this.diagnostics);
            referenceWidget.container = this.container;
            referenceWidget.manyValued = this.manyValued;
            referenceWidget.referenceValues = Objects.requireNonNull(this.referenceValues);
            referenceWidget.setting = Objects.requireNonNull(this.setting);
            referenceWidget.helpTextProvider = this.helpTextProvider; // Optional on purpose
            referenceWidget.readOnly = this.readOnly;
            return referenceWidget;
        }
    }

}
