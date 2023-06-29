package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaDNode extends Meta {
    int vnodes;
    int supportVnodes;
    String status;
    String note;
    long id;
    String endpoint;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp rebootTime;
}
