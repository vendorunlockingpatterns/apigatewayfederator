package org.vendorunlockingpatterns.apigatewayfederator.entity;

import java.util.Date;
import java.util.List;

public abstract class SynchEntity implements AgfEntity<String> {

	public enum Status {
		STARTED, COMPLETED, CANCELED, FAILED
	}

	public enum Type {
		FULL, GATEWAY, API
	}

	public abstract String getId();

	public abstract void setId(String id);

	public abstract Type getSynchType();

	public abstract void setSynchType(Type synchType);

	public abstract Date getStartedAt();

	public abstract void setStartedAt(Date startedAt);

	public abstract Date getFinishedAt();

	public abstract void setFinishedAt(Date finishedAt);

	public abstract Status getStatus();

	public abstract void setStatus(Status status);

	public abstract List<SynchedApiEntity> getSynchedApis();

	public abstract void setSynchedApis(List<SynchedApiEntity> synchedApis);
}
