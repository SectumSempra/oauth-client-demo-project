package com.be.demo.common.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.demo.common.cahce.CacheTTL;
import com.be.demo.common.cahce.MyCacheUtils;
import com.be.demo.common.model.Region;
import com.be.demo.common.services.RegionService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionRestController {

    public static final Logger logger = LoggerFactory.getLogger(RegionRestController.class);

    @Autowired
    RegionService regionService;

    @Autowired
    @Qualifier(MyCacheUtils.CacheBeans.CACHE_MANAGER)
    RedisCacheManager redisCacheManager;

    @GetMapping(value = "/get-all-regions")
    public ResponseEntity<?> getAllRegions() {
	List<Region> list = regionService.listAll();
	return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get-all-regions-manually")
    @CacheTTL(ttlMinutes = 5)
    public ResponseEntity<?> getAllRegionsManually() {
	/*
	 * Cache cache = redisCacheManager.getCache(MyCacheUtils.CN_REGION);
	 * ValueWrapper svw = cache.get("RegionService#listAll"); List<Region> list =
	 * (List<Region>) svw.get()
	 */ ;
	List<Region> list = regionService.listAll();
	return ResponseEntity.ok(list.get(0));
    }

    @PostMapping(value = "/create-region")
    public ResponseEntity<?> createRegion(@RequestBody Region r) {
	regionService.save(r);
	return ResponseEntity.ok(r);
    }
}