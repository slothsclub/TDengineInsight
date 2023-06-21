package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class MetaIndex {
    String dbName;
    String tableName;
    String indexName;
    String columnName;
    String indexType;
    String indexExtensions;
}
