package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.http.HttpTransport;

public interface TokenRequestFactory {

	TokenRequest newTokenRequest(HttpTransport httpTransport);
}
