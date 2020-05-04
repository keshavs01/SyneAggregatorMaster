package com.synechron.insuranceaggregator;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.synechron.insuranceaggregator.policiesData.PolicyData;

@SpringBootApplication
public class InsuranceAggregatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(InsuranceAggregatorApplication.class, args);
		PolicyData policyData = ctx.getBean(PolicyData.class);
		System.out.println("************************");
//		System.out.println(policyData.getAllPolicies());
	}

}
