package com.tgr.accounting.service.api.model;

import com.tgr.fwk.model.AbstractModel;

public class ImportPropertiesModel extends AbstractModel {

	private static final long serialVersionUID = 9222466753411117525L;

	private String absoluteFilePath;
	private Integer fromRow;
	private Integer toRow;
	private String sheet;
	
	public ImportPropertiesModel() {
		
	}

	public String getAbsoluteFilePath() {
		return absoluteFilePath;
	}

	public void setAbsoluteFilePath(String absoluteFilePath) {
		this.absoluteFilePath = absoluteFilePath;
	}

	public Integer getFromRow() {
		return fromRow;
	}

	public void setFromRow(Integer fromRow) {
		this.fromRow = fromRow;
	}

	public String getSheet() {
		return sheet;
	}

	public void setSheet(String sheet) {
		this.sheet = sheet;
	}

	public Integer getToRow() {
		return toRow;
	}

	public void setToRow(Integer toRow) {
		this.toRow = toRow;
	}
}
