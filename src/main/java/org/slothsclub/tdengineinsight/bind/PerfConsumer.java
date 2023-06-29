package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp subscribeTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp rebalanceTime;
}
