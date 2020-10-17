package com.mindtree.propertytaxapp.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.propertytaxapp.controller.PropertyController;
import com.mindtree.propertytaxapp.controller.PropertyRestController;


/**
 * @author M1056078
 *
 */
@ControllerAdvice(assignableTypes = {PropertyRestController.class,PropertyController.class })
public class GlobalExceptionHandler {
	@Value("${spring.application.name}")
	private String applicationName;

	Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("ApplicationName", applicationName);
		modelAndView.addObject("Status",HttpStatus.NOT_FOUND.value());
		modelAndView.addObject("ErrorMessage", e.getMessage());
		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.setViewName("error");
		logger.trace(e.getMessage());
		
	return modelAndView;
	}
@ExceptionHandler
	public ModelAndView defaultErrorHandler(HttpServletRequest req,PropertyTaxException e)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("ApplicationName", applicationName);
		modelAndView.addObject("Status",HttpStatus.NOT_FOUND.value());
		modelAndView.addObject("ErrorMessage", e.getMessage());
		modelAndView.addObject("url", req.getRequestURI());
		modelAndView.setViewName("error");
		logger.trace(e.getMessage());
	return modelAndView;
	}

}
