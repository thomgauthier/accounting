package com.tgr.accounting.format;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class DoubleFormatFactory {

	public static NumberFormat getFormat() {
		NumberFormat format = NumberFormat.getNumberInstance(Locale.FRANCE);
		format.setMaximumFractionDigits(2);
		format.setMaximumIntegerDigits(14);
		return format;
	}
	
}
