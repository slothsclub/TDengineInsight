package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaQNode {
    long id;
    String endpoint;
    Timestamp createTime;
}
