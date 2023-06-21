package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.Instance;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/app/instance")
@Slf4j
public class InstanceController {

    @GetMapping("")
    public List<Instance> all() {
        return null;
    }

    @PostMapping("")
    public void create() {}

    @PostMapping("/{id}/open")
    public void open(@PathVariable String id) throws SQLException {}

    @PutMapping("/{id}")
    public void update(@PathVariable String id) {}

    @DeleteMapping("/{id}")
    public void delete() {}
}
