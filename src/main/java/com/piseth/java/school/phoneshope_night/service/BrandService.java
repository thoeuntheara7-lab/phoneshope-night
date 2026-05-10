package com.piseth.java.school.phoneshope_night.service;

import java.util.List;

import com.piseth.java.school.phoneshope_night.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
	List<Brand> getBrands();
}
