package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaTopic extends Meta {
    String topicName;
    String dbName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    String sql;
}
