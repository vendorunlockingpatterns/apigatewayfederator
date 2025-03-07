package org.vendorunlockingpatterns.apigatewayfederator.exception;

/**
* Represents a class that declares one or more exception builders
* (usually via static constants) via
* {@link AgfExceptionBuilder}. Classes of this type are only used to group
* errors for use in the application.
* <p>
* The {@link #init()} method must ensure that all {@link ErrorCodeType}
* used by the declared exceptions are properly registered via the
* {@link ErrorCodeRegistry} class during application initialization.
*
*/
public interface ExceptionContainer {

	/**
	* @return The group of errors that this exception container represents.
	*/
	public String getErrorGroup();

	/**
	* Initializes this exception container. This method must ensure that all
	* {@link ErrorCodeType} used by the declared exceptions are properly
	* registered using the {@link ErrorCodeRegistry} class during
	* application startup.
	*/
	public void init();
}
