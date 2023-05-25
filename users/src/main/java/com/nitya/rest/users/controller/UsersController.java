package com.nitya.rest.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitya.rest.users.entity.PropertyData;
import com.nitya.rest.users.entity.UserData;
import com.nitya.rest.users.proxy.PropertyServiceProxy;
import com.nitya.rest.users.proxy.WishlistServiceProxy;
import com.nitya.rest.users.service.UsersServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UsersController {

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@Autowired
	private WishlistServiceProxy wishlistProxy;
	
	@Autowired
	private PropertyServiceProxy propertyProxy;

	@GetMapping(path = "/users")
	public List<UserData> getAllUserDetails() {
		return usersServiceImpl.findAllUserDetails();
	}
	
	@GetMapping(path = "/users/{id}")
	public UserData getUserDetails(@PathVariable Integer id) {
		return usersServiceImpl.findUserDetailsById(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<?> registerNewUser(@Valid @RequestBody UserData userData) {
		return usersServiceImpl.registerUser(userData);
	}

	//dependency on wishlist-service indirectly
	@DeleteMapping(path = "/users/{id}")
	public void deRegisterUser(@PathVariable Integer id) {
		usersServiceImpl.deleteUserDetailsById(id);
	}
	
	//dependency on wishlist-service directly
	@GetMapping(path = "/users/{id}/wishlist")
	public List<Integer> getWishlist(@PathVariable Integer id) {
		return wishlistProxy.getUserWishlist(id);
	}
	
	@PostMapping(path = "users/{id}/wishlist")
	public void addItemsToWishlist(@PathVariable Integer id, @RequestBody Integer propertyId) {
		wishlistProxy.addToWishlist(id, propertyId);
	}
	
	@DeleteMapping(path = "users/{id}/wishlist")
	public void deleteItemsFromWishlist(@PathVariable Integer id, @RequestBody Integer propertyId) {
		wishlistProxy.deleteFromWishlist(id, propertyId);
	}
	
	//dependency on property-service
	@GetMapping(path = "/properties")
	public List<PropertyData> getAllPropertyDetails() {
		return propertyProxy.getAllPropertyDetails();
	}
}
