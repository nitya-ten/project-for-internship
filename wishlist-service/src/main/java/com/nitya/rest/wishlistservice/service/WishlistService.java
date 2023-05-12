package com.nitya.rest.wishlistservice.service;

import org.springframework.http.ResponseEntity;

import com.nitya.rest.wishlistservice.entity.Wishlist;

public interface WishlistService {
	
	public Wishlist getWishlistById(Integer userId);
	
	public ResponseEntity<Wishlist> addItemToWishlist(Wishlist wishlist);
	
	public void deleteItemFromWishlist(Wishlist wishlist);
	
	public void deleteWishlistById(Integer userId);
}
