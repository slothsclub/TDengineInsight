package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ExecSqlMapper {
    static class PureSqlProvider {
        public String sql(String sql) {
            return sql;
        }
    }

    @SelectProvider(type = PureSqlProvider.class, method = "sql")
    public List<Map<Object, Object>> execRawSql(String sql);

    @SelectProvider(type = PureSqlProvider.class, method = "sql")
    public Integer count(String sql);
}
