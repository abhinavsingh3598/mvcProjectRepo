package com.mindtree.propertytaxapp.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.propertytaxapp.entity.Property;
import com.mindtree.propertytaxapp.exception.PropertyTaxException;
import com.mindtree.propertytaxapp.service.PropertyService;



/**
 * @author M1056078
 *
 */
@Controller

public class PropertyController {

	@Autowired
	PropertyService propertyService;

	
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}

	
	@RequestMapping("/addproperty")
	public String addProperty( @Valid Property property,Model model,BindingResult br) throws PropertyTaxException {
		String valid="validData";
		if(br.hasErrors())  
        { 
			valid=null;
			model.addAttribute("valid", valid);
            return "form";  
            
        }  
		

		model.addAttribute("valid", valid);
		propertyService.addProperty(property);
		return "home";
	}

	
	@RequestMapping("/cancel")
	public String cancelButton() {
		return "home";
	}

	
	@RequestMapping("/form")
	public String populateValues(Model model) throws PropertyTaxException {
		model.addAttribute("zoneList", propertyService.getZones());
		model.addAttribute("descList", propertyService.getDescriptions());
		return "form";
	}

	
	@RequestMapping("/report")
	public String report(Model model) throws PropertyTaxException {
		Map<String, Map<String, Double>> report = propertyService.getZoneReport();
		model.addAttribute("report", report);
		model.addAttribute("zoneList", propertyService.getZones());
		return "report";
	}
}
