package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaStream extends Meta{
    String streamName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp CreateTime;
    String sql;
    String status;
    String sourceDb;
    String targetDb;
    String targetTable;
    String watermark;
    String trigger;
}
