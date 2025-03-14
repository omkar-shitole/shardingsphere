/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.mode.metadata.persist.metadata;

import lombok.Getter;
import org.apache.shardingsphere.mode.metadata.persist.metadata.service.DatabaseMetaDataPersistService;
import org.apache.shardingsphere.mode.metadata.persist.metadata.service.SchemaMetaDataPersistService;
import org.apache.shardingsphere.mode.metadata.persist.metadata.service.TableMetaDataPersistService;
import org.apache.shardingsphere.mode.metadata.persist.metadata.service.ViewMetaDataPersistService;
import org.apache.shardingsphere.mode.metadata.persist.version.VersionPersistService;
import org.apache.shardingsphere.mode.spi.repository.PersistRepository;

/**
 * Database meta data persist facade.
 */
@Getter
public final class DatabaseMetaDataPersistFacade {
    
    private final DatabaseMetaDataPersistService database;
    
    private final SchemaMetaDataPersistService schema;
    
    private final TableMetaDataPersistService table;
    
    private final ViewMetaDataPersistService view;
    
    public DatabaseMetaDataPersistFacade(final PersistRepository repository, final VersionPersistService versionPersistService) {
        database = new DatabaseMetaDataPersistService(repository);
        schema = new SchemaMetaDataPersistService(repository, versionPersistService);
        table = new TableMetaDataPersistService(repository, versionPersistService);
        view = new ViewMetaDataPersistService(repository, versionPersistService);
    }
}
