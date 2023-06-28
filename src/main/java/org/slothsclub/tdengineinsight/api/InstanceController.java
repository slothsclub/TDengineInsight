package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.slothsclub.tdengineinsight.bind.ResponseCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/app/instance")
@Slf4j
public class InstanceController {
    @Autowired
    InstanceService instanceService;

    @GetMapping("")
    public Result<List<Instance>> all() {
        return Result.success(instanceService.selectAll());
    }

    @PostMapping("")
    public Result<Instance> create(@RequestBody @Validated Instance instance) {
        instance.setId(UUID.randomUUID().toString());
        instanceService.insert(instance);
        return Result.success(instance);
    }

    @GetMapping("/{id}")
    public Result<Instance> detail(@PathVariable String id) {
        return Result.success(instanceService.detail(id));
    }

    @PostMapping("/{id}/open")
    public Result<Instance> open(@PathVariable String id) {
        Instance instance = instanceService.detail(id);
        if (instance == null) {
            return Result.fail(ResponseCode.BAD_REQUEST, "Instance not found");
        }
        instanceService.testConnection(instance);

        boolean created = instanceService.createDataSourceIfMissing(instance);
        if (!created) {
            return Result.fail(ResponseCode.INTERNAL_SERVER_ERROR, "Can not create datasource");
        }
        return Result.success(instance);
    }

    @PutMapping("/{id}")
    public Result<Instance> update(@PathVariable String id, @RequestBody @Validated Instance instance) {
        instanceService.update(id, instance);
        return Result.success(instanceService.detail(id));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable String id) {
        return Result.success(instanceService.delete(id));
    }
}
