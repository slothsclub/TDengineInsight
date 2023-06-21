package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfTran {
    int id;
    Timestamp createTime;
    String stage;
    String db1;
    String db2;
    int failedTimes;
    Timestamp lastExecTime;
    String lastActionInfo;
}
