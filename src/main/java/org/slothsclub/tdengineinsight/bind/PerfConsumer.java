package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PerfConsumer {
    long consumerId;
    String consumerGroup;
    String clientId;
    String status;
    String topics;
    Timestamp upTime;
    Timestamp subscribeTime;
    Timestamp rebalanceTime;
}
