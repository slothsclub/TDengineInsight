package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface InitMapper {

    @Update("CREATE TABLE IF NOT EXISTS instances (id NCHAR PRIMARY KEY, host VARCHAR, port INT, username VARCHAR, password VARCHAR, batchfetch INT, batchErrorIgnore INT, httpConnectTimeout INT, httpSocketTimeout INT, messageWaitTimeout INT)")
    void createInstancesTableIfMissing();

    @Update("CREATE TABLE IF NOT EXISTS settings (`key` STRING PRIMARY KEY, `value` TEXT)")
    void createSettingTableIfMission();
}
