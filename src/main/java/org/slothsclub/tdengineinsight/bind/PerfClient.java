package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfClient {
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
