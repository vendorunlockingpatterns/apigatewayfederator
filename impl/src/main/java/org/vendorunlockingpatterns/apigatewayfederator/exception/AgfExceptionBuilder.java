package org.vendorunlockingpatterns.apigatewayfederator.exception;

import static org.vendorunlockingpatterns.apigatewayfederator.exception.ErrorCodeRegistry.registerErrorCode;
import static org.vendorunlockingpatterns.apigatewayfederator.utils.MessageUtils.format;

public class AgfExceptionBuilder {

	private final ErrorCodeType errorCode;

	private final String message;

	private final String externalMessage;

	/**
	* Creates a {@link AgfException} with the {@code errorCode} and {@code message}
	* provided. This method sets the external message to the same value as the
	* {@code message} parameter.
	* <p>
	* The {@link ErrorCodeType} provided will be registered using the
	* {@link ErrorCodeRegistry} class, which will throw an error if the code has already been
	* registered.
	* <p>
	* To set a custom value for the external message, use the
	* {@link AgfExceptionBuilder#AgfExceptionBuilder(ErrorCodeType, String, String)}
	*
	* @param errorCode
	* @param message
	* @throws IllegalArgumentException if the {@code errorCode} already exists in the
	* error code registry maintained by the
	* {@link ErrorCodeRegistry} class.
	*/
	public AgfExceptionBuilder(ErrorCodeType errorCode, String message) {
		this(errorCode, message, message);
	}

	public AgfExceptionBuilder(ErrorCodeType errorCode, String message, String externalMessage) {
		registerErrorCode(errorCode);
		this.errorCode = errorCode;
		this.message = message;
		this.externalMessage = externalMessage;
	}

	public AgfException newException() {
		return new AgfException(errorCode, message, externalMessage);
	}

	public AgfException newException(Throwable cause) {
		return new AgfException(errorCode, message, externalMessage, cause);
	}

	public AgfException newExceptionWithMsgArgs(Object... args) {
		return new AgfException(errorCode, format(message, args), format(externalMessage, args));
	}

	public AgfException newExceptionWithMsgArgs(Throwable cause, Object... args) {
		return new AgfException(errorCode, format(message, args), format(externalMessage, args), cause);
	}

	public boolean buildsInstancesOf(AgfException e) {
		return errorCode.equals(e.getErrorCode());
	}

	public ErrorCodeType getErrorCode() {
		return errorCode;
	}
}
