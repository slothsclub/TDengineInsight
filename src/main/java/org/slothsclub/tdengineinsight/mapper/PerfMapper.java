package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.slothsclub.tdengineinsight.bind.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PerfMapper {

    @Select("SELECT '${perfTableName}' as t, * FROM performance_schema.${perfTableName}")
    @TypeDiscriminator(javaType = String.class, column = "t", cases = {
            @Case(value = "PERF_APPS", type = PerfClient.class),
            @Case(value = "PERF_CONNECTIONS", type = PerfConnection.class),
            @Case(value = "PERF_CONSUMERS", type = PerfConsumer.class),
            @Case(value = "PERF_QUERIES", type = PerfQuery.class),
            @Case(value = "PERF_SMAS", type = PerfSma.class),
            @Case(value = "PERF_TRANS", type = PerfTran.class),
    })
    List<Perf> query(String perfTableName);
}
