package com.piseth.java.school.phoneshope_night.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.piseth.java.school.phoneshope_night.entity.Brand;

import lombok.Data;
@Data
public class PageDTO {
	private List<?> list;
	private PaginationDTO pagination;

	public PageDTO(Page<?> page) {
		this.list = page.getContent();
		this.pagination = PaginationDTO.builder()
				.empty(page.isEmpty())
				.first(page.isFirst())
				.list(page.isLast())
				.pageSize(page.getPageable().getPageSize())
				.pageNumber(page.getPageable().getPageNumber()+1)
				.totalPages(page.getTotalPages())
				.totalElements(page.getTotalPages())
				.NumberOfElements(page.getNumberOfElements())
				.build();
	}


}
