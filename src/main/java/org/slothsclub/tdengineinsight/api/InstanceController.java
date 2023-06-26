package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.Instance;
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
    public Result<Boolean> create(@RequestBody @Validated Instance instance) {
        instance.setId(UUID.randomUUID().toString());
        return Result.success(instanceService.insert(instance));
    }

    @GetMapping("/{id}")
    public Result<Instance> detail(@PathVariable String id) {
        return Result.success(instanceService.detail(id));
    }

    @PostMapping("/{id}/open")
    public Result<Boolean> open(@PathVariable String id) {
        return Result.success(instanceService.createDataSourceIfMissing(id));
    }

    @PutMapping("/{id}")
    public Result<Boolean> update(@PathVariable String id, @RequestBody @Validated Instance instance) {
        return Result.success(instanceService.update(id, instance));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable String id) {
        return Result.success(instanceService.delete(id));
    }
}
