package org.vendorunlockingpatterns.apigatewayfederator.exception;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.vendorunlockingpatterns.apigatewayfederator.rest.HttpStatus;

@Startup
@Singleton
public class SystemExceptions extends SingletonBeanExceptionContainer {

	private static final String SYS_ERROR_EXTERNAL_MSG = "Unexpected internal error";

	public static final String ERROR_GROUP = "SYS";

	public static final AgfExceptionBuilder NOT_IMPLEMENTED = new AgfExceptionBuilder(
			new ErrorCodeImpl(1000, HttpStatus.NOT_IMPLEMENTED), "Functionality or operation not implemented: {}");

	public static final AgfExceptionBuilder ERROR_CODE_NOT_FOUND = new AgfExceptionBuilder(
			new ErrorCodeImpl(1001, Status.BAD_REQUEST), "Error code not found: {}");

	public static final AgfExceptionBuilder TX_BEGIN_ERROR = new AgfExceptionBuilder(new ErrorCodeImpl(1002),
			"Error starting transaction", SYS_ERROR_EXTERNAL_MSG);

	public static final AgfExceptionBuilder TX_COMMIT_ERROR = new AgfExceptionBuilder(new ErrorCodeImpl(1003),
			"Error confirming transaction", SYS_ERROR_EXTERNAL_MSG);

	public static final AgfExceptionBuilder TX_ROLLBACK_ERROR = new AgfExceptionBuilder(new ErrorCodeImpl(1004),
			"Error undoing transaction", SYS_ERROR_EXTERNAL_MSG);

	public static final AgfExceptionBuilder GATEWAY_CLIENT_BUILD_ERROR = new AgfExceptionBuilder(
			new ErrorCodeImpl(1005), "Error building gateway client");

	public static final AgfExceptionBuilder CREDENTIAL_NOT_FOUND_IN_GATEWAY = new AgfExceptionBuilder(
			new ErrorCodeImpl(1006), "Credential registered in the federator, but not found in the gateway. " + ""
					+ "Contact the administrator of the gateway hosting the given API");

	public static final AgfExceptionBuilder METHOD_PRE_CONDITION_FAILED = new AgfExceptionBuilder(
			new ErrorCodeImpl(1007, Status.INTERNAL_SERVER_ERROR), "Precondition for method execution not met",
			SYS_ERROR_EXTERNAL_MSG);

	public static final AgfExceptionBuilder NOT_SUPPORTED = new AgfExceptionBuilder(
			new ErrorCodeImpl(9998, Status.INTERNAL_SERVER_ERROR), "Unsupported functionality or operation: {}");

	public static final AgfExceptionBuilder INTERNAL_ERROR = new AgfExceptionBuilder(new ErrorCodeImpl(9999),
			SYS_ERROR_EXTERNAL_MSG);

	public static class ErrorCodeImpl extends ErrorCode {

		public ErrorCodeImpl(int sequence) {
			this(sequence, Status.INTERNAL_SERVER_ERROR);
		}

		public ErrorCodeImpl(int sequence, StatusType status) {
			super(ERROR_GROUP, sequence, status);
		}
	}

	private PostConstructCallback callback;

	@Override
	public String getErrorGroup() {
		return ERROR_GROUP;
	}

	@PostConstruct
	public void onPostConstruct() {
		callback.execute();
	}

	@Override
	protected void setPostConstructCallback(PostConstructCallback callback) {
		this.callback = callback;
	}

}
