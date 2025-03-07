package org.vendorunlockingpatterns.apigatewayfederator.exception;

import java.util.Objects;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

public class ErrorCode implements ErrorCodeType {

	public static final String PREFIX = "AGF";

	protected final String code;

	protected final Response.StatusType httpStatus;

	public ErrorCode(String group, int sequence, Response.StatusType httpStatus) {
		Objects.requireNonNull(group);
		Objects.requireNonNull(httpStatus);
		this.httpStatus = httpStatus;
		this.code = PREFIX + "-" + group + "-" + sequence;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public StatusType getMappedHttpStatus() {
		return httpStatus;
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return code.equals(((ErrorCode) obj).code);
	}

	@Override
	public int compareTo(ErrorCodeType anotherCode) {
		return code.compareTo(anotherCode.getCode());
	}

	@Override
	public String toString() {
		return getCode();
	}
}
