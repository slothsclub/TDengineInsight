package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Select;
import org.slothsclub.tdengineinsight.bind.MetaDNode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetaMapper {

    @Select("SELECT * FROM INFORMATION_SCHEMA.INS_DNODES")
    List<MetaDNode> getDNodes();
}
