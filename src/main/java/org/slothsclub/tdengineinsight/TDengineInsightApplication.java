package org.slothsclub.tdengineinsight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.slothsclub.tdengineinsight.mapper")
public class TDengineInsightApplication {

    public static void main(String[] args) {
        SpringApplication.run(TDengineInsightApplication.class, args);
    }

}
