package com.github.berndklb.springexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.berndklb.springexample.entity.TestRest;



@Service
public class RestClientService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Value("${config.service.rest.url}")
	String restUrl;
	
	public TestRest test(String todoId) {
		
		RestTemplate restClient = new RestTemplate();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restUrl)
				.pathSegment("todos")
				.pathSegment(todoId);
		String url = builder.build().toUriString();
		
		ResponseEntity<TestRest> response = restClient.getForEntity(url, TestRest.class);

		if (response.getStatusCode() != HttpStatus.OK && response.getStatusCode() != HttpStatus.ACCEPTED) {
			String errorMsg = String.format("Loading of test rest url with id {} failed! The response code was {}",
			todoId, response.getStatusCode());
			log.error(errorMsg);
			return new TestRest();
		}
		return response.getBody();
	}
	
}
