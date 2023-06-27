package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaDNode extends Meta {
    int vnodes;
    int supportVnodes;
    String status;
    String note;
    long id;
    String endpoint;
    Timestamp createTime;
    Timestamp rebootTime;
}
