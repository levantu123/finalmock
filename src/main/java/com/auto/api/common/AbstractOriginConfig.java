package com.auto.api.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public abstract class AbstractOriginConfig {
	
	@Id
	private String id;
	
	private String originUrl;
	
	private boolean originLoad;
	
	private boolean originSave;
	
	@Indexed
	private String prefixUseV1;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public boolean isOriginLoad() {
		return originLoad;
	}

	public void setOriginLoad(boolean originLoad) {
		this.originLoad = originLoad;
	}

	public boolean isOriginSave() {
		return originSave;
	}

	public void setOriginSave(boolean originSave) {
		this.originSave = originSave;
	}

	public String getPrefixUseV1() {
		return prefixUseV1;
	}

	public void setPrefixUseV1(String prefixUseV1) {
		this.prefixUseV1 = prefixUseV1;
	}
}
