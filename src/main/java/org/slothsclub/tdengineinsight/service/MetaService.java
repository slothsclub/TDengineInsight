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

    public List<Meta> searchTables(String dbName, String stableName) {
        if (stableName == null) {
            return metaMapper.getMetaByDbName("INS_TABLES", dbName);
        }
        return metaMapper.getMetaByDbNameAndTableName("INS_TABLES", dbName, stableName, "stableName");
    }

    public List<Meta> searchTags(String dbName, String stableName) {
        if (stableName == null) {
            return metaMapper.getMetaByDbName("INS_TAGS", dbName);
        }
        return metaMapper.getMetaByDbNameAndTableName("INS_TAGS", dbName, stableName, "stableName");
    }

    public List<Meta> searchColumns(String dbName, String tableName) {
        if (tableName == null) {
            return metaMapper.getMetaByDbName("INS_COLUMNS", dbName);
        }
        return metaMapper.getMetaByDbNameAndTableName("INS_COLUMNS", dbName, tableName, "tableName");
    }

    public List<Meta> searchTopics(String dbName) {
        return metaMapper.getMetaByDbName("INS_TOPICS", dbName);
    }
}
