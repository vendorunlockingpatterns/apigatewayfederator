package org.vendorunlockingpatterns.apigatewayfederator.rest;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public enum HttpStatus implements StatusType {

	NOT_IMPLEMENTED(501, "Not Implemented", Status.Family.SERVER_ERROR);

	int statusCode;
	Family family;
	String reason;

	HttpStatus(int statusCode, String reason, Family family) {
		this.statusCode = statusCode;
		this.reason = reason;
		this.family = family;
	}

	@Override
	public int getStatusCode() {
		return statusCode;
	}

	@Override
	public Family getFamily() {
		return family;
	}

	@Override
	public String getReasonPhrase() {
		return reason;
	}

}
