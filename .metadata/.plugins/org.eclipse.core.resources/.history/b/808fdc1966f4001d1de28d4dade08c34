package com.nitya.rest.propertyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.rest.propertyservice.entity.Property;
import com.nitya.rest.propertyservice.service.PropertyServiceImpl;

import jakarta.validation.Valid;

@RestController
public class PropertyServiceController {

	@Autowired
	private PropertyServiceImpl propertyServiceImpl;
	
	@GetMapping(path = "/properties")
	public List<Property> getAllPropertyDetails() {
		return propertyServiceImpl.findAllPropertyDetails();
	}

	@PostMapping(path = "/properties")
	public ResponseEntity<Property> addProperty(@Valid @RequestBody Property property) {
		return propertyServiceImpl.registerProperty(property);
	}

	@GetMapping(path = "/properties/{userId}")
	public List<Property> getPropertiesByUserId(@PathVariable Integer userId) {
		return propertyServiceImpl.findPropertyDetailsByUserId(userId);
	}

	@DeleteMapping(path = "/properties/{userId}")
	public void deleteAllPropertiesByUserId(@PathVariable Integer userId) {
		propertyServiceImpl.deleteAllPropertiesByUserId(userId);
	}
	
	@DeleteMapping(path = "/properties/{userId}/{propertyId}")
	public void deleteAllPropertiesByUserId(@PathVariable Integer userId, @PathVariable Integer propertyId) {
		propertyServiceImpl.deletePropertyById(propertyId);
	}
}
