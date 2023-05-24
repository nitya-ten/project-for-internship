package com.nitya.rest.propertyservice.bean;

public class Property {

	private Integer id;
	private String title;
	private String address;
	private String description;
	private Integer userId;
	
	public Property() {
		
	}
	
	public Property(Integer id, String title, String address, String description, Integer userId) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.description = description;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", title=" + title + ", address=" + address + ", description=" + description
				+ ", userId=" + userId + "]";
	}
	
	
}
