package org.slothsclub.tdengineinsight.bind;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class Instance {
    @Hidden
    String id;
    @NotBlank
    String name;
    @NotBlank
    @Schema(defaultValue = "localhost")
    String host;
    @PositiveOrZero
    @Schema(defaultValue = "6041")
    int port;
    @NotBlank
    @Schema(defaultValue = "root")
    String username;
    @NotBlank
    @Schema(defaultValue = "taosdata")
    String password;
    @Schema(defaultValue = "false", description = "")
    boolean batchfetch;
    @Schema(defaultValue = "false", description = "")
    boolean batchErrorIgnore;
    @PositiveOrZero
    @Schema(defaultValue = "5000", description = "")
    int httpConnectTimeout;
    @PositiveOrZero
    @Schema(defaultValue = "5000", description = "")
    int httpSocketTimeout;
    @PositiveOrZero
    @Schema(defaultValue = "3000", description = "")
    int messageWaitTimeout;
}
