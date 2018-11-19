package com.auto.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.auto.api.common.Request;

@Document(collection="MockData")
public class MockData extends Request{

}
