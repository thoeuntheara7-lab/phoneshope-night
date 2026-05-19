package com.piseth.java.school.phoneshope_night.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.piseth.java.school.phoneshope_night.entity.Brand;
import com.piseth.java.school.phoneshope_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshope_night.repository.BrandRepository;
import com.piseth.java.school.phoneshope_night.service.util.PageUtil;
import com.piseth.java.school.phoneshope_night.spec.BrandFilter;
import com.piseth.java.school.phoneshope_night.spec.BrandSpec;

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

	

	@Override
	public List<Brand> getBrands(String name) {
		//return brandRepository.findByNameLike("%"+name+"%");
		return brandRepository.findByNameContaining(name);
	}

	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter(); 
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
			
		}
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		//@TODO add to a function for pageable
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber =1;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		//Pageable 
		//Page<Brand> page = brandRepository.findAll(brandSpec, org.springframework.data.domain.Pageable.ofSize(0));
		Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
	return 	page;
		
	}

}
