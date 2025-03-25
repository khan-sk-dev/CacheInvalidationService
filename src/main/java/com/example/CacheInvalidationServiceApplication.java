package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Cache Invalidation Service application.
 * <p>
 * This Spring Boot application is responsible for handling cache invalidation processes
 * and ensuring data consistency across distributed systems.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 *     java -jar cache-invalidation-service.jar
 * </pre>
 *
 * @author Your Name
 * @version 1.0
 */
@SpringBootApplication
public class CacheInvalidationServiceApplication {

    /**
     * Main method to start the Spring Boot application.
     * <p>
     * This method initializes the Spring Application Context and auto-configures the service.
     * </p>
     *
     * @param args Command-line arguments passed during application startup.
     */
    public static void main(String[] args) {
        SpringApplication.run(CacheInvalidationServiceApplication.class, args);
    }
}
