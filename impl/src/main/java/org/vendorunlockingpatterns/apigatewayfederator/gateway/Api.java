package org.vendorunlockingpatterns.apigatewayfederator.gateway;

/**
* The API managed by a gateway.
*/
public interface Api {

	/**
	* @return the API identifier on the gateway.
	*/
	public String getId();

	/**
	* @return the API name.
	*/
	public String getName();

	/**
	* @return the API version.
	*/
	public String getVersion();

	/**
	* @return the API subscription status.
	*/
	public ApiSubscriptionStatus getSubscriptionStatus();

	/**
	* @return the API access status.
	*/
	public ApiAccessStatus getAccessStatus();

	/**
	* @return The traffic control options that can be selected when subscribing to the API. */
	public String[] getThrottlingTiers();
}