package com.callisto.connect.process;


public class Process {

	// 메모리 구조 기술.
	
	// 프로그램 구조 기술.
	public int _lineCount = 0;
	
	public Process(String filepath) {

		// 파일을 개방하여 구문 분석.
		analyze();
	}
	
	private void analyze()
	{
		checkSyntax();
		buildState();
	}
	
	// 전체 프로그램 유효성 검사.
	private void checkSyntax()
	{
		
	}
	
	// 메모리 구조 설계 및 적재.
	private void buildState()
	{
		
	}
	
	
	public void execute()
	{
		// 줄 단위로 수행.
		System.out.println("a");
	}
	
	
	// 코드 삽입.
	public void inject(String filename) {  }
	
	// 코드 적출.
	public void eject(String filename) {  }
	
	// 프로그램 변경.
	public void change(String filename) {  }
}