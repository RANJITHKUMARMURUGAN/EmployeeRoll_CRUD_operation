package com.springboot.converter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter(autoApply = true)
public class ListToJSONConvertor implements AttributeConverter<List<String>, String> {
	private ObjectMapper mapper;

	public ListToJSONConvertor() {
		this(new ObjectMapper());
	}

	public ListToJSONConvertor(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public String convertToDatabaseColumn(List<String> entityValue) {
		try {
			return mapper.writeValueAsString(entityValue);
		} catch (Exception e) {
			log.error("Could not deserialize list from database", e);
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> convertToEntityAttribute(String databaseValue) {

		databaseValue = databaseValue == null ? "[]" : databaseValue;
		try {
			return mapper.readValue(databaseValue, List.class);
		} catch (Exception e) {
			log.error("Could not deserialize list from database", e);
		}
		return new ArrayList<>();
	}
}
