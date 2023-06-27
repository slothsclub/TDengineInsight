package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.Meta;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/tdengine/meta")
@Slf4j
public class MetaController {
    private final Map<String, String> metas = new HashMap<>() {{
        put("dnodes", "INS_DNODES");
        put("mnodes", "INS_MNODES");
        put("qnodes", "INS_QNODES");
        put("cluster", "INS_CLUSTER");
        put("databases", "INS_DATABASES");
        put("functions", "INS_FUNCTIONS");
        put("indexes", "INS_INDEXES");
        put("stables", "INS_STABLES");
        put("tables", "INS_TABLES");
        put("tags", "INS_TAGS");
        put("columns", "INS_COLUMNS");
        put("users", "INS_USERS");
        put("configs", "INS_CONFIGS");
        put("dnode_variables", "INS_DNODE_VARIABLES");
        put("topics", "INS_TOPICS");
        put("subscriptions", "INS_SUBSCRIPTIONS");
    }};

    @Autowired
    MetaService metaService;

    @GetMapping("/basic/{type}")
    public Result<List<Meta>> basic(@PathVariable String type) {
        String metaTableName = metas.getOrDefault(type, null);
        if (metaTableName == null) {
            return Result.success(null);
        }
        return Result.success(metaService.basicQuery(metaTableName));
    }

    @GetMapping("/query")
    public Result<List<Meta>> query(@RequestParam String type, @RequestParam String dbName, @RequestParam String tableName) {
        return switch (type) {
            case "stables" -> Result.success(metaService.searchStables(dbName));
            case "tables" -> Result.success(metaService.searchTables(dbName, tableName));
            case "tags" -> Result.success(metaService.searchTags(dbName, tableName));
            case "columns" -> Result.success(metaService.searchColumns(dbName, tableName));
            case "topics" -> Result.success(metaService.searchTopics(dbName));
            default -> Result.success(null);
        };
    }
}
