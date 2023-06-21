package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class MetaColumn {
    String tableName;
    String dbName;
    String tableType;
    String colName;
    String colType;
    int colLength;
    int colPrecision;
    int colScale;
    int colNullable;
}
