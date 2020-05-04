package com.synechron.insuranceaggregator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.insuranceaggregator.entity.InsuranceProvider;
import com.synechron.insuranceaggregator.entity.Policy;
import com.synechron.insuranceaggregator.service.InsuranceProviderService;

@RestController
public class AggregatorController {
	
	@Autowired
	private InsuranceProviderService service;
	
	@PutMapping("/register")
	public ResponseEntity<String> regsiter(@RequestBody InsuranceProvider provider){
		service.registerInsuranceProvider(provider);
		return new ResponseEntity<>("Company registered successfully", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/policy")
	public List<Policy> getPolicies(){
		return service.getPoliciesData();	
	}
	
	@GetMapping(path = "/policy/filter/{prop}/{value}")
	public List<Policy> paginate(@PathVariable("prop") String prop, @PathVariable("value") double value) {
		return service.getPoliciesData();
	}

}
