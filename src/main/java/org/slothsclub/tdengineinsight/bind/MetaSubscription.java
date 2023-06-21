package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class MetaSubscription {
    String topicName;
    String consumerGroup;
    int vgroupId;
    long consumerId;
}
