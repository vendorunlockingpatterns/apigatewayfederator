package org.vendorunlockingpatterns.apigatewayfederator.entity;

import java.util.Set;

public interface GatewayEntity extends AgfEntity<String> {

	public String getId();

	public void setId(String id);

	public String getName();

	public void setName(String name);

	public String getVendor();

	public void setVendor(String vendor);

	public String getVersion();

	public void setVersion(String version);

	public Set<GatewayAdminEntity> getAdmins();

	public void setAdmins(Set<GatewayAdminEntity> admins);

	public String getGatewayClientClass();

	public void setGatewayClientClass(String gatewayClientClass);

	public String getGatewayClientConfig();

	public void setGatewayClientConfig(String gatewayClientConfig);

	public boolean isKeyManager();

	public void setKeyManager(boolean keyManager);
}