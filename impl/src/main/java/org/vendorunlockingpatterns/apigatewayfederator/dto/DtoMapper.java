package org.vendorunlockingpatterns.apigatewayfederator.dto;

import java.util.function.Function;

import org.vendorunlockingpatterns.apigatewayfederator.entity.AgfEntity;

public interface DtoMapper {

	public void init();

	public <D extends AgfDto, E extends AgfEntity<?>> D toDto(E entity, Class<D> dtoClass);

	public <D extends AgfDto, E extends AgfEntity<?>> E toEntity(D dto, Class<E> entityClass);

	public default <D extends AgfDto, E extends AgfEntity<?>> Function<D, E> toEntityMapFunction(
			Class<E> entityClass) {
		return d -> toEntity(d, entityClass);
	}

	public default <D extends AgfDto, E extends AgfEntity<?>> Function<E, D> toDtoMapFunction(Class<D> dtoClass) {
		return e -> toDto(e, dtoClass);
	}
}
