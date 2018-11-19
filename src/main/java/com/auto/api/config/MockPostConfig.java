package com.auto.api.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auto.api.common.AbstractConfig;
import com.auto.api.common.Request;

@Service
public class MockPostConfig<O extends Request> extends AbstractConfig<O>{

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
	public void updateBody(O o, Object body) {
		o.setBodyPost(body);
	}

}
