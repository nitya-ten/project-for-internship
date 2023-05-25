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

import com.nitya.rest.propertyservice.entity.PropertyData;
import com.nitya.rest.propertyservice.service.PropertyServiceImpl;

import jakarta.validation.Valid;

@RestController
public class PropertyServiceController {

	@Autowired
	private PropertyServiceImpl propertyServiceImpl;
	
	@GetMapping(path = "/properties")
	public List<PropertyData> getAllPropertyDetails() {
		return propertyServiceImpl.findAllPropertyDetails();
	}

	@PostMapping(path = "/properties/{userId}")
	public ResponseEntity<PropertyData> addProperty(@PathVariable Integer userId, @Valid @RequestBody PropertyData property) {
		return propertyServiceImpl.registerProperty(userId, property);
	}

	@GetMapping(path = "/properties/{userId}")
	public List<PropertyData> getPropertiesByUserId(@PathVariable Integer userId) {
		return propertyServiceImpl.findPropertyDetailsByUserId(userId);
	}

	@DeleteMapping(path = "/properties/{userId}")
	public void deleteAllPropertiesByUserId(@PathVariable Integer userId) {
		propertyServiceImpl.deleteAllPropertiesByUserId(userId);
	}
	
	@DeleteMapping(path = "/properties/{userId}/{propertyId}")
	public void deleteParticularProperty(@PathVariable Integer userId, @PathVariable Integer propertyId) {
		propertyServiceImpl.deletePropertyById(userId, propertyId);
	}
}
