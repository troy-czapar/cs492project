package com.cs492.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting backend-api application...");
        SpringApplication.run(Main.class, args);

    }

}