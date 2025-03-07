package org.vendorunlockingpatterns.apigatewayfederator.gateway;

public enum ApiSubscriptionStatus {
	ENABLED, ENABLED_TEMP, DISABLED_PERM, DISABLED_TEMP, UNKNOWN;

	public boolean isSubscriptionAllowed() {
		switch (this) {
		case ENABLED:
		case ENABLED_TEMP:
			return true;
		default:
			return false;
		}
	}
}
