package org.slothsclub.tdengineinsight.bind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    String code;
    String message;

    Object payload;
}
