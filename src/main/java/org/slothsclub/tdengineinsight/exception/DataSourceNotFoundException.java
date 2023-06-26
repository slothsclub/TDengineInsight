package org.slothsclub.tdengineinsight.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataSourceNotFoundException extends RuntimeException {
    public DataSourceNotFoundException(String errMessage) {
        super(errMessage);
    }
}
