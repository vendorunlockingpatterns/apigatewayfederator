package org.vendorunlockingpatterns.apigatewayfederator.utils;

public class CastUtils {

	private CastUtils() {
		// Sem instâncias
	}

	@SuppressWarnings("unchecked")
	public static <T, F> T cast(F from) {
		return (T) from;
	}
}
