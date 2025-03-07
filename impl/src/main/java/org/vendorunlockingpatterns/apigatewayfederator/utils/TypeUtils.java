package org.vendorunlockingpatterns.apigatewayfederator.utils;

import static org.vendorunlockingpatterns.apigatewayfederator.utils.CastUtils.cast;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;

public class TypeUtils {

	private TypeUtils() {
		// No instances
	}

	public static Predicate<Type> isTypeClassAssignableFrom(Class<?> clazz) {
		return t -> (t instanceof Class<?> && clazz.isAssignableFrom(cast(t)));
	}

	public static <T> Class<T> getActualTypeArgumentClass(Class<?> classWithTypeArgs, Predicate<Type> match) {
		for (Type type : getActualTypeArguments(classWithTypeArgs)) {
			if (match.test(type)) {
				return cast(type);
			}
		}
		return null;
	}

	public static Type[] getActualTypeArguments(Class<?> clazz) {
		if (clazz != null) {
			Type t = clazz.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				return ((ParameterizedType) t).getActualTypeArguments();
			} else if (t instanceof Class) { // Provavelmente uma classe proxy (weld ou hibernate)
				return getActualTypeArguments(cast(t));
			}
		}
		return new Type[0];
	}

	public static Class<?> unproxifyClass(Class<?> clazz, List<String> proxyMarkers) {
		return isProxyClass(clazz, proxyMarkers) ? cast(clazz.getGenericSuperclass()) : clazz;
	}

	public static boolean isProxyClass(Class<?> clazz, List<String> proxyMarkers) {
		return proxyMarkers.stream().anyMatch(m -> clazz.getName().contains(m));
	}
}
