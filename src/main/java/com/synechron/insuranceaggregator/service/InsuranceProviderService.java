package com.synechron.insuranceaggregator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synechron.insuranceaggregator.entity.InsuranceProvider;
import com.synechron.insuranceaggregator.entity.Policy;
import com.synechron.insuranceaggregator.exceptions.CustomException;
import com.synechron.insuranceaggregator.repos.InsuranceProviderRepo;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Service
public class InsuranceProviderService {

	@Autowired
	private InsuranceProviderRepo repo;

	@Autowired
	private RestTemplate template;

	public InsuranceProvider registerInsuranceProvider(InsuranceProvider provider) {
		repo.save(provider);
		return provider;
	}

	public List<Policy> getPoliciesData() {
		List<InsuranceProvider> companies = repo.findByIsActive(true);
		List<Policy> policiesList = new ArrayList<Policy>();
		ObjectMapper mapper = new ObjectMapper();
		for (InsuranceProvider insuranceProvider : companies) {
			List<Object> respObject = (List<Object>) template.getForObject(insuranceProvider.getUrl(), Object.class);
			Policy policy = new Policy();

			for (Object response : respObject) {
				try {
					String responseValue = mapper.writeValueAsString(response);
					policy = mapper.readValue(responseValue, Policy.class);
					policiesList.add(policy);
				} catch (JsonProcessingException e) {
					throw new CustomException("Error occured while parsing data");
				}
			}

		}
		return policiesList;

	}
	
	
//	
//	public List<Policy> getPoliciesData() {
//		List<InsuranceProvider> companies = repo.findByIsActive(true);
//		List<Policy> policiesList = new ArrayList<Policy>();
//		for (InsuranceProvider insuranceProvider : companies) {
//			String resp = template.getForObject(insuranceProvider.getUrl(), String.class);
//			JSONArray policiesArray = new JSONArray();
//			JSONParser parser = new JSONParser();			
//			try {
//
//				policiesArray = (JSONArray) parser.parse(resp);
//				JSONObject schemaFormat = (JSONObject) parser.parse(insuranceProvider.getSchemaFormat());
//
//				for (int i = 0; i < policiesArray.size(); i++) {
//					JSONObject policyObj = (JSONObject) policiesArray.get(i);
//					Policy policy = new Policy();
//					policy.setPolicyId(policyObj.getAsString(schemaFormat.getAsString("policyId")));
//					policy.setPolicyName(policyObj.getAsString(schemaFormat.getAsString("policyName")));
//					policy.setPolicDesc(policyObj.getAsString(schemaFormat.getAsString("policyDesc")));
//					policy.setPremiumAmount(policyObj.getAsString(schemaFormat.getAsString("premiumAmount")));
//					policiesList.add(policy);
//					System.out.println(policy.toString());
//				}
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			System.out.println(policiesList.toString());
//
//		}
//		return policiesList;
//
//	}

}
