/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.runtime.criteria;

import io.micronaut.data.model.PersistentEntity;
import io.micronaut.data.model.jpa.criteria.impl.AbstractPersistentEntityCriteriaQuery;
import io.micronaut.data.model.jpa.criteria.PersistentEntityRoot;
import io.micronaut.data.model.runtime.RuntimeEntityRegistry;
import io.micronaut.data.model.runtime.RuntimePersistentEntity;

final class RuntimePersistentEntityCriteriaQuery<T> extends AbstractPersistentEntityCriteriaQuery<T> {

    private final RuntimeEntityRegistry runtimeEntityRegistry;

    public RuntimePersistentEntityCriteriaQuery(RuntimeEntityRegistry runtimeEntityRegistry) {
        this.runtimeEntityRegistry = runtimeEntityRegistry;
    }

    @Override
    public <X> PersistentEntityRoot<X> from(Class<X> entityClass) {
        return from(runtimeEntityRegistry.getEntity(entityClass));
    }

    public <X> PersistentEntityRoot<X> from(PersistentEntity persistentEntity) {
        if (entityRoot != null) {
            throw new IllegalStateException("The root entity is already specified!");
        }
        RuntimePersistentEntityRoot<X> newEntityRoot = new RuntimePersistentEntityRoot<X>((RuntimePersistentEntity<X>) persistentEntity);
        entityRoot = newEntityRoot;
        return newEntityRoot;
    }
}
