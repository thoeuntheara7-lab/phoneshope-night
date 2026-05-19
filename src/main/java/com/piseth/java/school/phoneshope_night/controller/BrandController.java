package com.piseth.java.school.phoneshope_night.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.phoneshope_night.dto.BrandDTO;
import com.piseth.java.school.phoneshope_night.dto.PageDTO;
import com.piseth.java.school.phoneshope_night.entity.Brand;
import com.piseth.java.school.phoneshope_night.mapper.BrandMapper;
import com.piseth.java.school.phoneshope_night.service.BrandService;



@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
		private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
			brand = brandService.create(brand);
			return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
		}
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
		@PutMapping("{id}")
		public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
			Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
			Brand UpdateBrand = brandService.update(brandId, brand);
			return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(UpdateBrand));
		}
		
		@GetMapping
		public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
		Page<Brand> page = brandService.getBrands(params);
		PageDTO pageDTO = new PageDTO(page);	
		/*
			List<BrandDTO> list = brandService.getBrands(params)
			.stream()
			.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
			.collect(Collectors.toList());
			*/
			return ResponseEntity.ok(pageDTO);
		
		}
		
		
}
