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
package org.eclipse.sirius.web.services.editingcontext;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.emf.services.IEditingContextEPackageService;
import org.eclipse.sirius.web.services.api.projects.Nature;
import org.eclipse.sirius.web.services.projects.api.EditingContextMetadata;
import org.eclipse.sirius.web.services.projects.api.IEditingContextMetadataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Unit tests of the editing context factory service.
 *
 * @author frouene
 */
public class EditingDomainFactoryServiceTest {

    public static final String EPACKAGE_NS_URI_VIEW = "viewURI";

    public static final String EPACKAGE_NS_URI_DOMAIN = "domainURI";

    public static final String EPACKAGE_NS_URI_FLOW = "flowURI";

    @Test
    public void testCreateEditingDomainWithoutStudioNature() {
        ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory();
        EPackage.Registry ePackageRegistry = generateGlobalEPackages();

        String projectId = UUID.randomUUID().toString();

        IEditingContextEPackageService editingContextEPackageService = generateAdditionalEPackages();

        var editingContextMetadata = new EditingContextMetadata(List.of());
        IEditingContextMetadataProvider editingContextMetadataProvider = editingContextId -> editingContextMetadata;

        EditingDomainFactoryService editingDomainFactoryService = new EditingDomainFactoryService(editingContextEPackageService, editingContextMetadataProvider, composedAdapterFactory,
                ePackageRegistry, Optional.empty());

        AdapterFactoryEditingDomain adapterFactoryEditingDomain = editingDomainFactoryService.createEditingDomain(projectId);

        assertThat(adapterFactoryEditingDomain).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry()).hasSize(4);
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EcorePackage.eNS_URI)).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_VIEW)).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_DOMAIN)).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_FLOW)).isNotNull();
    }

    @Test
    public void testCreateEditingDomainWithStudioNature() {
        ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory();
        EPackage.Registry ePackageRegistry = generateGlobalEPackages();

        String projectId = UUID.randomUUID().toString();

        IEditingContextEPackageService editingContextEPackageService = generateAdditionalEPackages();

        var editingContextMetadata = new EditingContextMetadata(List.of(new Nature("siriusComponents://nature?kind=studio")));
        IEditingContextMetadataProvider editingContextMetadataProvider = editingContextId -> editingContextMetadata;

        EditingDomainFactoryService editingDomainFactoryService = new EditingDomainFactoryService(editingContextEPackageService, editingContextMetadataProvider, composedAdapterFactory,
                ePackageRegistry, Optional.empty());

        AdapterFactoryEditingDomain adapterFactoryEditingDomain = editingDomainFactoryService.createEditingDomain(projectId);

        assertThat(adapterFactoryEditingDomain).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry()).hasSize(2);
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EcorePackage.eNS_URI)).isNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_VIEW)).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_DOMAIN)).isNotNull();
        assertThat(adapterFactoryEditingDomain.getResourceSet().getPackageRegistry().getEPackage(EPACKAGE_NS_URI_FLOW)).isNull();
    }

    private static EPackage.Registry generateGlobalEPackages() {
        EPackage.Registry ePackageRegistry = new EPackageRegistryImpl();
        ePackageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
        var globalPackageView = EcoreFactory.eINSTANCE.createEPackage();
        globalPackageView.setName("view");
        globalPackageView.setNsURI(EPACKAGE_NS_URI_VIEW);
        ePackageRegistry.put(EPACKAGE_NS_URI_VIEW, globalPackageView);
        return ePackageRegistry;
    }

    private static IEditingContextEPackageService generateAdditionalEPackages() {
        var additionalPackageDomain = EcoreFactory.eINSTANCE.createEPackage();
        additionalPackageDomain.setName("domain");
        additionalPackageDomain.setNsURI(EPACKAGE_NS_URI_DOMAIN);
        var additionalPackageFlow = EcoreFactory.eINSTANCE.createEPackage();
        additionalPackageFlow.setName("flow");
        additionalPackageFlow.setNsURI(EPACKAGE_NS_URI_FLOW);
        return editingContextId -> List.of(additionalPackageDomain, additionalPackageFlow);
    }
}
