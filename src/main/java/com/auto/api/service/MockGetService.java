package com.auto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.api.common.AbstractService;
import com.auto.api.config.MockGetConfig;
import com.auto.api.model.MockData;
import com.auto.api.repo.MockDataRepository;

@Service
public class MockGetService extends AbstractService<MockGetConfig<MockData>, MockData, MockDataRepository> {
	
	@Autowired
	MockGetConfig<MockData> mockGetConfig;
	@Autowired
	public void setMockGetConfig(MockGetConfig<MockData> mockGetConfig) {
		this.mockGetConfig = mockGetConfig;
		super.setServiceConfig(mockGetConfig);
	}
}
