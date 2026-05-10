package com.anirudh.aopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopAppApplication.class, args);
    }

}
