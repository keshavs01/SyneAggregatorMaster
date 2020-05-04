package com.synechron.insuranceaggregator.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.insuranceaggregator.entity.InsuranceProvider;

@Repository
public interface InsuranceProviderRepo extends JpaRepository<InsuranceProvider, String> {
	
	public List<InsuranceProvider> findByIsActive(Boolean isActive);
	
}
