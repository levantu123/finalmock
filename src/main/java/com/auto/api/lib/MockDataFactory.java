package com.auto.api.lib;

import org.springframework.stereotype.Service;

import com.auto.api.common.AbstractFactory;
import com.auto.api.model.MockData;

@Service
public class MockDataFactory implements AbstractFactory<MockData> {

	@Override
	public MockData initObj(String id, Object body, String link, String method) {
		MockData request = new MockData();
		request.setRequestId(id);
		
		if(method.equals("GET")) {
			request.setBodyGet(body);
		}
		if(method.equals("POST")) {
			request.setBodyPost(body);
		}
		
		request.setLink(link);
		return request;
	}

	@Override
	public Object getBodyFromMethod(MockData o, String method) {
		if(method.equals("GET")) {
			return o.getBodyGet();
		}
		if(method.equals("POST")) {
			return o.getBodyPost();
		}
		return null;
	}
}
