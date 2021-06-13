package com.be.demo.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.demo.common.cahce.MyCacheUtils;
import com.be.demo.common.model.Country;
import com.be.demo.common.model.Region;
import com.be.demo.common.services.CountryService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryRestController {

    public static final Logger logger = LoggerFactory.getLogger(CountryRestController.class);

    @Autowired
    CountryService countryService;

    @Autowired
    @Qualifier(MyCacheUtils.CacheBeans.CACHE_MANAGER)
    RedisCacheManager redisCacheManager;

    @GetMapping(value = "/country-list-all")
    public ResponseEntity<?> getAllRegions() {
	List<Country> list = countryService.listAll();
	return ResponseEntity.ok(list);
    }

}