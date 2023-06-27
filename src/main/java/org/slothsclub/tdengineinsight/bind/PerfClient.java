package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfClient extends Perf {
    long appId;
    String ip;
    int pid;
    String name;
    Timestamp startTime;
    long insertReq;
    long insertRow;
    long insertTime;
    long insertBytes;
    long fetchBytes;
    long queryTime;
    long slowQuery;
    long totalReq;
    long currentReq;
    Timestamp lastAccess;
}
