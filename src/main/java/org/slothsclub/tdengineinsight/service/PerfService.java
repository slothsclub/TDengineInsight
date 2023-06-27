package org.slothsclub.tdengineinsight.service;

import org.slothsclub.tdengineinsight.TdengineService;
import org.slothsclub.tdengineinsight.bind.Perf;
import org.slothsclub.tdengineinsight.mapper.PerfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfService extends TdengineService {
    @Autowired
    PerfMapper perfMapper;

    public List<Perf> query(String perfTableName) {
        return perfMapper.query(perfTableName);
    }
}
