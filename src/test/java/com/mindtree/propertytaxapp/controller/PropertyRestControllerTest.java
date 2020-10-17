package com.mindtree.propertytaxapp.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.service.PropertyService;

public class PropertyRestControllerTest {

	@InjectMocks
	PropertyRestController propertyRestController;

	@Mock
	PropertyService propertyService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testUpdate3() throws PropertyTaxException {

		int age = 10;
		int area = 120;
		Mockito.when(propertyService.caculateTotalPrice(area, age)).thenReturn(100.00);	
		assertNotNull(propertyRestController.update3(area, age));

	}

}
