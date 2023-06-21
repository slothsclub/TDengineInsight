package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaMNode {
    long id;
    String endpoint;
    String role;
    Timestamp createTime;
    Timestamp rebootTime;
    String status;
}
