package com.springframework.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringVacationPlanner {
    public static void main(String[] args){
        System.out.println("Starting Program!");
        SpringApplication.run(SpringVacationPlanner.class, args);
    }
}
