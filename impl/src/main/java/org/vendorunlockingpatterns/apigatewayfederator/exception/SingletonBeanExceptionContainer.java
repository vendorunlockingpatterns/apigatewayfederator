package org.vendorunlockingpatterns.apigatewayfederator.exception;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.vendorunlockingpatterns.apigatewayfederator.utils.AgfLogger;
import org.vendorunlockingpatterns.apigatewayfederator.utils.AgfLoggerFactory;

/**
* A {@link ExceptionContainer} whose implementations must be
* annotated with {@link Singleton} and {@link Startup} in order to guarantee the
* initialization of all {@link AgfExceptionBuilder}'s declared as
* static constants at application startup time.
* <p>
* <b>IMPLEMENTATION NOTE</b>
* <p>
* According to the {@link ExceptionContainer} interface documentation, exception
* containers must guarantee the recording of error codes used
* <b>during application startup</b>. However, when declaring
* {@link AgfExceptionBuilder}'s as static constants, the default is
* "lazy" initialization: static members are only initialized by the
* JVM when they or the class that contains them is referenced (in addition to other
* circumstances not mentioned).
*
* <p>
* This creates a problem in ensuring that error codes are logged
* during application startup, since startup itself does not
* reference exception container classes, nor their members, until an
* error occurs. Thus, a "slightly" more elegant way to ensure (or
* force) this reference is to mark the container class as a singleton
* bean that is invoked at startup, that is, a class that contains both
* the {@link Singleton} and {@link Startup} annotations.
*
*/
public abstract class SingletonBeanExceptionContainer implements ExceptionContainer {

	protected AgfLogger logger = AgfLoggerFactory.getLogger(this.getClass());

	public SingletonBeanExceptionContainer() {
		setPostConstructCallback(this::init);
	}

	@Override
	public final void init() {
		logger.info("{} for error group '{}' initialized", ExceptionContainer.class.getSimpleName(),
				getErrorGroup());
	}

	/**
	* Defines the callback to be invoked by the method marked with the
	* {@link PostConstruct} annotation.
	*
	* @param callback The callback that must be invoked by the method
	* marked with the {@link PostConstruct} annotation.
	*/
	protected abstract void setPostConstructCallback(PostConstructCallback callback);

	public static interface PostConstructCallback {
		public void execute();
	}
}
