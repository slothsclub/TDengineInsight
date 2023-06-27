package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaTable extends Meta {
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
