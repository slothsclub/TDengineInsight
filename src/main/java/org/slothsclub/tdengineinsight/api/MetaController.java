package org.slothsclub.tdengineinsight.api;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tdengine/meta")
@Slf4j
public class MetaController {
    @Autowired
    MetaService metaService;

}
