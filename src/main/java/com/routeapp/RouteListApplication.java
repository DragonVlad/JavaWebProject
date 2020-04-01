package com.routeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RouteListApplication {
    public static void main(String[] args) {
        SpringApplication.run(RouteListApplication.class, args);
    }
}
