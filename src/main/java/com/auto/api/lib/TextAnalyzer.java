package com.auto.api.lib;

import java.util.Map;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TextAnalyzer {
	public String buildUrl( String host, Map<String, String[]> para) {
		String url  = host;
		if(para.size()>0) {
			url+="?";
			int i = 0;
			for(String key: para.keySet()) {
				url += key+"=" + StringUtils.join(para.get(key));
				i++;
				if(i != para.size()) {
					url += "&";
				}
			}
		}
		return url;
	}
	
	public String removePrefixUrl( String host, String prefix) {
		return host.replaceFirst("/"+prefix, "");
	}
	
	public String buildId(String link) {
		String id = link.replace("/", "-SLASH-CODE-");
		id = id.replace(" ", "-SPACE-CODE-");
		id = id.replace("?", "-QUESTION-CODE-");
		return id;
	}
}
