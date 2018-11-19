package com.auto.api.common;

public interface AbstractFactory<O> {
	public abstract O initObj(String id, Object body, String link, String method);
	
	public abstract Object getBodyFromMethod(O o, String method);
}
