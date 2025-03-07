package org.vendorunlockingpatterns.apigatewayfederator.exception;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

public class AgfException extends ContextedRuntimeException implements HttpResponseConvertible, ErrorCodifiable {

	private static final long serialVersionUID = -1140110127551076181L;

	private static final String HTTP_RESPONSE_CONTENT_TYPE = "application/json";

	private final ErrorCodeType errorCode;

	private final String externalMessage;

	public AgfException(ErrorCodeType errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.externalMessage = null;
	}

	public AgfException(ErrorCodeType errorCode, String message, String externalMessage) {
		super(message);
		this.errorCode = errorCode;
		this.externalMessage = externalMessage;
	}

	public AgfException(ErrorCodeType errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.externalMessage = null;
	}

	public AgfException(ErrorCodeType errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.externalMessage = null;
	}

	public AgfException(ErrorCodeType errorCode, String message, String externalMessage, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.externalMessage = externalMessage;
	}

	@Override
	public AgfException addContextValue(String label, Object value) {
		return (AgfException) super.addContextValue(label, value);
	}

	@Override
	public String getMessage() {
		return errorCode + ": " + super.getMessage();
	}

	@Override
	public ErrorCodeType getErrorCode() {
		return errorCode;
	}

	@Override
	public String getExternalMessage() {
		return externalMessage;
	}

	@Override
	public String getHttpResponseContentType() {
		return HTTP_RESPONSE_CONTENT_TYPE;
	}

	@Override
	public Response toHttpResponse() {
		return Response.status(errorCode.getMappedHttpStatus())
				.entity(new HttpErrorResponseBody(errorCode, getExternalMessage())).build();
	}

	public static class HttpErrorResponseBody {
		private String errorCode;
		private String errorMessage;

		public HttpErrorResponseBody(ErrorCodeType errorCode, String errorMessage) {
			this.errorCode = errorCode.getCode();
			this.errorMessage = errorMessage;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}
	}
}
