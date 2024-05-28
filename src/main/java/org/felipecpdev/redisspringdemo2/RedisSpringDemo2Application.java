package org.felipecpdev.redisspringdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RedisSpringDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringDemo2Application.class, args);
    }

}
