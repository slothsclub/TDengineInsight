package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfConnection extends Perf {
    int connId;
    String user;
    String app;
    int pid;
    String endPoint;
    Timestamp loginTime;
    Timestamp lastAccess;
}
