package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaDNode {
    int vnodes;
    int supportVnodes;
    String status;
    String note;
    long id;
    String endpoint;
    Timestamp createTime;
    Timestamp rebootTime;
}
