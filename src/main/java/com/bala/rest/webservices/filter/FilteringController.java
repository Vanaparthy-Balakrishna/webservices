package com.bala.rest.webservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public MappingJacksonValue getFilterBean() {
		FilterBean filterBean = new FilterBean("UserName", "Password");

		// dynamic filtering
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("BeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
		mapping.setFilters(filterProvider);

		return mapping;
	}

	@GetMapping("/filter-list")
	public MappingJacksonValue getFilterListBeans() {
		List<FilterBean> list = Arrays.asList(new FilterBean("UserName1", "Password1"), new FilterBean("UserName2", "Password2"));

		//dynamic filtering
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("BeanFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
}
