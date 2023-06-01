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
package org.eclipse.sirius.components.core.api;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.sirius.components.representations.Message;

/**
 * General purpose success payload.
 *
 * @author mcharfadi
 */
public record SuccessPayload(UUID id, List<Message> messages) implements IPayload {

    public SuccessPayload {
        Objects.requireNonNull(id);
        Objects.requireNonNull(messages);
    }

    public SuccessPayload(UUID id) {
        this(id, List.of());
    }
}
