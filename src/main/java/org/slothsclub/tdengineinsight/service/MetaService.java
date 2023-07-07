package org.slothsclub.tdengineinsight.service;

import org.slothsclub.tdengineinsight.TdengineService;
import org.slothsclub.tdengineinsight.bind.Meta;
import org.slothsclub.tdengineinsight.mapper.MetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MetaService extends TdengineService {

    @Autowired
    MetaMapper metaMapper;

    public List<Meta> basicQuery(String metaTableName) {
        return metaMapper.getMeta(metaTableName);
    }

    public List<Meta> searchStables(String dbName) {
        return metaMapper.getMetaByDbName("INS_STABLES", dbName);
    }

    public List<Meta> searchSubTables(String dbName, String stableName) {
        if (stableName == null) {
            return metaMapper.getMetaByDbName("INS_TABLES", dbName);
        }
        return metaMapper.getMetaByDbNameAndTableName("INS_TABLES", dbName, stableName, "stable_name");
    }

    public List<Meta> searchNormalTables(String dbName) {
        return metaMapper.getNormalTables("INS_TABLES", dbName);
    }

    public List<Meta> searchTags(String dbName, String stableName) {
        return metaMapper.getMetaByDbNameAndTableName("INS_TAGS", dbName, stableName, "table_name");
    }

    public List<Meta> searchStableTags(String dbName, String stableName) {
        return metaMapper.getStableTags("INS_TAGS", dbName, stableName);
    }

    public List<Meta> searchTagValues(String dbName, String stableName) {
        return metaMapper.getTagValues("INS_TAGS", dbName, stableName);
    }

    public List<Meta> searchColumns(String dbName, String tableName) {
        return metaMapper.getMetaByDbNameAndTableName("INS_COLUMNS", dbName, tableName, "table_name");
    }

    public List<Meta> searchTopics(String dbName) {
        return metaMapper.getMetaByDbName("INS_TOPICS", dbName);
    }

    public String getServerVersion() {
        return metaMapper.getServerVersion();
    }
}
