package org.slothsclub.tdengineinsight.service;

import org.slothsclub.tdengineinsight.mapper.InitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    @Autowired
    InitMapper initMapper;

    public void init() {
        initMapper.createInstancesTableIfMissing();
        initMapper.createSettingTableIfMission();
    }
}
