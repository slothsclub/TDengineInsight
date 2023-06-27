package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaStable extends Meta {
    String stableName;
    String dbName;
    Timestamp createTime;
    int columns;
    int tags;
    Timestamp lastUpdate;
    String tableComment;
    String watermark;
    String maxDelay;
    String rollup;
}
