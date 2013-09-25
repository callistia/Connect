package com.callisto.connect;

import com.callisto.connect.environment.Environment;
import com.callisto.connect.exception.ErrorHandler;
import com.callisto.connect.process.Process;

public class Program {

	public static void main(String[] args) {
		
		Environment.setDebugging(true);
		
		if (!Environment.isDebugging() && args.length < 2)
		{
			int errorCode = ErrorHandler.ERROR_INVALID_PARAMETER;
			String message = ErrorHandler.getErrorMessageByCode(errorCode);
			
			System.out.println("Error: " + message);
			System.exit(errorCode);
		}
		
		Process process = new Process("");
		
		Environment environment = Environment.getInstance();
		environment.setCurrentProcess(process);
		
		environment.execute();
	}
}
