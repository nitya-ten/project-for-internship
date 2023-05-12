package com.nitya.rest.users.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitya.rest.users.entity.User;
import com.nitya.rest.users.exception.UserNotFoundException;
import com.nitya.rest.users.proxy.WishlistServiceProxy;
import com.nitya.rest.users.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WishlistServiceProxy wishlistProxy;
	
	@Override
	public List<User> findAllUserDetails() {
		return userRepo.findAll();
	}
	
	@Override
	public User findUserDetailsById(Integer id) {
		Optional<User> userDetails = userRepo.findById(id);
		
		if(userDetails.isEmpty()){
			throw new UserNotFoundException(""+id);
		}
		return userDetails.get();
	}
	
	@Override
	public void deleteUserDetailsById(Integer id) {
		Optional<User> userDetails = userRepo.findById(id);
		
		if(userDetails.isEmpty()){
			throw new UserNotFoundException(""+id);
		}
		wishlistProxy.deleteWishlist(userDetails.get().getId());
		userRepo.deleteById(id);
	}
	
	@Override
	public ResponseEntity<User> registerUser(User user) {
		User savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
