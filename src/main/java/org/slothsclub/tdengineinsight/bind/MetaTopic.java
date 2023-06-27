package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaTopic extends Meta {
    String topicName;
    String dbName;
    Timestamp createTime;
    String sql;
}
