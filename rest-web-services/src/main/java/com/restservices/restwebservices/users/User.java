package com.restservices.restwebservices.users;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All the details are available.")
public class User {

	@ApiModelProperty(notes="Minimum 2 characters are required")
	@Size(min=2,message="Minimum 2 characters are required")
	private String name;
	private Integer id ;
	
	
	@Past(message="The date should be less than current date")
	@ApiModelProperty(notes="Date should not be in past")
	private Date birthdate;
	public User(String name, Integer id, Date birthdate) {
		super();
		this.name = name;
		this.id = id;
		this.birthdate = birthdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return String.format("User [name=%s, id=%s, birthdate=%s]", name, id, birthdate);
	}
	
	
	
}
