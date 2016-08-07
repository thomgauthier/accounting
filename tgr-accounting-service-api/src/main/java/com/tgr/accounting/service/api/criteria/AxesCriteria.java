package com.tgr.accounting.service.api.criteria;

import com.tgr.fwk.criteria.AbstractCriteria;

public class AxesCriteria extends AbstractCriteria {

	private static final long serialVersionUID = -524033621032418267L;

	public static int AXE1 = 1;
	public static int AXE2 = 2;
	public static int AXE3 = 3;
	
	private int axe;
	
	public AxesCriteria() {
		
	}

	public int getAxe() {
		return axe;
	}

	public void setAxe(int axe) {
		this.axe = axe;
	}
}
