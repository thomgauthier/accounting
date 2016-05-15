package com.tgr.accounting.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tgr.accounting.service.InternalExcelImportService;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.model.ImportPropertiesModel;
import com.tgr.accounting.service.api.type.AmountType;
import com.tgr.accounting.service.api.type.PaymentType;
import com.tgr.fwk.exception.ServiceException;
import com.tgr.fwk.service.AbstractService;

public class ExcelImportServiceImpl extends AbstractService implements InternalExcelImportService {

	public <T> List<T> importFile(File file, ImportPropertiesModel model, Class<T> type) {
		
		Workbook workbook = createWorkbook(file);
		
		Sheet sheet = workbook.getSheet(model.getSheet());
		Integer year = Integer.valueOf(model.getSheet());
		Integer rowNumber = model.getFromRow();
		List<T> results = new ArrayList<T>();
		Row row = sheet.getRow(rowNumber);
		
		while (proceed(row, rowNumber, model.getToRow())) {
			EntryModel entryModel = parseRow(row);
			entryModel.setYear(year);
			results.add((T)entryModel);
			row = sheet.getRow(rowNumber++);
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	private boolean proceed(Row row, Integer rowNumber, Integer endRow) {
		return row != null && (endRow != null ? Integer.compare(rowNumber, endRow) <= 0 : true);
	}
	
	private Workbook createWorkbook(File file) {
		try {
			return WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			throw new ServiceException(e);
		} catch (InvalidFormatException e) {
			throw new ServiceException(e);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
	}
	
	private EntryModel parseRow(Row row) {
		EntryModel model = new EntryModel();
		
		Double output = getCellValueAs(row, 1, Double.class);
		Double input = getCellValueAs(row, 2, Double.class);
		Double day = getCellValueAs(row, 3, Double.class);
		Double month = getCellValueAs(row, 4, Double.class);
		PaymentType paymentType = PaymentType.getByCode(getCellValueAs(row, 5, String.class));
		String axis1 = getCellValueAs(row, 6, String.class);
		String axis2 = getCellValueAs(row, 7, String.class);
		String axis3 = getCellValueAs(row, 8, String.class);
		
		if (output != null && Double.compare(output, 0D) > 0) {
			model.setAmount(output);
			model.setAmountType(AmountType.OUTPUT);
		}
		if (input != null && Double.compare(input, 0D) > 0) {
			model.setAmount(input);
			model.setAmountType(AmountType.INPUT);
		}
		if (day != null) {
			model.setDay(day.intValue());
		}
		if (month != null) {
			model.setMonth(month.intValue());
		}
		model.setPaymentType(paymentType);
		model.setAxis1(axis1);
		model.setAxis2(axis2);
		model.setAxis3(axis3);
		
		return model;
	}
	
	private <T> T getCellValueAs(Row row, int cellId, Class<T> type) {
		
		Cell cell = row.getCell(cellId);
		
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			String strValue = cell.getStringCellValue();
			if (String.class.equals(type)) {
				return type.cast(strValue);
			}
			return getStringValueAs(strValue, type);
			
		case Cell.CELL_TYPE_NUMERIC:
			Double doubleValue = cell.getNumericCellValue();
			if (Double.class.equals(type)) {
				return type.cast(doubleValue);
			}
			return getDoubleValueAs(doubleValue, type);
		default:
			break;
		}
		
		return null;
	}
	
	private <T> T getStringValueAs(String str, Class<T> type) {
		if (Double.class.equals(type)) {
			return (T) (new Double (Double.parseDouble(str)));
		}
		if (Integer.class.equals(type)) {
			return (T) (new Integer (Integer.parseInt(str)));
		}
		return null;
	}
	
	private <T> T getDoubleValueAs(Double doubleValue, Class<T> type) {
		if (Integer.class.equals(type)) {
			return (T) (new Integer (doubleValue.intValue()));
		}
		if (String.class.equals(type)) {
			return (T) (new String(String.valueOf(doubleValue)));
		}
		return null;
	}
}
