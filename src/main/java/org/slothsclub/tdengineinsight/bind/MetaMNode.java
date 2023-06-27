package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaMNode extends Meta {
    long id;
    String endpoint;
    String role;
    Timestamp createTime;
    Timestamp rebootTime;
    String status;
}
