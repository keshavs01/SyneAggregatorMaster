package com.synechron.insuranceaggregator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_provider")
public class InsuranceProvider {
	
	@Id
	@Column(name = "provider_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String providerId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "response_type")
	private String responseType;
	
	@Column(name = "schema_format")
	private String schemaFormat;
	
	@Column(name = "is_active")
	private Boolean isActive;
	

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getSchemaFormat() {
		return schemaFormat;
	}

	public void setSchemaFormat(String schemaFormat) {
		this.schemaFormat = schemaFormat;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
