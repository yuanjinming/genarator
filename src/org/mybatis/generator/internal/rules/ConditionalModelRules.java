/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.internal.rules;

import org.mybatis.generator.api.IntrospectedTable;

/**
 * This class encapsulates all the code generation rules for a table using the
 * conditional model. In this model we do not generate primary key or record
 * with BLOBs classes if the class would only hold one field.
 * 
 * @author Jeff Butler
 * 
 */
public class ConditionalModelRules extends BaseRules {

    /**
     * Instantiates a new conditional model rules.
     *
     * @param introspectedTable
     *            the introspected table
     */
    public ConditionalModelRules(IntrospectedTable introspectedTable) {
        super(introspectedTable);
    }

    /**
     * We generate a primary key if there is more than one primary key field.
     * 
     * @return true if the primary key should be generated
     */
    public boolean generatePrimaryKeyClass() {
        return false;
    }

    /**
     * Generate a base record if there are any base columns, or if there is only
     * one primary key coulmn (in which case we will not generate a primary key
     * class), or if there is only one BLOB column (in which case we will not
     * generate a record with BLOBs class).
     * 
     * @return true if the class should be generated
     */
    public boolean generateBaseRecordClass() {
        return introspectedTable.hasBaseColumns();
    }
}
