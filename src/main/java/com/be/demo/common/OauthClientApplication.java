package com.be.demo.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties
@EnableJpaRepositories("com.be.demo.common.repository")
@EntityScan("com.be.demo.common.model")
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class OauthClientApplication implements CommandLineRunner {

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    };

    public static void main(String[] args) {
	SpringApplication.run(OauthClientApplication.class, args);

    }

    @Override
    public void run(String... arg0) throws Exception {

    }

}