package org.slothsclub.tdengineinsight.config;

import org.slothsclub.tdengineinsight.filter.InstanceHeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<InstanceHeaderFilter> registrationBean() {
        FilterRegistrationBean<InstanceHeaderFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new InstanceHeaderFilter());
        registrationBean.addUrlPatterns("/tdengine/*");
        registrationBean.setOrder(2);
        registrationBean.setName("instanceHeaderFilter");

        return registrationBean;
    }
}
