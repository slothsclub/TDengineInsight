package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfSma {
    String smaName;
    Timestamp createTime;
    String stableName;
    int vgroupId;
}
