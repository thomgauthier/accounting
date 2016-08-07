package com.tgr.accounting.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class DateFormatFactory {

	public static DateFormat getFormat() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}
}
