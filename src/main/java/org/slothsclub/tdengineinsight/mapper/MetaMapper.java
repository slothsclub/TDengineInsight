package org.slothsclub.tdengineinsight.mapper;

import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.slothsclub.tdengineinsight.bind.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetaMapper {

    @Select("SELECT '${metaTableName}' as t, * FROM INFORMATION_SCHEMA.${metaTableName}")
    @TypeDiscriminator(column = "t", javaType = String.class, cases = {
            @Case(value = "INS_DNODES", type = MetaDNode.class),
            @Case(value = "INS_MNODES", type = MetaMNode.class),
            @Case(value = "INS_QNODES", type = MetaQNode.class),
            @Case(value = "INS_CLUSTER", type = MetaCluster.class),
            @Case(value = "INS_DATABASES", type = MetaDatabase.class),
            @Case(value = "INS_FUNCTIONS", type = MetaFunction.class),
            @Case(value = "INS_INDEXES", type = MetaIndex.class),
            @Case(value = "INS_STABLES", type = MetaStable.class),
            @Case(value = "INS_TABLES", type = MetaTable.class),
            @Case(value = "INS_TAGS", type = MetaTag.class),
            @Case(value = "INS_COLUMNS", type = MetaColumn.class),
            @Case(value = "INS_USERS", type = MetaUser.class),
            @Case(value = "INS_CONFIGS", type = MetaConfig.class),
            @Case(value = "INS_DNODE_VARIABLES", type = MetaDnodeVariable.class),
            @Case(value = "INS_TOPICS", type = MetaTopic.class),
            @Case(value = "INS_SUBSCRIPTIONS", type = MetaSubscription.class)
    })
    List<Meta> getMeta(String metaTableName);

    @Select("SELECT '${metaTableName}' as t, * FROM INFORMATION_SCHEMA.${metaTableName} WHERE db_name=#{db}")
    @TypeDiscriminator(column = "t", javaType = String.class, cases = {
            @Case(value = "INS_STABLES", type = MetaStable.class),
            @Case(value = "INS_TABLES", type = MetaTable.class),
            @Case(value = "INS_TAGS", type = MetaTag.class),
            @Case(value = "INS_COLUMNS", type = MetaColumn.class),
            @Case(value = "INS_TOPICS", type = MetaTopic.class),
    })
    List<Meta> getMetaByDbName(String metaTableName, String db);

    @Select("SELECT '${metaTableName}' as t, * FROM INFORMATION_SCHEMA.${metaTableName} WHERE db_name=#{db} AND ${field}=#{table}")
    @TypeDiscriminator(column = "t", javaType = String.class, cases = {
            @Case(value = "INS_STABLES", type = MetaStable.class),
            @Case(value = "INS_TABLES", type = MetaTable.class),
            @Case(value = "INS_TAGS", type = MetaTag.class),
            @Case(value = "INS_COLUMNS", type = MetaColumn.class),
    })
    List<Meta> getMetaByDbNameAndTableName(String metaTableName, String db, String table, String field);

    @Select("SELECT * FROM INFORMATION_SCHEMA.${metaTableName} WHERE db_name=#{db} AND type='NORMAL_TABLE'")
    @TypeDiscriminator(column = "type", javaType = String.class, cases = {
            @Case(value = "NORMAL_TABLE", type = MetaTable.class),
    })
    List<Meta> getNormalTables(String metaTableName, String db);
}
