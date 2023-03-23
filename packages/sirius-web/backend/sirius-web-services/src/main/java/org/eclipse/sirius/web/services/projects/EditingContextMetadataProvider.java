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
package org.eclipse.sirius.web.services.projects;

import org.eclipse.sirius.web.persistence.entities.ProjectNatureEntity;
import org.eclipse.sirius.web.persistence.repositories.IProjectNatureRepository;
import org.eclipse.sirius.web.services.api.projects.Nature;
import org.eclipse.sirius.web.services.projects.api.EditingContextMetadata;
import org.eclipse.sirius.web.services.projects.api.IEditingContextMetadataProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Provides the metadata of a editingContext.
 *
 * @author frouene
 */
@Service
public class EditingContextMetadataProvider implements IEditingContextMetadataProvider {

    private final IProjectNatureRepository projectNatureRepository;

    public EditingContextMetadataProvider(IProjectNatureRepository projectNatureRepository) {

        this.projectNatureRepository = Objects.requireNonNull(projectNatureRepository);
    }

    @Override
    public EditingContextMetadata getMetadata(String editingContextId) {
        return new EditingContextMetadata(this.projectNatureRepository.findAllByProjectId(UUID.fromString(editingContextId)).stream().map(ProjectNatureEntity::getName).map(Nature::new).toList());
    }
}
