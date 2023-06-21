package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaStable {
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
