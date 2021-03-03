package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.woniu.mapper")
public class FileVueHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileVueHomeworkApplication.class, args);
    }


}
