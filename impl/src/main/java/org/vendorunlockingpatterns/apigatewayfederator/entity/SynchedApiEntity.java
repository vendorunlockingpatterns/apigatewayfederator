package org.vendorunlockingpatterns.apigatewayfederator.entity;

public abstract class SynchedApiEntity implements AgfEntity<Long> {

	public enum Status {
		DISCOVERED, UPDATED, UNCHANGED, MISSING, UNKNOWN
	}

	public abstract void setId(Long id);

	public abstract SynchEntity getSynch();

	public abstract void setSynch(SynchEntity synch);

	public abstract ApiEntity getApi();

	public abstract void setApi(ApiEntity api);

	public abstract Status getStatus();

	public abstract void setStatus(Status status);
}
