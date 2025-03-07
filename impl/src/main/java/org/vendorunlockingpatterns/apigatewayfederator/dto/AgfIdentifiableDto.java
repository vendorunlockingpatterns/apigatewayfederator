package org.vendorunlockingpatterns.apigatewayfederator.dto;

import java.io.Serializable;

import org.vendorunlockingpatterns.apigatewayfederator.entity.Identifiable;

public interface AgfIdentifiableDto<I extends Serializable> extends AgfDto, Identifiable<I> {

}
