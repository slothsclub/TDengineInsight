package org.slothsclub.tdengineinsight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("org.slothsclub.tdengineinsight.mapper")
@EnableWebMvc
public class TDengineInsightApplication {

    public static void main(String[] args) {
        SpringApplication.run(TDengineInsightApplication.class, args);
    }

}
