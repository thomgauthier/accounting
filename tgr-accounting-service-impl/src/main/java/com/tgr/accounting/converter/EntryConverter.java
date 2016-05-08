package com.tgr.accounting.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.tgr.accounting.entity.EntryEntity;
import com.tgr.accounting.service.api.model.EntryModel;
import com.tgr.accounting.service.api.type.AmountType;

public class EntryConverter implements CustomConverter {

	public Object convert(Object destination, Object source, Class<?> classDest, Class<?> classSrc) {

		if (source == null) {
			return null;
		}
		
		EntryModel entryModel = null;
		EntryEntity entryEntity = null;
		// Entity to Model
		if (source instanceof EntryEntity) {
			entryEntity = (EntryEntity) source;
			// check to see if the object already exists
			if (destination == null) {
				entryModel = new EntryModel();
			} else {
				entryModel = (EntryModel) destination;
			}
			return fromEntity(entryEntity, entryModel);
			
		} else if (source instanceof EntryModel) {
			entryModel = (EntryModel) source;
			// check to see if the object already exists
			if (destination == null) {
				entryEntity = new EntryEntity();
			} else {
				entryEntity = (EntryEntity) destination;
			}
			return fromModel(entryModel, entryEntity);
		} else {
			throw new MappingException("Converter EntryConverter used incorrectly. Arguments passed in were:"
					+ destination + " and " + source);
		}
	}
	
	private EntryModel fromEntity(EntryEntity entryEntity, EntryModel entryModel) {
		// If input
		if (Double.compare(entryEntity.getInput(), 0D) > 0) {
			entryModel.setAmount(entryEntity.getInput());
			entryModel.setAmountType(AmountType.INPUT);
		} else if (Double.compare(entryEntity.getOutput(), 0D) > 0) { // If output
			entryModel.setAmount(entryEntity.getOutput());
			entryModel.setAmountType(AmountType.OUTPUT);
		} else {
			throw new MappingException("Cannot determine if input or output");
		}
		
		entryModel.setAxis1(entryEntity.getAxis1());
		entryModel.setAxis2(entryEntity.getAxis2());
		entryModel.setAxis3(entryEntity.getAxis3());
		entryModel.setDay(entryEntity.getDay());
		entryModel.setId(entryEntity.getId());
		entryModel.setMonth(entryEntity.getMonth());
		entryModel.setPaymentType(entryEntity.getPaymentType());
		entryModel.setYear(entryEntity.getYear());
		
		return entryModel;
	}
	
	private EntryEntity fromModel(EntryModel entryModel, EntryEntity entryEntity) {
		if (AmountType.INPUT.equals(entryModel.getAmountType())) {
			entryEntity.setInput(entryModel.getAmount());
			entryEntity.setOutput(0D);
		} else if (AmountType.OUTPUT.equals(entryModel.getAmountType())) {
			entryEntity.setOutput(entryModel.getAmount());
			entryEntity.setInput(0D);
		} else {
			throw new MappingException("Cannot determine if input or output");
		}
		
		entryEntity.setAxis1(entryModel.getAxis1());
		entryEntity.setAxis2(entryModel.getAxis2());
		entryEntity.setAxis3(entryModel.getAxis3());
		entryEntity.setDay(entryModel.getDay());
		entryEntity.setId(entryModel.getId());
		entryEntity.setMonth(entryModel.getMonth());
		entryEntity.setPaymentType(entryModel.getPaymentType());
		entryEntity.setYear(entryModel.getYear());
		
		return entryEntity;
	}
}
