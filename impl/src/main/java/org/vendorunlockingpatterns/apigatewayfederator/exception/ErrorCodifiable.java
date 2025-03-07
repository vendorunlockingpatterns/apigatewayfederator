package org.vendorunlockingpatterns.apigatewayfederator.exception;

public interface ErrorCodifiable {

	public ErrorCodeType getErrorCode();

	public String getExternalMessage();
}
