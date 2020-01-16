package com.github.berndklb.service;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.berndklb.entity.TestRest;


@ApplicationScoped
public class RestClientService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@ConfigProperty(name = "config.service.rest.url") 
	String restUrl;
	
	public TestRest test(String todoId) {
		Client client = ResteasyClientBuilder.newBuilder()
				.connectTimeout(5, TimeUnit.SECONDS)
				.readTimeout(5, TimeUnit.SECONDS)
				.build();
			WebTarget webTarget = client.target(restUrl)
				.path("todos")
				.path(todoId);
			
			this.log.debug("Fetching URL {}", webTarget.getUri().toString());

			Builder request = webTarget.request(MediaType.APPLICATION_JSON);
			try (Response response = request.get();){

				this.log.debug("Response of URL {} was {}", webTarget.getUri().toString(), response.getStatusInfo());
				if (response.getStatusInfo() != Status.OK && response.getStatusInfo() != Status.ACCEPTED) {
					this.log.error("Loading of test rest url with id {} failed! The response code was {}",
							todoId, response.getStatusInfo());
				}
				return request.get(TestRest.class);
				
			} catch(javax.ws.rs.ProcessingException e) {
				this.log.error("Loading of the test rest url with id {} failed! The response was {}",
						todoId, e.getMessage());
				return new TestRest();
			} finally {
				if(client != null) {
					client.close();
				}
			}
	}
	
}
