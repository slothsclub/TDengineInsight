package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfQuery {
    long killId;
    int queryId;
    int connId;
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
