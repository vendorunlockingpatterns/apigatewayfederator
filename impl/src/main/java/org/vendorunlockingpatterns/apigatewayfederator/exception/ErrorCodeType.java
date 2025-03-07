package org.vendorunlockingpatterns.apigatewayfederator.exception;

import javax.ws.rs.core.Response;

public interface ErrorCodeType extends Comparable<ErrorCodeType> {

	public String getCode();

	public Response.StatusType getMappedHttpStatus();
}
