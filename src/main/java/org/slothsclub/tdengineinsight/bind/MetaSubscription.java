package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaSubscription extends Meta {
    String topicName;
    String consumerGroup;
    int vgroupId;
    String consumerId;
    String offset;
    long rows;
}
