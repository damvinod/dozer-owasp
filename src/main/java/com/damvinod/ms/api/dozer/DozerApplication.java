package com.damvinod.ms.api.dozer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DozerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DozerApplication.class, args);
  }
}
