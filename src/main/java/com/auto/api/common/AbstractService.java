package com.auto.api.common;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.auto.api.lib.TextAnalyzer;

public abstract class AbstractService<M extends AbstractConfig<O>, O extends Request, A extends AbstractRepository<O>, R extends AbstractOriginConfigRepository<S>, S extends AbstractOriginConfig> {
	@Autowired
	A repository;

	@Autowired
	TextAnalyzer textAnalyzer;

	@Autowired
	private R originRepo;

	@Autowired
	M serviceConfig;

	@Autowired
	AbstractFactory<O> factory;

	public Object handleGet(String prefix, String path, Map<String, String[]> para, Object body) {
		List<S> cockConfigsList = originRepo.findByPrefixUseV1(prefix);
		S cockConfigs = null;
		if(!cockConfigsList.isEmpty()) {
			cockConfigs = cockConfigsList.get(0);
		}else {
			return null;
		}
		String url = textAnalyzer.buildUrl(path, para);
		String link = textAnalyzer.removePrefixUrl(url, "v1");
		String id = textAnalyzer.buildId(link);

		link = textAnalyzer.removePrefixUrl(link, prefix);
		Optional<O> request = repository.findById(id);
		if (cockConfigs.isOriginLoad() && cockConfigs.isOriginSave() && !request.isPresent()) {
			Object map = serviceConfig.getFromRealApi(cockConfigs.getOriginUrl(), link, body);
			O o = factory.initObj(id, map, link, serviceConfig.getMethod());
			repository.save(o);
			return map;
		}

		if (cockConfigs.isOriginLoad() && cockConfigs.isOriginSave() && request.isPresent()) {
			Object map = serviceConfig.getFromRealApi(cockConfigs.getOriginUrl(), link, body);
			O o = repository.findById(id).get();
			serviceConfig.updateBody(o, map);
			repository.save(o);
			return map;
		}

		if (cockConfigs.isOriginLoad()) {
			return new RestTemplate().getForEntity(cockConfigs.getOriginUrl() + link, Object.class).getBody();
		}

		if (request.isPresent()) {
			return factory.getBodyFromMethod(request.get(), serviceConfig.getMethod());
		}

		return null;
	}

	public Object handlePost(String path, Map<String, String[]> para, Object body, String prefix) {
		List<S> cockConfigsList = originRepo.findByPrefixUseV1(prefix);
		@SuppressWarnings("unused")
		S cockConfigs = null;
		if(!cockConfigsList.isEmpty()) {
			cockConfigs = cockConfigsList.get(0);
		}else {
			return null;
		}
		String url = textAnalyzer.buildUrl(path, para);
		String link = textAnalyzer.removePrefixUrl(url, serviceConfig.getPrefix());
		String id = textAnalyzer.buildId(link);

		if (repository.findById(id).isPresent()) {
			O o = repository.findById(id).get();
			if (factory.getBodyFromMethod(o, serviceConfig.getMethod()) != null) {
				return o;
			}
			serviceConfig.updateBody(o, body);
			return repository.save(o);
		}

		O o = factory.initObj(id, body, link, serviceConfig.getMethod());
		return repository.save(o);
	}

	public Object handlePut(String path, Map<String, String[]> para, Object body, String prefix) {
		List<S> cockConfigsList = originRepo.findByPrefixUseV1(prefix);
		@SuppressWarnings("unused")
		S cockConfigs = null;
		if(!cockConfigsList.isEmpty()) {
			cockConfigs = cockConfigsList.get(0);
		}else {
			return null;
		}
		String url = textAnalyzer.buildUrl(path, para);
		String link = textAnalyzer.removePrefixUrl(url, serviceConfig.getPrefix());
		String id = textAnalyzer.buildId(link);

		if (repository.findById(id).isPresent()) {
			O o = repository.findById(id).get();
			serviceConfig.updateBody(o, body);
			return repository.save(o);
		}
		return null;
	}
}
