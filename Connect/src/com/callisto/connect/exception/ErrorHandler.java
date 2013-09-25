package com.callisto.connect.exception;

import java.util.HashMap;

public class ErrorHandler {

	// Exception codes.
	public static final int ERROR_INVALID_PARAMETER = 1;
	
	private static HashMap<Integer, String> _dictionary = null;
	
	static {
		
		ErrorHandler._dictionary = new HashMap<Integer, String>();
		
		// 정적 초기화 과정 수행: 파일로 대.
	}
	
	public static String getErrorMessageByCode(int errorCode)
	{
		if (ErrorHandler._dictionary.containsKey(errorCode) != true)
		{
			return null;
		}
		
		return ErrorHandler._dictionary.get(errorCode);
	}
}
