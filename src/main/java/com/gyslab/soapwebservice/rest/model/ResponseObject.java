package com.gyslab.soapwebservice.rest.model;

import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;

public class ResponseObject {
	Sampleservicers sampleservicers;
	
	public ResponseObject() {
		
	}
	
	public ResponseObject(Sampleservicers sampleservicers) {
		this.sampleservicers = sampleservicers;
		
	}
	
	public Sampleservicers getSampleservicers() {
		return sampleservicers;
	}

	public void setSampleservicers(Sampleservicers sampleservicers) {
		this.sampleservicers = sampleservicers;
	}		
}
