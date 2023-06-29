package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfTran extends Perf {
    int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    String stage;
    String db1;
    String db2;
    int failedTimes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp lastExecTime;
    String lastActionInfo;
}
