package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaTag extends Meta {
    String tableName;
    String dbName;
    String stableName;
    String tagName;
    String tagType;
    String tagValue;
}
