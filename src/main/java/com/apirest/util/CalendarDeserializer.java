package com.apirest.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CalendarDeserializer extends JsonDeserializer<Calendar> {

	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Calendar deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			java.util.Date date = format.parse(jp.getText());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
