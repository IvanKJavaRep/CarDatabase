package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
        DataSourceClass dataSourceClass = new DataSourceClass();
    }

}
