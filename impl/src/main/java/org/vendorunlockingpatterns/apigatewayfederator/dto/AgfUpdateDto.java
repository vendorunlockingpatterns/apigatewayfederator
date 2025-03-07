package org.vendorunlockingpatterns.apigatewayfederator.dto;

import java.io.Serializable;

public interface AgfUpdateDto<I extends Serializable> extends AgfIdentifiableDto<I> {

	public void setUpdatedEntityId(I id);
}
