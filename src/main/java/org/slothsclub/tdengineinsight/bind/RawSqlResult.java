package org.slothsclub.tdengineinsight.bind;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class RawSqlResult {
    long count;
    List<Map<Object, Object>> data;
    long elapsedTime;
}
