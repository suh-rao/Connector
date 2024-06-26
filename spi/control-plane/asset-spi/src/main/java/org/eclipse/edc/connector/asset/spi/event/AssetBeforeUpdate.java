/*
 *  Copyright (c) 2022 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Bayerische Motoren Werke Aktiengesellschaft (BMW AG) - initial API and implementation
 *       Fraunhofer Institute for Software and Systems Engineering - expending Event classes
 *
 */

package org.eclipse.edc.connector.asset.spi.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Describe a new Asset creation, after this has emitted, an Asset with a certain id will be available.
 */
@JsonDeserialize(builder = AssetBeforeUpdate.Builder.class)
public class AssetBeforeUpdate extends AssetEvent {

    private AssetBeforeUpdate() {
    }

    @Override
    public String name() {
        return "asset.before.update";
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends AssetEvent.Builder<AssetBeforeUpdate, Builder> {

        private Builder() {
            super(new AssetBeforeUpdate());
        }

        @JsonCreator
        public static Builder newInstance() {
            return new Builder();
        }

        @Override
        public Builder self() {
            return this;
        }
    }

}
