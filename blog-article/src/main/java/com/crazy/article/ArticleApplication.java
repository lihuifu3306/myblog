package com.crazy.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-19 12:02
 */

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
