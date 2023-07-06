package org.slothsclub.tdengineinsight.service;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.TdengineService;
import org.slothsclub.tdengineinsight.mapper.ExecSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ExecSqlService extends TdengineService {
    @Autowired
    ExecSqlMapper execSqlMapper;

    public List<Map<Object, Object>> exec(String sql) {
        return execSqlMapper.execRawSql(sql);
    }

    public int count(String sql) {
        if (sql == null || sql.isEmpty()) return 0;
        return execSqlMapper.count(sql);
    }
}
