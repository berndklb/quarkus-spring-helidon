package com.github.berndklb.springexample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.berndklb.springexample.entity.Example;
import com.github.berndklb.springexample.service.CollectorService;


@RestController
public class ExampleResource {
	private final Logger log = LoggerFactory.getLogger(getClass());

	final CollectorService collectorService;
	
	public ExampleResource(CollectorService collectorService) {
		this.collectorService = collectorService;
	}
	
	@GetMapping("/hello")
//    @Produces(value = {MediaType.APPLICATION_JSON})
//	@Consumes(value = {MediaType.APPLICATION_JSON})
    public Example hello() {
    	
    	return collectorService.getExample();
    }
}
