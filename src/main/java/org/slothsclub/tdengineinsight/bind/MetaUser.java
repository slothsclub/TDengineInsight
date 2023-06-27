package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaUser extends Meta {
    String name;
    int enable;
    int sysinfo;
    Timestamp createTime;
    int isSuper;
}
