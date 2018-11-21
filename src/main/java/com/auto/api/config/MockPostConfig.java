package com.auto.api.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auto.api.common.AbstractConfig;
import com.auto.api.model.MockData;

@Service
public class MockPostConfig extends AbstractConfig<MockData>{

	@Override
	public String getPrefix() {
		return "post";
	}

	@Override
	public Object getFromRealApi(String originUrl, String link, Object body) {
		return new RestTemplate().postForEntity(originUrl+link, body, Object.class).getBody();
	}

	@Override
	public String getMethod() {
		return "POST";
	}
	
	@Override
	public void updateBody(MockData o, Object body) {
		o.setBodyPost(body);
	}

}
