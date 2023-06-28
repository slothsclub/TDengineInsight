package org.slothsclub.tdengineinsight.bind;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrors {
    String field;
    String message;

    @Override
    public String toString() {
        return field + " " + message;
    }
}
