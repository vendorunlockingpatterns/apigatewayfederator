package org.vendorunlockingpatterns.apigatewayfederator.controller;

import java.io.Serializable;

import org.vendorunlockingpatterns.apigatewayfederator.dao.AgfDao;
import org.vendorunlockingpatterns.apigatewayfederator.dto.AgfDto;
import org.vendorunlockingpatterns.apigatewayfederator.dto.AgfIdentifiableDto;
import org.vendorunlockingpatterns.apigatewayfederator.dto.AgfUpdateDto;
import org.vendorunlockingpatterns.apigatewayfederator.entity.AgfEntity;
import org.vendorunlockingpatterns.apigatewayfederator.pagination.PagedResult;

public interface AgfCrudController<I extends Serializable, E extends AgfEntity<I>> {

	public AgfDao<I, E> getDao();

	public <D extends AgfDto> Class<D> getDefaultEntityDtoClass();

	public <D extends AgfDto> Class<D> getDefaultEntityListItemDtoClass();

	public <D extends AgfDto> D getEntity(I id);

	public <D extends AgfDto> D getEntity(I id, Class<D> dtoClass);

	public <D extends AgfDto> PagedResult<D> findAllEntities();

	public <D extends AgfDto> PagedResult<D> findAllEntities(Class<D> dtoClass);

	public AgfIdentifiableDto<I> createEntity(AgfDto dto);

	/**
	 * Update the entity identified by {@link AgfUpdateDto#getId()}. Only the
	 * properties of the entity which have the same name of the properties of the
	 * informed {@code dto} will be updated.
	 * 
	 * @param dto
	 */
	public void updateEntity(AgfUpdateDto<I> dto);

	public void deleteEntity(I id);

}