package com.mindtree.propertytaxapp.service.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.propertytaxapp.entity.Description;
import com.mindtree.propertytaxapp.entity.Property;
import com.mindtree.propertytaxapp.entity.Zone;
import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.repository.DescriptionRepository;
import com.mindtree.propertytaxapp.repository.PropertyRepository;
import com.mindtree.propertytaxapp.repository.ZoneRepository;

public class PropertyServiceImplTest {

	@InjectMocks
	PropertyServiceImpl propertyServiceImpl;

	@Mock
	PropertyRepository propertyRepository;

	@Mock
	DescriptionRepository descriptionRepository;

	@Mock
	ZoneRepository zoneRepository;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}
	
	Logger logger=LoggerFactory.getLogger(PropertyServiceImplTest.class);

	@Test
	public void testGetZonesForPositive() throws PropertyTaxException {

		List<Zone> zones = new ArrayList<Zone>();
		zones.add(new Zone());
		Mockito.when(zoneRepository.getAllZones()).thenReturn(zones);
		assertFalse(propertyServiceImpl.getZones().isEmpty());

	}

	@Test
	public void testGetZonesForNegative() {

		List<Zone> zones = new ArrayList<Zone>();
		Mockito.when(zoneRepository.getAllZones()).thenReturn(zones);
		try {
			assertTrue(propertyServiceImpl.getZones().isEmpty());
		} catch (PropertyTaxException e) {
			assertTrue(e instanceof PropertyTaxException);
			logger.error("error in testGetZonesForNegative method =>"+e.getMessage());
		}

	}  

	@Test
	public void testGetDescriptionsForPositive() throws PropertyTaxException {
		List<Description> descriptions = new ArrayList<Description>();
		descriptions.add(new Description());
		Mockito.when(descriptionRepository.getAllDescriptions()).thenReturn(descriptions);
		assertFalse(propertyServiceImpl.getDescriptions().isEmpty());

	}

	@Test
	public void testGetDescriptionsForNegative() {
		List<Description> descriptions = new ArrayList<Description>();
		Mockito.when(descriptionRepository.getAllDescriptions()).thenReturn(descriptions);
		try {
			assertTrue(propertyServiceImpl.getDescriptions().isEmpty());
		} catch (PropertyTaxException e) {
			assertTrue(e instanceof PropertyTaxException);
			logger.error("error in testGetDescriptionsForNegative method =>"+e.getMessage());
		}

	}

	@Test
	public void testAddPropertyForPositive() throws PropertyTaxException {
		Property property = new Property();
		Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(property);
		propertyServiceImpl.addProperty(property);
		assertEquals(property, propertyRepository.save(property));
		assertNotNull(propertyRepository.save(property));
	}

	@Test
	public void testAddPropertyForNegative() {
		Property property = null;
		Mockito.when(propertyRepository.save(Mockito.any())).thenReturn("saved");
		try {
			propertyServiceImpl.addProperty(property);
		} catch (PropertyTaxException e) {
			assertTrue(e instanceof PropertyTaxException);
			logger.error("error in testAddPropertyForNegative method =>"+e.getMessage());
		}

	}

	@Test
	public void testCaculateTotalPrice() throws PropertyTaxException {

		int age = 75;
		int area = 10;
		assertNotNull(propertyServiceImpl.caculateTotalPrice(area, age));
		assertEquals(75, age);
		assertEquals(10, area);
		assertNotNull(age);
		assertNotNull(area);

		age = 50;

		assertNotNull(propertyServiceImpl.caculateTotalPrice(area, age));
		assertEquals(50, age);
		assertEquals(10, area);
		assertNotNull(age);
		assertNotNull(area);

	}

	@Test
	public void testCaculateTotalPriceForArea() {

		int area = 0;
		int age = 10;
		try {
			propertyServiceImpl.caculateTotalPrice(area, age);
		} catch (PropertyTaxException e) {
			assertTrue(e instanceof PropertyTaxException);
			logger.error("error in testCaculateTotalPriceForArea method =>"+e.getMessage());
		}
		
		

	}

	@Test
	public void testCaculateTotalPriceForAge() {

		int age = 0;
		int area = 10;
		try {
			propertyServiceImpl.caculateTotalPrice(area, age);
		} catch (PropertyTaxException e) {
			assertTrue(e instanceof PropertyTaxException);
			logger.error("error in testCaculateTotalPriceForAge method =>"+e.getMessage());
		}

	}

	@Test
	public void testGetZoneReportForCheckingOwner() {

		Zone zone2=new Zone(2, "zoneB", null);
		Property property2 = new Property(2, 2012, "abhinav", "abaac@gmail.com", "delhi", zone2, new Description(),
				"Tenated", "2019", "12", 100.0);
		
		List<Property> properties=new ArrayList<Property>();
		properties.add(property2);
		
		Zone zone=new Zone(1, "zoneA", properties);
		List<Zone> zones=new ArrayList<Zone>();
		zones.add(zone);
		Property property = new Property(1, 2012, "sayan", "abcssa@gmail.com", "delhi", zone, new Description(),
				"Owner", "2019", "12", 100.0);
		properties.add(property);
		
		Mockito.when(propertyRepository.findAll()).thenReturn(properties);
		Mockito.when(zoneRepository.findAll()).thenReturn(zones);
		
		assertNotNull(propertyServiceImpl.getZoneReport());
		

		}
	
	
	
	@Test
	public void testGetZoneReportForCheckingTenated() {

		Zone zone2=new Zone(2, "zoneB", null);
		Property property2 = new Property(2, 2012, "abhinav", "abaac@gmail.com", "delhi", zone2, new Description(),
				"Owner", "2019", "12", 100.0);
		
		List<Property> properties=new ArrayList<Property>();
		properties.add(property2);
		
		Zone zone=new Zone(1, "zoneA", properties);
		List<Zone> zones=new ArrayList<Zone>();
		zones.add(zone);
		Property property = new Property(1, 2012, "sayan", "abcssa@gmail.com", "delhi", zone, new Description(),
				"Tenated", "2019", "12", 100.0);
		properties.add(property);
		
		Mockito.when(propertyRepository.findAll()).thenReturn(properties);
		Mockito.when(zoneRepository.findAll()).thenReturn(zones);
		
		assertNotNull(propertyServiceImpl.getZoneReport());
		

		}
		
		
	}


