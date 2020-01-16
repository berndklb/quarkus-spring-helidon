package com.github.berndklb.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.berndklb.entity.TestRest;


@ApplicationScoped
public class RestClientService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private String restUrl;
	private RestClientInterface client;
	
	@Inject
	public RestClientService(@ConfigProperty(name = "config.service.rest.url") String message,
			RestClientInterface client) {
		this.restUrl = message;
		this.client = client;
	}
	
	public TestRest test(String todoId) {
//		RestClientInterface client = RestClientBuilder.newBuilder()
//				.connectTimeout(5, TimeUnit.SECONDS)
//				.readTimeout(5, TimeUnit.SECONDS)
//				.baseUri(URI.create(restUrl))
//				.build(RestClientInterface.class);
		this.log.info("Calling restservice");
		
		return client.test(todoId);
	}
	
}
