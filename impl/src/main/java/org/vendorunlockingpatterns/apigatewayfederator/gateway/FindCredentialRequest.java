package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import org.vendorunlockingpatterns.apigatewayfederator.utils.CheckUtils;

public interface FindCredentialRequest {

	public String getApplicationId();

	public String getClientId();
}
