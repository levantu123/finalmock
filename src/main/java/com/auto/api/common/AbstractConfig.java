package com.auto.api.common;

public abstract class AbstractConfig<O extends Request> {
	abstract public String getPrefix();
	
	abstract public Object getFromRealApi(String originUrl, String link, Object body);
	
	abstract public String getMethod();
	
	abstract public void updateBody(O o , Object body);
	
}
