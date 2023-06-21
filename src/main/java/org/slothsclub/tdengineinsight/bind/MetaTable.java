package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaTable {
    String tableName;
    String dbName;
    Timestamp createTime;
    int columns;
    String stableName;
    long uid;
    int vgroupId;
    int ttl;
    String tableComment;
    String type;
}
