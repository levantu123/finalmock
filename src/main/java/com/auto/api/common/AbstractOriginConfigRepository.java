package com.auto.api.common;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AbstractOriginConfigRepository<O extends AbstractOriginConfig> extends MongoRepository<O, String>{
	List<O> findByPrefixUseV1(String prefixUseV1);
}