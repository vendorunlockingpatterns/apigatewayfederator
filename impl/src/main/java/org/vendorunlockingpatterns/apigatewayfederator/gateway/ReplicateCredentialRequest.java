package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import java.util.Objects;

import org.vendorunlockingpatterns.apigatewayfederator.utils.CheckUtils;

public interface ReplicateCredentialRequest {

	public String getApplicationId();

	public String getApplicationName();

	public CredentialInfo getCredential();
}
