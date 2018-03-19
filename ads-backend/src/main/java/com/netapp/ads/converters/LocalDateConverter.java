package com.netapp.ads.converters;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.netapp.ads.util.DateUtils;

@Converter(autoApply = false)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return (localDate == null ? null : DateUtils.asDate(localDate));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return (date == null ? null : DateUtils.asLocalDate(date));
	}
	
}
