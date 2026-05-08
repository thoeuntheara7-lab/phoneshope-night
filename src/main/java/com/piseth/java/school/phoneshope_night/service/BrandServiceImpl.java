package com.piseth.java.school.phoneshope_night.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.piseth.java.school.phoneshope_night.entity.Brand;
import com.piseth.java.school.phoneshope_night.exception.ApiException;
import com.piseth.java.school.phoneshope_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshope_night.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {  
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		
		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); // @TODO improve update
		return brandRepository.save(brand);
	}



}
