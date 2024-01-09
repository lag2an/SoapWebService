package com.gyslab.soapwebservice.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.gyslab.soapwebservice.rest.model.RequestObject;
import com.gyslab.soapwebservice.rest.model.ResponseObject;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;

@Endpoint
public class SoapServiceEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.oracle.com/external/services/sampleservice/request/v1.0";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sampleservicerq")
	@ResponsePayload
	public Sampleservicers endpoint(@RequestPayload Sampleservicerq request, MessageContext messageContext) {
		
		RequestObject req = new RequestObject();
		req.setSampleservicerq(request);
		
		return createSnakeTypeRestTemplate().exchange("http://localhost:8080/external/services/rest/sample-service"
				, HttpMethod.POST, new HttpEntity<>(req), ResponseObject.class).getBody().getSampleservicers();
	}
	
	RestTemplate createSnakeTypeRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
	       List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	       MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
	       jsonMessageConverter.setObjectMapper(
	    		   new ObjectMapper().setPropertyNamingStrategy(
	    				   PropertyNamingStrategies.SNAKE_CASE
	    		   )
	      );
	       messageConverters.add(jsonMessageConverter);
	       restTemplate.setMessageConverters(messageConverters); 
	       
	       return restTemplate;
	}

}
