package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.RawSqlRequest;
import org.slothsclub.tdengineinsight.bind.RawSqlResult;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.service.ExecSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tdengine/exec")
@Slf4j
public class ExecSqlController {
    @Autowired
    ExecSqlService execSqlService;

    @PostMapping("/sql")
    public Result<RawSqlResult> exec(@RequestBody RawSqlRequest rawSqlRequest) {
        return Result.success(new RawSqlResult(
                execSqlService.count(rawSqlRequest.getCountSql()),
                execSqlService.exec(rawSqlRequest.getRawSql()),
                0
        ));
    }
}
