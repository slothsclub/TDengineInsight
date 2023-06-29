package org.slothsclub.tdengineinsight.api;

import io.swagger.v3.oas.annotations.Hidden;
import org.slothsclub.tdengineinsight.exception.DataSourceNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
@Hidden
public class ErrorController {
    @RequestMapping("/invalid-instance")
    public void invalidInstance() {
        throw new DataSourceNotFoundException("Invalid instance id");
    }
}
