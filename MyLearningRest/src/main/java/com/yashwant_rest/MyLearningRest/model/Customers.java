package com.yashwant_rest.MyLearningRest.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customers {

	
	private Integer iD;
	@Size(min=3,message="The value must be greater than 3 chraters")
	private String name;
	
	@Size(min=10, message="The phone number should be greater than 10 digits")
	private long phoneNo;
	
	private List<Policy> Policy;

	public Customers(Integer iD, String name, long phoneNo, List<com.yashwant_rest.MyLearningRest.model.Policy> policy) {
		super();
		this.iD = iD;
		this.name = name;
		this.phoneNo = phoneNo;
		Policy = policy;
	}

	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Policy> getPolicy() {
		return Policy;
	}

	public void setPolicy(List<Policy> policy) {
		Policy = policy;
	}

	@Override
	public String toString() {
		return "Cusomers [iD=" + iD + ", name=" + name + ", phoneNo=" + phoneNo + ", Policy=" + Policy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iD;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		if (iD != other.iD)
			return false;
		return true;
	}
	

}
