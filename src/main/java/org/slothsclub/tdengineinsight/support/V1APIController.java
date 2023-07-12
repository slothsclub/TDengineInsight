package org.slothsclub.tdengineinsight.support;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
//@RequestMapping("/api/v1")
public @interface V1APIController {
}
