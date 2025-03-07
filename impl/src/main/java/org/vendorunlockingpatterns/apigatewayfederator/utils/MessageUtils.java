package org.vendorunlockingpatterns.apigatewayfederator.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import org.vendorunlockingpatterns.apigatewayfederator.entity.ApiEntity;
import org.vendorunlockingpatterns.apigatewayfederator.entity.GatewayEntity;
import org.vendorunlockingpatterns.apigatewayfederator.entity.SynchEntity;
import org.vendorunlockingpatterns.apigatewayfederator.gateway.Api;

public class MessageUtils {

	private static final String START_DELIMITER = "{";
	private static final String END_DELIMITER = "}";
	private static final String VALUE_SEPARATOR = "=";
	private static final String FIELD_SEPARATOR = ", ";

	private static final String TWO_FIELDS_FORMAT = START_DELIMITER + "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR
			+ "{}" + VALUE_SEPARATOR + "{}" + END_DELIMITER;

	private static final String THREE_FIELDS_FORMAT = START_DELIMITER + "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR
			+ "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR + "{}" + VALUE_SEPARATOR + "{}" + END_DELIMITER;

	private static final String FOUR_FIELDS_FORMAT = START_DELIMITER + "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR
			+ "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR + "{}" + VALUE_SEPARATOR + "{}" + FIELD_SEPARATOR + "{}"
			+ VALUE_SEPARATOR + "{}" + END_DELIMITER;

	private MessageUtils() {
		// None instances must be created
	}

	public static String formatSynch(SynchEntity synch) {
		return format(TWO_FIELDS_FORMAT, "id", synch.getId(), "type", synch.getSynchType());
	}

	public static String formatGateway(GatewayEntity gateway) {
		return format(TWO_FIELDS_FORMAT, "id", gateway.getId(), "name", gateway.getName());
	}

	public static String formatApi(Api api) {
		return format(THREE_FIELDS_FORMAT, "id", api.getId(), "name", api.getName(), "version", api.getVersion());
	}

	public static String formatApi(ApiEntity api) {
		return format(FOUR_FIELDS_FORMAT, "id", api.getId(), "name", api.getName(), "version", api.getVersion(),
				"externalId", api.getExternalId());
	}

	public static String formatCredentialParams(List<String> grantTypes, List<String> scopes, Integer tokenDuration) {
		return format(THREE_FIELDS_FORMAT, "grantTypes", collectionToString(grantTypes), "scopes",
				collectionToString(scopes), "tokenDuration", tokenDuration);
	}

	public static String format(String pattern, Object... args) {
		FormattingTuple t = MessageFormatter.arrayFormat(pattern, args);
		return t.getMessage();
	}

	public static <T> String collectionToString(Collection<T> c) {
		return collectionToString(c, Object::toString);
	}

	public static <T> String collectionToString(Collection<T> c, Function<T, String> elementStringMapper) {
		return String.format("[%s]", CheckUtils.isNullOrEmpty(c) ? ""
				: c.stream().map(elementStringMapper).collect(Collectors.joining(", ")));
	}
}
