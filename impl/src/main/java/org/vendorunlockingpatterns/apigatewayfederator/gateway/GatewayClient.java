package org.vendorunlockingpatterns.apigatewayfederator.gateway;

import java.util.List;

/**
* The client for accessing API information on the gateway.
*/
public interface GatewayClient {

	/**
	* Initializes the client.
	*
	* @param config the initialization configuration.
	*/
	public void init(String config);

	/**
	* Lists the APIs.
	*
	* @return the APIs.
	*/
	public List<Api> findAllApis();

	/**
	* Creates an application.
	* <p>
	* In the context of the federator, the application represents an entity that can have
	* access to APIs through a credential. Each gateway is responsible for
	* representing the concept of an application in its internal structures. At a minimum,
	* an application must have a name and an identifier, both unique. *
	* @param request the application creation parameters.
	*
	* @return The ID of the created application.
	*/
	public String createApplication(CreateApplicationRequest request);

	/**
	* Creates a credential on the gateway.
	* <p>
	* <b>IMPLEMENTATION NOTE:</b> the implementation of this method must
	* be
	* <a href="https://en.wikipedia.org/wiki/Idempotence">idempotent</a>,
	* meaning that successive calls with the <b>same</b> parameters will have the
	* same results. * <p>
	* For example, after the first invocation of this method to create a
	* credential, other invocations with the <b>same</b> parameters will not result in
	* a new credential or an error about an existing credential, but the
	* already created credential will be returned. Obviously, if the parameters of the
	* credential whose creation was requested are different from the existing
	* credential, an error should be thrown.
	*
	* @param request the parameters for creating the credential.
	* @return the credential data.
	*/
	public CredentialInfo createCredential(CreateCredentialRequest request);

	/**
	* Retrieves a credential.
	*
	* @param request
	* @return the credential or {@code null} if the credential does not exist.
	*/
	public CredentialInfo findCredential(FindCredentialRequest request);

	/**
	* Generates a new secret for the credential, keeping the same clientId.
	*
	* @param request
	* @return the credential with the new secret.
	*/
	public CredentialInfo regenerateClientSecret(RegenerateClientSecretRequest request);

	/**
	* Replicates the credential. If a credential with the same clientId already exists,
	* then it should be overwritten.
	*/
	public void replicateCredential(ReplicateCredentialRequest request);

	/**
	* Deletes the application.
	*
	* @param request
	*/
	public void deleteApplication(DeleteApplicationRequest request);

	/**
	* Subscribes an application to an API. * <p>
	* <b>IMPLEMENTATION NOTE:</b> the implementation of this method must
	* be
	* <a href="https://en.wikipedia.org/wiki/Idempotence">idempotent</a>,
	* meaning that successive calls with the <b>same</b> parameters will have the
	* same results.
	* <p>
	* For example, after the first invocation of this method to create a
	* subscription, further invocations with the <b>same</b> parameters will not result
	* in a new subscription or in an error for an existing subscription.
	*
	* @param request
	*/
	public void createSubscription(CreateSubscriptionRequest request);

	/**
	* Deletes an application's subscription in an API.
	*
	* @param request
	*/
	public void deleteSubscription(DeleteSubscriptionRequest request);

	/**
	* Updates an application's subscription in an API.
	*
	* @param request
	*/
	public void updateSubscription(UpdateSubscriptionRequest request);

	/**
	* Method responsible for validating the Client instance. If the method fails, a specific {@link Exception} must be thrown and handled by whoever is trying to validate the Client instance. The instance check may include several items such as connectivity, response time, etc.
	*/
	public void validate();
}