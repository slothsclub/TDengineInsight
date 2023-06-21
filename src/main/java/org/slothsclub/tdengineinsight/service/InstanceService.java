package org.slothsclub.tdengineinsight.service;

import org.slothsclub.tdengineinsight.SqliteService;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.slothsclub.tdengineinsight.mapper.InstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstanceService extends SqliteService {

    @Autowired
    InstanceMapper instanceMapper;

    public boolean insert(Instance model) {
        return instanceMapper.insert(model) > 0;
    }

    public List<Instance> selectAll() {
        return instanceMapper.selectAll();
    }
}
