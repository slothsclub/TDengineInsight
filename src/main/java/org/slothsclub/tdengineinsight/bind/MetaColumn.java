package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaColumn extends Meta{
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
