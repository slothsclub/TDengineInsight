package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaIndex extends Meta {
    String dbName;
    String tableName;
    String indexName;
    String columnName;
    String indexType;
    String indexExtensions;
}
