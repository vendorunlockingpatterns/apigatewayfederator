package org.vendorunlockingpatterns.apigatewayfederator.entity;

import java.util.Date;

import org.vendorunlockingpatterns.apigatewayfederator.gateway.ApiAccessStatus;
import org.vendorunlockingpatterns.apigatewayfederator.gateway.ApiSubscriptionStatus;

public interface ApiEntity extends AgfEntity<String> {

	public String getId();

	public void setId(String id);

	public String getExternalId();

	public void setExternalId(String externalId);

	public String getName();

	public void setName(String name);

	public String getVersion();

	public void setVersion(String version);

	public ApiSubscriptionStatus getSubscriptionStatus();

	public void setSubscriptionStatus(ApiSubscriptionStatus subscriptionStatus);

	public ApiAccessStatus getAccessStatus();

	public void setAccessStatus(ApiAccessStatus accessStatus);

	public String[] getThrottlingTiers();

	public void setThrottlingTiers(String[] throttlingTiers);

	public Date getDiscoveredAt();

	public void setDiscoveredAt(Date discoveredAt);

	public Date getSynchronizedAt();

	public void setSynchronizedAt(Date synchronizedAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public GatewayEntity getGateway();

	public void setGateway(GatewayEntity gateway);

	public int hashCode();

	public boolean equals(Object obj);
}
