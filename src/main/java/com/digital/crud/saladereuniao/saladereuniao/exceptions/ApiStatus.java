package com.digital.crud.saladereuniao.saladereuniao.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiStatus {
	
	private String message;
	private String cause;

}
