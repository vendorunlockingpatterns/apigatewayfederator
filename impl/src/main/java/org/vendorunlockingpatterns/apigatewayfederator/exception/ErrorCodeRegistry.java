package org.vendorunlockingpatterns.apigatewayfederator.exception;

import static org.vendorunlockingpatterns.apigatewayfederator.utils.MessageUtils.format;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ErrorCodeRegistry {

	public static final String DUPLICATED_ERROR_CODE_MSG = "Error code already used: {}";

	private static final Map<String, ErrorCodeType> REGISTRY = new ConcurrentHashMap<>();

	public static void registerErrorCode(ErrorCodeType errorCode) {
		REGISTRY.compute(errorCode.getCode(), (k, v) -> register(k, v, errorCode));
	}

	public static List<ErrorCodeType> getErrorCodes() {
		return REGISTRY.values().stream().sorted().collect(Collectors.toList());
	}

	public static ErrorCodeType getErrorCode(String code) {
		if (REGISTRY.containsKey(code)) {
			return REGISTRY.get(code);
		} else {
			throw SystemExceptions.ERROR_CODE_NOT_FOUND.newExceptionWithMsgArgs(code);
		}
	}

	private static ErrorCodeType register(String key, ErrorCodeType currentValue, ErrorCodeType newValue) {
		if (currentValue == null) {
			return newValue;
		} else {
			throw new IllegalArgumentException(format(DUPLICATED_ERROR_CODE_MSG, currentValue));
		}
	}

	private ErrorCodeRegistry() {
		// Sem instâncias
	}
}
