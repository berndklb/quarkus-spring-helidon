package com.github.berndklb;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.berndklb.entity.Example;
import com.github.berndklb.service.CollectorService;

@Path("/hello")
public class ExampleResource {
	private final Logger log = LoggerFactory.getLogger(getClass());

	final CollectorService collectorService;
	
	public ExampleResource(CollectorService collectorService) {
		this.collectorService = collectorService;
	}
	
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_JSON})
    public Example hello() {
    	
    	return collectorService.getExample();
    }
}