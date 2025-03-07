package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import org.vendorunlockingpatterns.apigatewayfederator.utils.CheckUtils;

public interface CreateSubscriptionRequest {

	public String getApplicationId();

	public String getApplicationName();

	public String getApiId();

	public String getThrottlingTier();
}
