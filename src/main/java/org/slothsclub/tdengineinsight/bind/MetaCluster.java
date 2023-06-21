package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaCluster {
    long id;
    String name;
    int uptime;
    Timestamp createTime;
    String version;
    Timestamp expireTime;
}
