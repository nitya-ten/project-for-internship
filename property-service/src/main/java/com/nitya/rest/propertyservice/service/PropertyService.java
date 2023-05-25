package com.nitya.rest.propertyservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nitya.rest.propertyservice.entity.PropertyData;


public interface PropertyService {
	
	public List<PropertyData> findAllPropertyDetails();
	
	public List<PropertyData> findPropertyDetailsByUserId(Integer userId);
	
	public void deleteAllPropertiesByUserId(Integer userId);
	
	public ResponseEntity<PropertyData> registerProperty(Integer userId, PropertyData propertyData);
	
	public void deletePropertyById(Integer userId, Integer propertyId);
}
