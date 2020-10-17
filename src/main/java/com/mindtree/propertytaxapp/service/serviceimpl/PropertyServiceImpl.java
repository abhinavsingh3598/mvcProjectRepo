package com.mindtree.propertytaxapp.service.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.propertytaxapp.entity.Description;
import com.mindtree.propertytaxapp.entity.Property;
import com.mindtree.propertytaxapp.entity.Zone;
import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.repository.DescriptionRepository;
import com.mindtree.propertytaxapp.repository.PropertyRepository;
import com.mindtree.propertytaxapp.repository.ZoneRepository;
import com.mindtree.propertytaxapp.service.PropertyService;


/**
 * @author M1056078
 *
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	DescriptionRepository descriptionRepository;

	@Autowired
	ZoneRepository zoneRepository;
	
	Logger logger=LoggerFactory.getLogger(PropertyServiceImpl.class);

	/* TransactionalManagement For Zone is Used In ZoneRepository.java */
	@Override
	public List<Zone> getZones() throws PropertyTaxException {

		if(zoneRepository.getAllZones().isEmpty())
		{
			logger.info("zones are empty while getting Zones");  
			throw new PropertyTaxException("zones are empty");
		}
		return zoneRepository.getAllZones().stream().collect(Collectors.toList());
	}
	
	

	/* TransactionalManagement For Description is Used In DescriptionRepository.java */
	@Override
	public List<Description> getDescriptions() throws PropertyTaxException {
		
		if(descriptionRepository.getAllDescriptions().isEmpty())
		{
			logger.info("descriptions are empty while getting description"); 
			throw new PropertyTaxException("descriptions are empty");
		}
			
		return descriptionRepository.getAllDescriptions().stream().collect(Collectors.toList());
		

	}

	/* Loger is setUp in the GlobalExceptionHandler.java for these Exceptions */
	@Override
	public void addProperty(Property property) throws PropertyTaxException {

		if (null == property)
		{
			logger.info("property is null while saving property in databases"); 
			throw new PropertyTaxException("error while saving property details");
		}
			propertyRepository.save(property);

	}

	@Override
	public double caculateTotalPrice(int area, int age) throws PropertyTaxException {
		
		if(area <=0)
		{
			throw new PropertyTaxException("area is not valid");
		}
		if(age<=0)
		{
			throw new PropertyTaxException("error in age calculation");
		}
		
		float unitAreaValue = 10.00f;
		double total1 = area * unitAreaValue * 10;
		double total2;
		double propertyTax = total1*0.001;
		double healthCess = total1 * 0.005;
		double beggaryCess = total1 * 0.001;
		double libraryCess = total1 * 0.002;
		double cess = healthCess + beggaryCess + libraryCess;
		if (age >= 60)
			total2 = total1 - total1 * (0.60);
		else {
			total2 = total1 - total1 * (age * 0.01);
		}

		double total3 = total2 * (propertyTax * (0.20));
		double total4 = total3 * (cess * (0.24));
		double total5 = total3 + total4;
		return total5;
	}

	@Override
	public Map<String, Map<String, Double>> getZoneReport() {
		Map<String, Map<String, Double>> report = new HashMap<>();
		Map<String, Double> propertyTypeCollection = null;
		double valueOwner;
		double valueTenated;
		for (Zone zone : zoneRepository.findAll()) {
			valueOwner = 0;
			valueTenated = 0;
			propertyTypeCollection = new HashMap<>();
			for (Property property : propertyRepository.findAll()) {
				if (property.getPropertyZone().getZoneName().equalsIgnoreCase(zone.getZoneName())) {
					if (property.getPropertyStatus().equalsIgnoreCase("Owner")) {
						valueOwner += property.getPropertyTotalPayableTaxAmount();

					} else if (property.getPropertyStatus().equalsIgnoreCase("Tenated")) {
						valueTenated += property.getPropertyTotalPayableTaxAmount();

					}
				}

			}
			propertyTypeCollection.put("Tenated", valueTenated);
			propertyTypeCollection.put("Owner", valueOwner);
			report.put(zone.getZoneName(), propertyTypeCollection);

		}

		return report;
	}

}
