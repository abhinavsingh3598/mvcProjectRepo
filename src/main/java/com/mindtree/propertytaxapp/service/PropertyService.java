package com.mindtree.propertytaxapp.service;

import java.util.List;
import java.util.Map;

import com.mindtree.propertytaxapp.entity.Description;
import com.mindtree.propertytaxapp.entity.Property;
import com.mindtree.propertytaxapp.entity.Zone;
import com.mindtree.propertytaxapp.exception.PropertyTaxException;


/**
 * @author M1056078
 *
 */
public interface PropertyService {

	List<Zone> getZones() throws PropertyTaxException;

	List<Description> getDescriptions() throws PropertyTaxException;

	void addProperty(Property property) throws PropertyTaxException;

	double caculateTotalPrice(int area, int age) throws PropertyTaxException;

	Map<String,Map<String,Double>> getZoneReport();
	
}
