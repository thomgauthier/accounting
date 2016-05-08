package com.tgr.fwk.repository;

import com.tgr.fwk.exception.NoDataFoundException;

public interface Repository<ENTITY> {
	ENTITY loadById(Long id) throws NoDataFoundException;

	ENTITY insert(ENTITY entity);

	ENTITY update(ENTITY entity);

	void delete(ENTITY entity);
}
