package org.slothsclub.tdengineinsight.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.Meta;
import org.slothsclub.tdengineinsight.bind.Perf;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.service.PerfService;
import org.slothsclub.tdengineinsight.support.V1APIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tdengine/perf")
@Slf4j
@V1APIController
public class PerfController {
    private final Map<String, String> metas = new HashMap<>() {{
        put("apps", "PERF_APPS");
        put("connections", "PERF_CONNECTIONS");
        put("queries", "PERF_QUERIES");
        put("consumers", "PERF_CONSUMERS");
        put("trans", "PERF_TRANS");
        put("smas", "PERF_SMAS");
    }};

    @Autowired
    PerfService perfService;

    @GetMapping("/basic/{type}")
    @Parameter(name = "type", schema = @Schema(allowableValues = {"apps", "connections", "queries", "consumers", "trans", "smas"}))
    public Result<List<Perf>> basic(@PathVariable String type) {
        String perfTableName = metas.getOrDefault(type, null);
        if (perfTableName == null) {
            return Result.success(null);
        }
        return Result.success(perfService.query(perfTableName));
    }
}
