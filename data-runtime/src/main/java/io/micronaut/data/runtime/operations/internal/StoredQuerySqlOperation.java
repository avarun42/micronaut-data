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
package io.micronaut.data.runtime.operations.internal;

import io.micronaut.core.annotation.Internal;
import io.micronaut.data.model.query.builder.sql.SqlQueryBuilder;
import io.micronaut.data.model.runtime.StoredQuery;

/**
 * Implementation of {@link StoredSqlOperation} that retrieves data from {@link StoredQuery}.
 */
@Internal
public class StoredQuerySqlOperation extends StoredSqlOperation {

    /**
     * Creates a new instance.
     *
     * @param queryBuilder The queryBuilder
     * @param storedQuery  The store query
     */
    public StoredQuerySqlOperation(SqlQueryBuilder queryBuilder, StoredQuery<?, ?> storedQuery) {
        super(queryBuilder,
                storedQuery.getQuery(),
                storedQuery.getExpandableQueryParts(),
                storedQuery.getQueryBindings(),
                storedQuery.isOptimisticLock());
    }

}
