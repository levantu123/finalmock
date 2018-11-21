package com.auto.api.service;

import org.springframework.stereotype.Service;

import com.auto.api.common.AbstractService;
import com.auto.api.config.MockGetConfig;
import com.auto.api.model.MockData;
import com.auto.api.model.OriginConfig;
import com.auto.api.repo.MockDataRepository;
import com.auto.api.repo.OriginConfigRepository;

@Service
public class MockGetService extends AbstractService<MockGetConfig, MockData, MockDataRepository, OriginConfigRepository, OriginConfig> {
}
