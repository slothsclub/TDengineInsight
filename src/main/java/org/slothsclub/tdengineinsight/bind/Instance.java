package org.slothsclub.tdengineinsight.bind;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Instance {
    String id;
    String host;
    int port;
    String username;
    String password;
    boolean batchfetch;
    boolean batchErrorIgnore;
    int httpConnectTimeout;
    int httpSocketTimeout;
    int messageWaitTimeout;
}
