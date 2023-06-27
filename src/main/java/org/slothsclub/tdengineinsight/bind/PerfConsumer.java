package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class PerfConsumer extends Perf {
    long consumerId;
    String consumerGroup;
    String clientId;
    String status;
    String topics;
    Timestamp upTime;
    Timestamp subscribeTime;
    Timestamp rebalanceTime;
}
