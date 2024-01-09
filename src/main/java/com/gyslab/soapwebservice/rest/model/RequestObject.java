package com.gyslab.soapwebservice.rest.model;

import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;

public class RequestObject {
	Sampleservicerq sampleservicerq;

	public Sampleservicerq getSampleservicerq() {
		return sampleservicerq;
	}

	public void setSampleservicerq(Sampleservicerq sampleservicerq) {
		this.sampleservicerq = sampleservicerq;
	}
}