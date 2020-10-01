package com.be.demo.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.demo.common.model.Country;
import com.be.demo.common.repository.CountryRepository;

@Service
public class CountryService implements ICountryService {

	@Autowired
	private CountryRepository ep;

	@Override
	public List<Country> listAll() {
		return ep.findAll();
	}

}
