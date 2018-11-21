package com.auto.api.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.auto.api.service.MockPostService;

@RestController
@RequestMapping(value="/post")
public class MockPostController {
	
	@Autowired
	MockPostService mockPostService;
	
	@PostMapping(value = "/{prefix}/**")
	public Object create(
	  @PathVariable String prefix, HttpServletRequest request, @RequestBody Object body) { 
		
		String restOfTheUrl = (String) request.getAttribute(
			    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		Map<String, String[]> para = request.getParameterMap();
	    return mockPostService.handlePost(restOfTheUrl, para, body, prefix);
	}
	
	@PutMapping(value = "/{prefix}/**")
	public Object edit(
	  @PathVariable String prefix, HttpServletRequest request, @RequestBody Object body) { 
		
		String restOfTheUrl = (String) request.getAttribute(
			    HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		Map<String, String[]> para = request.getParameterMap();
	    return mockPostService.handlePut(restOfTheUrl, para, body, prefix);
	}
	

}


