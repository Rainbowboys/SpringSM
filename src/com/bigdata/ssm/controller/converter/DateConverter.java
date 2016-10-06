package com.bigdata.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String stringSource) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fm.parse(stringSource);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
