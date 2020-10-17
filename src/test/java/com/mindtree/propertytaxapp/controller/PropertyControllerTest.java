package com.mindtree.propertytaxapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;



import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.mindtree.propertytaxapp.entity.Description;
import com.mindtree.propertytaxapp.entity.Property;
import com.mindtree.propertytaxapp.entity.Zone;
import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.service.PropertyService;



/**
 * @author M1056078
 *
 */
public class PropertyControllerTest {

	@InjectMocks
	PropertyController propertyController;
	
	@Mock
	PropertyService propertyService;
	
	@Mock
	Model model;
	
	@Mock
	BindingResult bindingResult;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testHomePage() {
		assertNotNull(propertyController.homePage());
	}

	@Test
	public void testAddPropertyForPositiveBinding() throws PropertyTaxException {
		Property property = new Property(1, 2012, "abhinav", "abc@gmail.com", "delhi", new Zone(), new Description(),
				"status", "2019", "12", 100.0);
		Mockito.doNothing().when(propertyService).addProperty(property);
		Mockito.when(model.addAttribute(Mockito.any(), Mockito.any())).thenReturn(model);
		assertNotNull(propertyController.addProperty(property, model, bindingResult));
		
		assertNotNull(model.addAttribute(Mockito.any(), Mockito.any()));
	}

	@Test
	public void testAddPropertyForNeagtiveBinding() throws PropertyTaxException {
		Property property = new Property(1, 2012, "abhinav", "abc@gmail.com", "delhi", new Zone(), new Description(),
				"status", "2019", "12", 100.0);
		Mockito.when(bindingResult.hasErrors()).thenReturn(true);
		assertNotNull(propertyController.addProperty(property, model, bindingResult));
	
	}

	
	@Test
	public void testCancelButton() {
		assertNotNull(propertyController.cancelButton());
	}

	@Test
	public void testPopulateValues() throws PropertyTaxException {
		Mockito.when(model.addAttribute(Mockito.any(), Mockito.any())).thenReturn(model);
		assertNotNull(propertyController.populateValues(model));
		assertNotNull(model.addAttribute(Mockito.any(), Mockito.any()));
		   
	}

	@Test
	public void testReport() throws PropertyTaxException {
		
		Map<String, Map<String, Double>> report = new HashMap<>();
		Map<String, Double> propertyTypeCollection = new HashMap<String, Double>();
		
		propertyTypeCollection.put("abc", 1.0);
		report.put("bcd", propertyTypeCollection);
		Mockito.when(propertyService.getZoneReport()).thenReturn(report);
		Mockito.when(model.addAttribute(Mockito.any(), Mockito.any())).thenReturn(model);
		assertNotNull(propertyController.report(model));
		assertEquals(1, report.size());  
		assertNotEquals(4, report.size());
		assertNotNull(model.addAttribute(Mockito.any(), Mockito.any()));
	}

}
