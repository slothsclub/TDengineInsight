package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaDnodeVariable extends Meta {
    int dnodeId;
    String name;
    String value;
}
