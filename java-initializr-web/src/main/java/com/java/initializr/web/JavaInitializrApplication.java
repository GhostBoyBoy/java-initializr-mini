package com.java.initializr.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.java.*")
public class JavaInitializrApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaInitializrApplication.class, args);
    }

}
