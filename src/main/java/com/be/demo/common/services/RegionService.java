package com.be.demo.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.be.demo.common.cahce.MyCacheUtils;
import com.be.demo.common.model.Region;
import com.be.demo.common.repository.RegionRepository;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Cacheable(cacheNames = MyCacheUtils.CN_REGION, cacheManager = MyCacheUtils.CacheBeans.CACHE_MANAGER, keyGenerator = MyCacheUtils.CacheBeans.KEY_GENERATOR)
    public List<Region> listAll() {
	return regionRepository.findAll();
    }

    @CacheEvict(cacheNames = MyCacheUtils.CN_REGION, allEntries = true)
    public void save(Region r) {
	regionRepository.save(r);
    }

}
