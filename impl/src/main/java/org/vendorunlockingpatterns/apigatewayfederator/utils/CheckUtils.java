package org.vendorunlockingpatterns.apigatewayfederator.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.collections4.CollectionUtils;

public class CheckUtils {

	private CheckUtils() {
		throw new AssertionError("Instamces of the class " + this.getClass() + " are not allowed");
	}

	public static boolean isNullOrEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?, ?> m) {
		return m == null || m.isEmpty();
	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public static boolean isNullOrBlank(String s) {
		return s == null || s.trim().isEmpty();
	}

	public static String requireNotNullOrBlank(String s) {
		return requireNotNullOrBlank(s, "Null or blank string");
	}

	public static String requireNotNullOrBlank(String s, String msg) {
		return requireNotNullOrBlank(s, msg, IllegalArgumentException::new);
	}

	public static String requireNotNullOrBlank(String s, String msg,
			Function<String, ? extends RuntimeException> exFactory) {
		if (isNullOrBlank(s)) {
			throw exFactory.apply(msg);
		}
		return s;
	}

	public static <T> Collection<T> requireNotNullOrEmpty(Collection<T> c) {
		return requireNotNullOrEmpty(c, "Null or empty collection");
	}

	public static <T> Collection<T> requireNotNullOrEmpty(Collection<T> c, String msg) {
		return requireNotNullOrEmpty(c, msg, IllegalArgumentException::new);
	}

	public static <T> Collection<T> requireNotNullOrEmpty(Collection<T> c, String msg,
			Function<String, ? extends RuntimeException> exFactory) {
		if (isNullOrEmpty(c)) {
			throw exFactory.apply(msg);
		}
		return c;
	}

	/**
	 * Use {@link CollectionUtils#isEqualCollection(Collection, Collection)} with
	 * support to null parameters.
	 * 
	 * @see CollectionUtils#isEqualCollection(Collection, Collection)
	 */
	public static boolean isEqualCollection(final Collection<?> a, final Collection<?> b) {
		return (a == b) || (a != null && b != null && CollectionUtils.isEqualCollection(a, b));
	}

	public static <T> T getOrDefaultIfNull(T value, T defaultValue) {
		return Objects.nonNull(value) ? value : defaultValue;
	}

	public static boolean sameSize(final Collection<?> a, final Collection<?> b) {
		return CollectionUtils.size(a) == CollectionUtils.size(b);
	}

	public static boolean allNull(Object... args) {
		return allArgsHaveCondition(Objects::isNull, true, args);
	}

	public static boolean allNonNull(Object... args) {
		return allArgsHaveCondition(Objects::nonNull, false, args);
	}

	public static boolean allArgsHaveCondition(Predicate<Object> condition, boolean nullArgsResult, Object... args) {
		if (args == null) {
			return nullArgsResult;
		} else {
			for (Object v : args) {
				if (!condition.test(v)) {
					return false;
				}
			}
			return true;
		}
	}
}
