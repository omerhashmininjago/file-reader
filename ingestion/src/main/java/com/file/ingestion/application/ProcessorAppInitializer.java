package com.file.ingestion.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"domain-config.xml", "fileImport-config"})
@SpringBootApplication(scanBasePackages = "com.file.ingestion")
public class ProcessorAppInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProcessorAppInitializer.class, args);
    }
}
