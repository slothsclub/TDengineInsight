package org.slothsclub.tdengineinsight.bind;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MetaFunction {
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
