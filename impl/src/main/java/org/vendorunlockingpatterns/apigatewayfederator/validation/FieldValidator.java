package org.vendorunlockingpatterns.apigatewayfederator.validation;

import org.vendorunlockingpatterns.apigatewayfederator.exception.AgfExceptionBuilder;

public interface FieldValidator<T> {

	public void validate(String fieldName, T fieldValue);

	public void validate(String fieldName, T fieldValue, AgfExceptionBuilder exBuilder);

}