package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfConnection extends Perf {
    long connId;
    String user;
    String app;
    int pid;
    String endPoint;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp loginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp lastAccess;
}
