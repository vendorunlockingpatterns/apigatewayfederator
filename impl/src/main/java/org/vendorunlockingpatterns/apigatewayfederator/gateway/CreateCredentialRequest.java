package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import java.util.Collections;
import java.util.List;

import org.vendorunlockingpatterns.apigatewayfederator.utils.CheckUtils;

public interface CreateCredentialRequest {

	public String getApplicationId();

	public String getApplicationName();

	public List<String> getGrantTypes();

	public List<String> getScopes();

	public Integer getTokenDuration();
}

