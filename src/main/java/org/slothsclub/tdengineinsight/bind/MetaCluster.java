package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaCluster extends Meta{
    long id;
    String name;
    int uptime;
    Timestamp createTime;
    String version;
    Timestamp expireTime;
}
