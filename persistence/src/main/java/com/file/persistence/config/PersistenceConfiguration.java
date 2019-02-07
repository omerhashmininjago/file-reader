package com.file.persistence.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "persistence.autoconfigure.enabled", matchIfMissing = true)
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.file.persistence.domain"})
@EnableJpaRepositories(basePackages = {"com.file.persistence.repo"})
public class PersistenceConfiguration {
}