package com.nitya.rest.wishlistservice.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "user_table")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, message = "Size of name should be minimum 2")
	private String name;
	
	@CreationTimestamp
	private LocalDate registeredOn;
	
	private Integer wishlistId;
	
	private String role;
	
	protected User() {
		
	}
	
	public User(@Size(min = 2, message = "Size of name should be minimum 2") String name, LocalDate registeredOn,
			Integer wishlistId, String role) {
		super();
		this.name = name;
		this.registeredOn = registeredOn;
		this.wishlistId = wishlistId;
		this.role = role;
	}

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getRegisteredOn() {
		return registeredOn;
	}
	public void setRegisteredOn(LocalDate registeredOn) {
		this.registeredOn = registeredOn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", registeredOn=" + registeredOn + ", wishlistId=" + wishlistId
				+ ", role=" + role + "]";
	}


}
