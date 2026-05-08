package com.piseth.java.school.phoneshope_night.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.phoneshope_night.dto.BrandDTO;
import com.piseth.java.school.phoneshope_night.entity.Brand;

@Mapper
public interface BrandMapper {
		BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand entity);
}
