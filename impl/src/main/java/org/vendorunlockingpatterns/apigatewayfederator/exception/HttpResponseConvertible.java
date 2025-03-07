package org.vendorunlockingpatterns.apigatewayfederator.exception;

import javax.ws.rs.core.Response;

public interface HttpResponseConvertible {

	public Response toHttpResponse();

	public String getHttpResponseContentType();
}
