package org.slothsclub.tdengineinsight.bind;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class MetaFunction extends Meta {
    String name;
    String comment;
    int aggregate;
    String outputType;
    Timestamp createTime;
    int codeLen;
    int bufsize;
    String funcLanguage;
    String funcBody;
    int funcVersion;
}
