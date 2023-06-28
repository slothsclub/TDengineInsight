package org.slothsclub.tdengineinsight.api;

import org.slothsclub.tdengineinsight.exception.DataSourceNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/invalid-instance")
    public void invalidInstance() {
        throw new DataSourceNotFoundException("Invalid instance id");
    }
}
