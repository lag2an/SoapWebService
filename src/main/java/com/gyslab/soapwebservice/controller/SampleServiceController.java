package com.gyslab.soapwebservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gyslab.soapwebservice.config.rest.model.RequestObject;
import com.gyslab.soapwebservice.config.rest.model.ResponseObject;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;

@RestController
public class SampleServiceController {
	
	@PostMapping(path = "/external/services/rest/sample-service")
	public ResponseObject sampleService(@RequestBody RequestObject req) {
		
		Sampleservicerq sampleservicerq = req.getSampleservicerq();
		
		Sampleservicers rs = new Sampleservicers();
		
		rs.setTrxId(sampleservicerq.getTrxId());
		rs.setErrorCode("0000");
		rs.setErrorMsg("Success");
		
		return new ResponseObject(rs);
		
	}
	
	

}
