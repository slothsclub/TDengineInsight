package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InstanceMapper {
    @Insert("INSERT INTO instances(id, host, port, username, password) VALUES(#{id}, #{host}, #{port}, #{username}, #{password})")
    int insert(Instance model);

    @Select("SELECT * FROM instances")
    List<Instance> selectAll();
}
