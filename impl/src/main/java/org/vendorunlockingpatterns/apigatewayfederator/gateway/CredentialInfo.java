package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import java.util.List;

/**
* Contains the information that an OAuth2 client needs to access an API.
*/
public interface CredentialInfo {

	/**
	* @return the client identifier of the credential.
	*/
	public String getClientId();

	/**
	* @return the secret of the credential.
	*/
	public String getClientSecret();

	/**
	* @return the list of grant types supported by the credential.
	*/
	public List<String> getGrantTypes();

	/**
	* @return the list of scopes for which tokens generated from this
	* credential are valid.
	*/
	public List<String> getScopes();

	/**
	* @return the duration (in seconds) of the tokens generated from this
	* credential.
	*/
	public Integer getTokenDuration();
}