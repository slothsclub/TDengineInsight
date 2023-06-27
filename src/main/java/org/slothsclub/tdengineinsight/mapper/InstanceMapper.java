package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InstanceMapper {
    @Insert("INSERT INTO instances" +
            "(id, name, host, port, username, password, batchfetch, batchErrorIgnore, httpConnectTimeout, httpSocketTimeout, messageWaitTimeout) " +
            "VALUES(#{id}, #{name}, #{host}, #{port}, #{username}, #{password}, #{batchfetch}, #{batchErrorIgnore}, #{httpConnectTimeout}, #{httpSocketTimeout}, #{messageWaitTimeout})")
    int insert(Instance model);

    @Select("SELECT * FROM instances")
    List<Instance> selectAll();

    @Delete("DELETE FROM instances WHERE id=#{id}")
    int delete(String id);

    @Update("UPDATE instances SET " +
            "name=#{name}, " +
            "host=#{host}, " +
            "port=#{port}, " +
            "username=#{username}, " +
            "password=#{password}, " +
            "batchfetch=#{batchfetch}, " +
            "batchErrorIgnore=#{batchErrorIgnore}, " +
            "httpConnectTimeout=#{httpConnectTimeout}, " +
            "httpSocketTimeout=#{httpSocketTimeout}, " +
            "messageWaitTimeout=#{messageWaitTimeout} " +
            "WHERE id=#{id}")
    int update(Instance model);

    @Select("SELECT * FROM instances WHERE id=#{id}")
    Instance findOne(String id);
}
