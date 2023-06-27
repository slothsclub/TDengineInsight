package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfTran extends Perf {
    int id;
    Timestamp createTime;
    String stage;
    String db1;
    String db2;
    int failedTimes;
    Timestamp lastExecTime;
    String lastActionInfo;
}
