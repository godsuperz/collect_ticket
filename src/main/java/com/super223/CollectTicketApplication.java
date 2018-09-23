package com.super223;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author superz
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.super223.mapper"})
public class CollectTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectTicketApplication.class, args);
    }
}
