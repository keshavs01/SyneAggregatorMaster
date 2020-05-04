package com.synechron.insuranceaggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.synechron.insuranceaggregator.entity.Policy;
import com.synechron.insuranceaggregator.policiesData.PolicyData;

@Configuration
public class AggregatorConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public PolicyData policyData() {
		return new PolicyData();
	}
		
	@Bean
	@Scope("prototype")
	public Policy policy() {
		return new Policy();
	}

}
