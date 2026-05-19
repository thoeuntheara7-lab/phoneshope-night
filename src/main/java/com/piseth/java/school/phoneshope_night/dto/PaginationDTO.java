package com.piseth.java.school.phoneshope_night.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private int totalElements;
	private long NumberOfElements;

	private boolean first;
	private boolean list;
	private boolean empty;

}
