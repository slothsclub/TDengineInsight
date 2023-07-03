package org.slothsclub.tdengineinsight.bind;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RawSqlRequest {
    @NotBlank
    String rawSql;

    String countSql;
}
