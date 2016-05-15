package com.tgr.accounting.batch.imports.entry;

import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class EntryItemWriter implements ItemWriter {

	@PersistenceContext
	private EntityManager em;
	
	public void open(Serializable checkpoint) throws Exception {

	}

	public void close() throws Exception {

	}

	public void writeItems(List<Object> items) throws Exception {
		
	}

	public Serializable checkpointInfo() throws Exception {
		return null;
	}

}
