package com.auto.api.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auto.api.common.AbstractConfig;
import com.auto.api.common.Request;
import com.auto.api.model.MockData;

@Service
public class MockGetConfig extends AbstractConfig<MockData>{

	public String getPrefix() {
		return "get";
	}

	public Object getFromRealApi(String originUrl, String link, Object body) {
		return new RestTemplate().getForEntity(originUrl+link, Object.class).getBody();
	}

	public String getMethod() {
		return "GET";
	}
	
	public void updateBody(MockData o, Object body) {
		o.setBodyGet(body);
	}

}
