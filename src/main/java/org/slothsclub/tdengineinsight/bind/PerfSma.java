package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfSma extends Perf {
    String smaName;
    Timestamp createTime;
    String stableName;
    int vgroupId;
}
