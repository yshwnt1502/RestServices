package com.yashwant_rest.MyLearningRest.model;

public class Policy {

	private String name;
	private String description;
	
	public Policy(String policyno, String description) {
		super();
		this.name = policyno;
		this.description = description;
	}

	public String getPolicyno() {
		return name;
	}

	public void setPolicyno(String policyno) {
		this.name = policyno;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Policy [name=" + name + ", description=" + description + "]";
	}
	
	
}
