package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp lastAccess;
}
