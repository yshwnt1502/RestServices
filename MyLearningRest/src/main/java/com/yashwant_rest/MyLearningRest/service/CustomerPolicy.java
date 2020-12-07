package com.yashwant_rest.MyLearningRest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.yashwant_rest.MyLearningRest.model.Customers;
import com.yashwant_rest.MyLearningRest.model.Policy;

@Component
public class CustomerPolicy {

	private static int counter = 3;
	private static List<Customers> cus = new ArrayList<Customers>();
	private static List<Policy> pol = new ArrayList<Policy>();
	static {
		Policy policy1 = new Policy("Field 1", "Description");
		Policy policy2 = new Policy("Field 2", "Description2");
		Policy policy3 = new Policy("Field 3", "Description3");
		Policy policy4 = new Policy("Field 4", "Description4");
		Policy policy5 = new Policy("Field 5", "Description5");

		Customers yashwant = new Customers(1, "Yashwant Kumar", 1234567890,
				Arrays.asList(policy1, policy2, policy3, policy4, policy5));
		Customers moumi = new Customers(2, "moumi Kumar", 1234567890, Arrays.asList(policy1, policy4, policy5));
		Customers nikki = new Customers(3, "nikki Kumar", 1234567890, Arrays.asList(policy1, policy2, policy3));

		cus.add(yashwant);
		cus.add(moumi);
		cus.add(nikki);
	}

	public List<Customers> getAllUser() {
		return cus;
	}

	public Customers findById(int id) {
		for (Customers customer : cus) {
			if (customer.getiD() == id)
				return customer;
		}
		return null;
	}

	public List<Policy> findPolicyById(int id) {

//		for(Customers customer:cus) {
//			if(customer.getiD()==id) {
		Customers customer = findById(id);
		if (customer == null) {
			return null;

		}
		return customer.getPolicy();

	}

	public Customers addCustomer(Customers customer) {
		if (customer.getiD() == null) {
			customer.setiD(++counter);
		}
		cus.add(customer);
		return customer;

	}

	public Customers deleteCustomer(int id) {
		Iterator<Customers> itr = cus.iterator();
		while (itr.hasNext()) {
			Customers customer = itr.next();
			if (customer.getiD() == id) {
				cus.remove(customer);
				return customer;
			}

		}
		return null;
	}
	
	public List<Policy> policyForCustomer(int id){
		 
			Customers customer = findById(id);
			
//			if(studentId.equalsIgnoreCase("Student1")){
//				throw new RuntimeException("Something went wrong");
//			}

			if (customer == null) {
				return null;
			}

			return customer.getPolicy();
		}

		public Policy retrievePolicy(int id, String name) {
			Customers customer = findById(id);

			if (customer == null) {
				return null;
			}

			for (Policy policy : customer.getPolicy()) {
				if (policy.getPolicyno().equals(name)) {
					return policy;
				}
			}

			return null;
	}

}
