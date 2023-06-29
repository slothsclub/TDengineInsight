package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaStable extends Meta {
    String stableName;
    String dbName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    int columns;
    int tags;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp lastUpdate;
    String tableComment;
    String watermark;
    String maxDelay;
    String rollup;
}
