package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfQuery extends Perf {
    String killId;
    String queryId;
    long connId;
    String app;
    int pid;
    String user;
    String endPoint;
    Timestamp createTime;
    long execUsec;
    boolean stableQuery;
    int subNum;
    String subStatus;
    String sql;
}
