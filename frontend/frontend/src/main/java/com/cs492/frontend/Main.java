package com.cs492.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting frontend application...");
        SpringApplication.run(Main.class, args);
    }
}