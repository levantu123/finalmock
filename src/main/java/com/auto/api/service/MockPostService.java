package com.auto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.api.common.AbstractService;
import com.auto.api.config.MockPostConfig;
import com.auto.api.model.MockData;
import com.auto.api.repo.MockDataRepository;

@Service
public class MockPostService extends AbstractService<MockPostConfig<MockData>, MockData, MockDataRepository> {
	
	@Autowired
	MockPostConfig<MockData> mockPostConfig;
	
	@Autowired
	public void setMockGetConfig(MockPostConfig<MockData> mockPostConfig) {
		this.mockPostConfig = mockPostConfig;
		super.setServiceConfig(mockPostConfig);
	}
}
