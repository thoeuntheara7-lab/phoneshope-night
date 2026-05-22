package com.piseth.java.school.phoneshope_night.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.piseth.java.school.phoneshope_night.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
	@Test
	public void findByNameLike() {
		// given
		Brand brand = new Brand();
		brand.setName("Apple");
		brandRepository.save(brand);
		
		Brand brand2 = new Brand();
		brand2.setName("samsung");
		brandRepository.save(brand2);
		// when
		List<Brand> brands = brandRepository.findByNameContaining("A");
		// then
		assertEquals(1, brands.size());
		assertEquals("Apple", brands.get(0).getName());
	}
}
