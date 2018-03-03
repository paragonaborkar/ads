package com.netapp.ads.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	public Date convertToUtc() {
		
		LocalDateTime ldt = LocalDateTime.now();
	    ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
		ZonedDateTime gmt = zdt.withZoneSameInstant(ZoneId.of("UTC"));
		Timestamp timestamp = Timestamp.valueOf(gmt.toLocalDateTime());
		return timestamp;
	}
	
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	  public static LocalDate asLocalDate(Date date) {
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }

	  public static LocalDateTime asLocalDateTime(Date date) {
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  }	
}
