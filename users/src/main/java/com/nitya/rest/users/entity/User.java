package com.nitya.rest.users.entity;

import java.time.LocalDateTime;

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
	private LocalDateTime registeredOn;

	private String role;

	public User() {

	}

	public User(@Size(min = 2, message = "Size of name should be minimum 2") String name, LocalDateTime registeredOn,
			String role) {
		super();
		this.name = name;
		this.registeredOn = registeredOn;
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

	public LocalDateTime getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(LocalDateTime registeredOn) {
		this.registeredOn = registeredOn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", registeredOn=" + registeredOn + ", role=" + role + "]";
	}

}
