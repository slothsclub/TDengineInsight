package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

@Data
public class MetaTag {
    String tableName;
    String dbName;
    String stableName;
    String tagName;
    String tagType;
    String tagValue;
}
