package org.vendorunlockingpatterns.apigatewayfederator.dao;

import java.io.Serializable;
import java.util.List;

import org.vendorunlockingpatterns.apigatewayfederator.entity.Identifiable;
import org.vendorunlockingpatterns.apigatewayfederator.entity.AgfEntity;
import org.vendorunlockingpatterns.apigatewayfederator.pagination.PagedResult;

public interface AgfDao<I extends Serializable, E extends AgfEntity<I>> {

	Class<E> getEntityClass();

	E persist(E entity);

	/**
	 * Persists the entity whether and only whether there is no another entity identified by
	 * value of {@link Identifiable#getId()} in the base. Case the value of
	 * {@link Identifiable#getId()} of this entity is equals to {@code null}, so the
	 * entity will be persisted without any additional checks.
	 * <p>
	 * <b>IMPLEMENTATION NOTE:</b> implementations of this method must document the
	 * adherence to the specified behavior in high concurrency environments.
	 * 
	 * @param entity
	 * @return {@code true} case the entity has been persisted, {@code false}
	 *         otherwise.
	 */
	boolean persistIfNotExists(E entity);

	E merge(E entity);

	void remove(E entity);

	void removeById(I id);

	E getEntity(I id);

	E find(I id);

	PagedResult<E> find();
	
	List<E> unpagedFind();

	/**
	 * Update the entity identified by {@link Identifiable#getId()} with the value
	 * of the properties of {@code updated}.
	 * <p>
	 * <b>ATTENTION:</b> To be updated the property {@code updated} must have
	 * the same name of the entity property.
	 * 
	 * @param updated
	 * @return The updated entity
	 */
	E update(Identifiable<I> updated);

}