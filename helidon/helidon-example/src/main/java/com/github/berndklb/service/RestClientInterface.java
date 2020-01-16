package com.github.berndklb.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.github.berndklb.entity.TestRest;

@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com/")
public interface RestClientInterface {

	TestRest test(String todoId); 
}
