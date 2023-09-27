/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.assetoperationsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * This class is the entry point for the Asset Operations Service application.
 * It also contains the required annotations for configuration.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableReactiveMongoRepositories
public class AssetOperationsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssetOperationsServiceApplication.class, args);
  }

}
