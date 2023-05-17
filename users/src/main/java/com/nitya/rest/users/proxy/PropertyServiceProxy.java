package com.nitya.rest.users.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nitya.rest.users.entity.Property;

import jakarta.validation.Valid;

@FeignClient(name = "property-service", url = "localhost:8083")
public interface PropertyServiceProxy {
	
	@GetMapping(path = "/properties")
	public List<Property> getAllPropertyDetails();

	@PostMapping(path = "/properties")
	public ResponseEntity<Property> addProperty(@Valid @RequestBody Property property);

	@GetMapping(path = "/properties/{userId}")
	public List<Property> getPropertiesByUserId(@PathVariable Integer userId);

	@DeleteMapping(path = "/properties/{userId}")
	public void deleteAllPropertiesByUserId(@PathVariable Integer userId);
	
	@DeleteMapping(path = "/properties/{userId}/{propertyId}")
	public void deleteParticularProperty(@PathVariable Integer userId, @PathVariable Integer propertyId);
}
