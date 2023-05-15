package com.nitya.rest.users.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nitya.rest.users.entity.Wishlist;

@FeignClient(name = "wishlist-service", url = "localhost:8082")
public interface WishlistServiceProxy {
	
	@DeleteMapping(path = "/wishlist/{userId}")
	public void deleteWishlist(@PathVariable Integer userId);
	
	@GetMapping(path = "/wishlist/{userId}")
	public Wishlist getUserWishlist(@PathVariable Integer userId);
	
	@DeleteMapping(path = "/wishlist")
	public void deleteFromWishlist(@RequestBody Wishlist wishlist);

	@PostMapping(path = "/wishlist")
	public ResponseEntity<Wishlist> addToWishlist(@RequestBody Wishlist wishlist);
}
