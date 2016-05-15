package com.tgr.accounting.service;

import java.io.File;
import java.util.List;

import com.tgr.accounting.service.api.model.ImportPropertiesModel;

public interface InternalExcelImportService {

	<T> List<T> importFile(File file, ImportPropertiesModel model, Class<T> type);
}
