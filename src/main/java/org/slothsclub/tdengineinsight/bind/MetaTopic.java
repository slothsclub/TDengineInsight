package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaTopic {
    String topicName;
    String dbName;
    Timestamp createTime;
    String sql;
}
