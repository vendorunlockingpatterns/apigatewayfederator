package org.vendorunlockingpatterns.apigatewayfederator.rest;

import java.io.Serializable;

import org.vendorunlockingpatterns.apigatewayfederator.controller.AgfCrudController;
import org.vendorunlockingpatterns.apigatewayfederator.dto.AgfUpdateDto;
import org.vendorunlockingpatterns.apigatewayfederator.entity.AgfEntity;

public interface AgfCrudRest<I extends Serializable, E extends AgfEntity<I>> {

	public AgfCrudController<I, E> getController();

	public void updateEntity(I id, AgfUpdateDto<I> dto);
}