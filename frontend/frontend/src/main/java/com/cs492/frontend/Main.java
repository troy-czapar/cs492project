package com.cs492.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting frontend application...");

        // Check for needed environment variables
        String clientId = System.getenv("CLIENT_ID");
        String ClientSecret = System.getenv("CLIENT_SECRET");
        String keyStorePassword = System.getenv("KEYSTORE_PASSWORD");

        if (clientId == null || ClientSecret == null || keyStorePassword == null) {
            System.err.println("Error: Required environment variables CLIENT_ID,CLIENT_SECRET,KEYSTORE_PASSWORD are not set.");
            System.exit(1);
        }

        SpringApplication.run(Main.class, args);
    }
}