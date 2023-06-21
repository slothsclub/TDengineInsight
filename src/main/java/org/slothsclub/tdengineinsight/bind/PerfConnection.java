package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfConnection {
    int connId;
    String user;
    String app;
    int pid;
    String endPoint;
    Timestamp loginTime;
    Timestamp lastAccess;
}
