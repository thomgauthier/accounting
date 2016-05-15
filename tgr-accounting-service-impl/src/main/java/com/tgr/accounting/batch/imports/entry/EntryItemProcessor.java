package com.tgr.accounting.batch.imports.entry;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class EntryItemProcessor implements ItemProcessor {

	public Object processItem(Object item) throws Exception {
		
		return item;
	}

}
