package com.tgr.fwk.repository;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tgr.fwk.exception.NoDataFoundException;

public abstract class AbstractRepository<ENTITY, METAMODEL> {

	protected abstract EntityManager getEntityManager();
	
	private Class<ENTITY> type;
	
	@SuppressWarnings("unchecked")
	protected Class<ENTITY> getEntityClass() {
		if (type == null) {
			type = (Class<ENTITY>) this.getGenericsSuperClass(this.getClass(), AbstractRepository.class, 0);
		}
		return type;
	}
	
	public Class<?> getGenericsSuperClass(Class<?> oClazz, Class<?> superClass, int position) {
		while (!superClass.isAssignableFrom(oClazz.getSuperclass()) && null != oClazz.getSuperclass()) {
			oClazz = oClazz.getSuperclass();
		}
		
		Class<?> clazz = null;
		Type genericSuperclass = oClazz.getGenericSuperclass();
		if (genericSuperclass instanceof ParameterizedType) {
			ParameterizedType type = (ParameterizedType) genericSuperclass;
			Type[] types = type.getActualTypeArguments();
			if (types != null && types.length > position) {
				try {
					Object t = types[position];

					if (t instanceof ParameterizedType) {
						clazz = (Class<?>) ((ParameterizedType) t).getRawType();
					} else if (t instanceof GenericArrayType) {
						clazz = ((Class<?>) ((GenericArrayType) t).getGenericComponentType());
						clazz = Array.newInstance(clazz, 0).getClass();

					} else {
						clazz = (Class<?>) types[position];
					}
				} catch (Throwable t) {
					
				}
			}
		}

		return clazz;
	}
	
	public ENTITY loadById(Long id) throws NoDataFoundException {
		ENTITY entity = getEntityManager().find(getEntityClass(), id);
		if (entity == null) {
			throw new NoDataFoundException("No data found for class [" + getEntityClass().getSimpleName() + "] and identifier [" + id + "]");
		}
		return entity;
	}
	
	public ENTITY insert(ENTITY entity) {
		commonTrigger(entity);
		getEntityManager().persist(entity);
		return entity;
	}
	
	public ENTITY update(ENTITY entity) {
		commonTrigger(entity);
		return getEntityManager().merge(entity);
	}
	
	public void delete(ENTITY entity) {
		getEntityManager().remove(entity);
	}
	
	public void commonTrigger(ENTITY entity) {
		
	}
	
	@SuppressWarnings("unchecked")
	protected JPAQuery<ENTITY> buildQuery(METAMODEL metamodel) {
		JPAQueryFactory factory = new JPAQueryFactory(getEntityManager());
		return factory.selectFrom((EntityPath<ENTITY>) metamodel);
	}
}
