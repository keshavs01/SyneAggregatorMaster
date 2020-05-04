package com.synechron.insuranceaggregator.policiesData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class PolicyData {
	
	@Autowired
	private RestTemplate template;
	
	public String getAllPolicies() {
		String resp = template.getForObject("http://localhost:2020/api/v1/policy/", String.class);
		return resp;
		
	}

}
