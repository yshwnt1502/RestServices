package com.restservices.restwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	private SomeBean someBean;
	
	
	@GetMapping(value="/filteringList")
	public MappingJacksonValue retrieveBean(){
		
		List<SomeBean> list=Arrays.asList(new SomeBean("Value 1","Value 2","Value 3","Value 4"),
				new SomeBean("value 5","Value 6","Value 7","value 8"));
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		
		MappingJacksonValue mapping =new MappingJacksonValue(list);
		
		mapping.setFilters(filters);
		
		return mapping;
		
		
		
	}

}
