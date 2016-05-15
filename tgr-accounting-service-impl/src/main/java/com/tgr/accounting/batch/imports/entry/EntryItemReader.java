package com.tgr.accounting.batch.imports.entry;

import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;
import javax.inject.Named;

@Named
public class EntryItemReader implements ItemReader {

	public void open(Serializable checkpoint) throws Exception {
		
	}

	public void close() throws Exception {
		
	}

	public Object readItem() throws Exception {
		return new String("element");
	}

	public Serializable checkpointInfo() throws Exception {
		return null;
	}

	

}
