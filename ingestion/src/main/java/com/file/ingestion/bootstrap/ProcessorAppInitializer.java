package com.file.ingestion.bootstrap;

import com.file.ingestion.error.handler.UncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"domain-config.xml", "file-import-config"})
@SpringBootApplication(scanBasePackages = {"com.file.ingestion", "com.file.persistence" , "com.file.parser"})
public class ProcessorAppInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessorAppInitializer.class);

    public static void main(String[] args) {

        LOG.info("Starting app now...");
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
        SpringApplication.run(ProcessorAppInitializer.class, args);
        LOG.info("App has successfully started");
    }
}
