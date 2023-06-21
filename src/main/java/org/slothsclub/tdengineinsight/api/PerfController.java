package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.service.PerfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdengine/perf")
@Slf4j
public class PerfController {
    @Autowired
    PerfService perfService;
}
