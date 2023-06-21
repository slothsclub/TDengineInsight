package org.slothsclub.tdengineinsight.support;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slothsclub.tdengineinsight.config.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Order(-1)
@Component
@Slf4j
public class DynamicDataSourceAspect {
    @Autowired
    DynamicDataSource dynamicDataSource;

    @Pointcut("execution( * org.slothsclub.tdengineinsight.service..*.*(..))")
    public void exec() {
    }

    @Before("exec()")
    public void before(JoinPoint point) {
        String cls = point.getTarget().getClass().getSuperclass().getSimpleName();
        if ("TdengineService".equals(cls)) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String instanceId = request.getHeader("x-instance-id");
            switchDataSource(instanceId);
        } else {
            switchDataSource("default");
        }
    }

    @After("exec()")
    public void after(JoinPoint point) {
        restoreDataSource();
    }

    private void switchDataSource(String key) {
        if (!dynamicDataSource.hasInstance(key)) {
            log.debug("======> DataSource doesn't exist, use default DataSource");
        } else {
            dynamicDataSource.setCurrent(key);
            log.debug("======> Switch DataSource to {}", dynamicDataSource.getCurrent());
        }
    }

    private void restoreDataSource() {
        dynamicDataSource.clear();
    }
}
