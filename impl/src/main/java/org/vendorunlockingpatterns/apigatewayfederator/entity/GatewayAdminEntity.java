package org.vendorunlockingpatterns.apigatewayfederator.entity;

import java.util.Set;

public interface GatewayAdminEntity extends AgfEntity<Long> {

	public Long getId();

	public void setId(Long id);

	public String getCpf();

	public void setCpf(String cpf);

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public Set<GatewayEntity> getGateways();

	public void setGateways(Set<GatewayEntity> gateways);
}
