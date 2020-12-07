package com.yashwant_rest.MyLearningRest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yashwant_rest.MyLearningRest.Exception.UserNotFoundException;
import com.yashwant_rest.MyLearningRest.model.Customers;
import com.yashwant_rest.MyLearningRest.model.Policy;
import com.yashwant_rest.MyLearningRest.service.CustomerPolicy;

@RestController
public class CustomerController {

	@Autowired
	private CustomerPolicy customerPolicy;

	@GetMapping(value = "/Customers")
	public List<Customers> allCustomers() {
		return customerPolicy.getAllUser();
	}

	@PostMapping("/Customers/Customer")
	public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customer) {
		Customers savedCustomer = customerPolicy.addCustomer(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getiD()).toUri();
		return ResponseEntity.created(location).build();

//		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(SavedUser.getId()).toUri();
//		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "/Customers/{id}")
	public Customers findById(@PathVariable int id) {
		Customers customer = customerPolicy.findById(id);
		if (customer == null) {
			throw new UserNotFoundException("id -" + id);
		}
		return customer;
	}

//	@GetMapping(value="/Customers/id/Policy/name")
//	public List<Customers> customerListForPolicy(@PathVariable String name){

//	}

	@GetMapping(value = "/Customers/{id}/policy")
	public List<Policy> policyForUser(@PathVariable int id) {
		List<Policy> policy = customerPolicy.findPolicyById(id);
		if (policy == null) {
			return null;
		}
		return policy;
	}
	
	@GetMapping(value="/Customers/{id}/policy/{name}")
	public String checkPolicyInfo(@PathVariable int id,String name) {
		Policy policy=customerPolicy.retrievePolicy(id, name);
		if(policy==null) {
			return "No such Policy exists for the user";
		}
		return "Policy Exists";
	}

	@DeleteMapping("/Customers/{id}")
	public Customers deleteById(@PathVariable int id) {
		Customers customer = customerPolicy.deleteCustomer(id);
		if (customer == null) {
			throw new UserNotFoundException("id -" + id);
		}
		return customer;
	}

}
