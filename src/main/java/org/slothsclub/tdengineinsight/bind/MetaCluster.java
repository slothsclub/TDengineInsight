package org.slothsclub.tdengineinsight.bind;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaCluster extends Meta{
    long id;
    String name;
    int uptime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createTime;
    String version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp expireTime;
}
