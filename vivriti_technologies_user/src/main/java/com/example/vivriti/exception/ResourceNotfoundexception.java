package com.example.vivriti.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404 status code
public class ResourceNotfoundexception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Object filedValues;

	public ResourceNotfoundexception(String resourceName, String fieldName, Object filedValues) {
		super(String.format("%s not found with %s:'%s', resourceName, fieldName, fieldValue"));

		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.filedValues = filedValues;

	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFiledValues() {
		return filedValues;
	}

}