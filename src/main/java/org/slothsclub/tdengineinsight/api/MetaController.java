package org.slothsclub.tdengineinsight.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Parameter(name = "type", schema = @Schema(allowableValues = {"dnodes", "mnodes", "qnodes", "cluster", "databases", "functions", "indexes", "stables", "tables", "tags", "columns", "users", "configs", "dnode_variables", "topics", "subscriptions"}))
    public Result<List<Meta>> basic(@PathVariable String type) {
        String metaTableName = metas.getOrDefault(type, null);
        if (metaTableName == null) {
            return Result.success(null);
        }
        return Result.success(metaService.basicQuery(metaTableName));
    }

    @GetMapping("/query/{type}")
    @Parameter(name = "type", schema = @Schema(allowableValues = {"stables", "tables", "tags", "columns", "topics"}))
    public Result<List<Meta>> query(@PathVariable String type, @RequestParam String dbName, @RequestParam(required = false) String tableName, @RequestParam(required = false, defaultValue = "child") String tableType) {
        List<Meta> result = null;
        switch (type) {
            case "stables" -> result = metaService.searchStables(dbName);
            case "tables" -> {
                switch (tableType) {
                    case "childTable" -> result = metaService.searchSubTables(dbName, tableName);
                    case "normalTable" -> result = metaService.searchNormalTables(dbName);
                }
            }
            case "tags" -> {
                switch (tableType) {
                    case "childTable" -> result = metaService.searchTags(dbName, tableName);
                    case "normalTable" -> result = metaService.searchTags(dbName, tableName);
                    case "stable" -> result = metaService.searchStableTags(dbName, tableName);
                }
            }
            case "columns" -> result = metaService.searchColumns(dbName, tableName);
            case "topics" -> result = metaService.searchTopics(dbName);
            default -> {
            }
        }
        return Result.success(result);
    }

    @GetMapping("/version")
    public String version() {
        return metaService.getServerVersion();
    }
}
