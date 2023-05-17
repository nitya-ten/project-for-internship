package com.nitya.rest.users.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer userId;
	
	private List<Integer> propertyIds;
	
	public Wishlist() {}

	public Wishlist(Integer userId, List<Integer> propertyId) {
		super();
		this.userId = userId;
		this.propertyIds = propertyId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getPropertyIds() {
		return propertyIds;
	}

	public void setPropertyIds(List<Integer> propertyId) {
		this.propertyIds = propertyId;
	}

	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", userId=" + userId + ", propertyIds=" + propertyIds + "]";
	}

}
