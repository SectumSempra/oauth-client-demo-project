package com.be.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
	    // -- swagger ui
	    "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
	    "/configuration/security", "/swagger-ui.html", "/webjars/**"
	    // other public endpoints of your API may be appended to this array
    };

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers(AUTH_WHITELIST);
    }

}