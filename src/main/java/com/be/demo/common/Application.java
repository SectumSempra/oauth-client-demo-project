package com.be.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties
@EnableCaching
@EnableJpaRepositories("com.be.demo.common.repository")
@EntityScan("com.be.demo.common.model")
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);

    }

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    };

    @Autowired
    private ApplicationContext content;

    @Override
    public void run(String... arg0) throws Exception {

    }

}