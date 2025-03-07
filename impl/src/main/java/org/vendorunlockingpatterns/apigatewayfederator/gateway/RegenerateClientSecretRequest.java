package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import java.util.Objects;

import org.vendorunlockingpatterns.apigatewayfederator.utils.CheckUtils;

public interface RegenerateClientSecretRequest {

	public String getApplicationId();

	public CredentialInfo getCredential();
}
