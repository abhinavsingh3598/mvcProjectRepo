package com.mindtree.propertytaxapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.service.PropertyService;


/**
 * @author M1056078
 *
 */
@RestController
@RequestMapping("/rest")
public class PropertyRestController {

	@Autowired
	PropertyService propertyService;

	@GetMapping("/loadtotalprice/{area}/{age}")
	public double update3(@PathVariable("area") int area, @PathVariable("age") int age) throws PropertyTaxException {

		double totalprice;

		totalprice = propertyService.caculateTotalPrice(area, age);

		return totalprice;
	}

}
