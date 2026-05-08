package com.piseth.java.school.phoneshope_night.service.util;

import com.piseth.java.school.phoneshope_night.dto.BrandDTO;
import com.piseth.java.school.phoneshope_night.entity.Brand;

public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		//brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
	public static BrandDTO tobrandDTO(Brand brand) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}