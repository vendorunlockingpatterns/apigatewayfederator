package org.vendorunlockingpatterns.apigatewayfederator.entity;

import java.io.Serializable;

public interface Identifiable<I extends Serializable> {

	public I getId();
}
