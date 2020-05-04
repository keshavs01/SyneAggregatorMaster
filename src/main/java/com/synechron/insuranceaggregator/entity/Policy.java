package com.synechron.insuranceaggregator.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Policy {

	@JsonProperty("policyId")
	@JsonAlias({ "id", "policyNum" })
	private String policyId;

	@JsonProperty("policyName")
	@JsonAlias({ "name", "policyName" })
	private String policyName;

	@JsonProperty("policyDesc")
	@JsonAlias("description")
	private String policDesc;

	@JsonProperty("premiumAmount")
	@JsonAlias({ "premiumAmount", "premiumYearly" })
	private String premiumAmount;

	@JsonProperty("sumAssured")
	@JsonAlias({ "premiumAmount", "cover" })
	private String sumAssured;

	@JsonProperty("validFrom")
	@JsonAlias("validFrom")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validFrom;

	@JsonProperty("validTo")
	@JsonAlias("validTo")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validTo;

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicDesc() {
		return policDesc;
	}

	public void setPolicDesc(String policDesc) {
		this.policDesc = policDesc;
	}

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(String sumAssured) {
		this.sumAssured = sumAssured;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policDesc=" + policDesc
				+ ", premiumAmount=" + premiumAmount + "]";
	}

}
