package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaQNode extends Meta {
    long id;
    String endpoint;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
}
