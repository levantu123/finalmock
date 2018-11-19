package com.auto.api.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auto.api.common.AbstractConfig;
import com.auto.api.common.Request;

@Service
public class MockGetConfig<O extends Request> extends AbstractConfig<O>{

	@Override
	public String getPrefix() {
		return "get";
	}

	@Override
	public Object getFromRealApi(String originUrl, String link, Object body) {
		return new RestTemplate().getForEntity(originUrl+link, Object.class).getBody();
	}

	@Override
	public String getMethod() {
		return "GET";
	}
	
	@Override
	public void updateBody(O o, Object body) {
		o.setBodyGet(body);
	}

}
