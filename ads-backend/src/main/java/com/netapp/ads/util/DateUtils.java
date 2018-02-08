package com.netapp.ads.util;

import java.sql.Timestamp;
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
}
