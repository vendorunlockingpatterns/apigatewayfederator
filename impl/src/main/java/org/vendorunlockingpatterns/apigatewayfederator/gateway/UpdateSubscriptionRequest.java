package org.vendorunlockingpatterns.apigatewayfederator.gateway;

public interface UpdateSubscriptionRequest {

	public String getApplicationId();

	public String getApiId();

	public boolean isSubscriptionEnabled();
}
