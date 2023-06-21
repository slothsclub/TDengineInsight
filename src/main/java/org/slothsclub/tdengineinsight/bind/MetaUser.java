package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaUser {
    String name;
    int enable;
    int sysinfo;
    Timestamp createTime;
    int isSuper;
}
