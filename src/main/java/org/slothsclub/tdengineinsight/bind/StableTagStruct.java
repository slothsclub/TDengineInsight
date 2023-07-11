package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StableTagStruct extends Meta {
    @JsonProperty("tagName")
    String field;
    @JsonProperty("tagType")
    String type;
    @JsonProperty("tagLength")
    int length;
    @JsonIgnore
    String note;
    String tagValue;
}
