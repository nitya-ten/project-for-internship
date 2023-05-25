package com.nitya.rest.propertyservice.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitya.rest.propertyservice.entity.Property;
import com.nitya.rest.propertyservice.entity.PropertyData;
import com.nitya.rest.propertyservice.exception.PropertyNotFoundException;
import com.nitya.rest.propertyservice.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepo;

	@Override
	public List<PropertyData> findAllPropertyDetails() {
		List<Property> propertyList = propertyRepo.findAll();
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("");
		}
		List<PropertyData> propertyListData = new ArrayList<>();
		propertyList.stream().forEach(property -> {
			PropertyData propertyData = new PropertyData();
			BeanUtils.copyProperties(property, propertyData);
			propertyListData.add(propertyData);
		});
		return propertyListData;
	}

	@Override
	public List<PropertyData> findPropertyDetailsByUserId(Integer userId) {
		List<Property> propertyDetailsList = propertyRepo.findAllByUserId(userId);

		if (propertyDetailsList.isEmpty()) {
			throw new PropertyNotFoundException("for User Id: " + userId);
		}
		List<PropertyData> propertyListData = new ArrayList<>();
		propertyDetailsList.stream().forEach(property -> {
			PropertyData propertyData = new PropertyData();
			BeanUtils.copyProperties(property, propertyData);
			propertyListData.add(propertyData);
		});
		return propertyListData;
	}

	@Override
	public void deleteAllPropertiesByUserId(Integer userId) {
		List<Property> propertyDetails = propertyRepo.findAllByUserId(userId);

		if (propertyDetails.isEmpty()) {
			throw new PropertyNotFoundException("for User Id: " + userId);
		}
		propertyRepo.deleteAllByUserId(userId);
	}

	@Override
	public ResponseEntity<PropertyData> registerProperty(Integer userId, PropertyData propertyData) {
		propertyData.setUserId(userId);
		Property property = new Property();
		BeanUtils.copyProperties(propertyData, property);
		Property savedProperty = propertyRepo.save(property);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedProperty.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public void deletePropertyById(Integer userId, Integer propertyId) {
		//find if such property exist with propertyId and userId as given
		List<Property> propertyDetails = propertyRepo.findAllByUserId(userId);

		if (propertyDetails.isEmpty()) {
			throw new PropertyNotFoundException("for User Id: " + userId);
		}

		propertyRepo.deleteById(propertyId);
	}
}
