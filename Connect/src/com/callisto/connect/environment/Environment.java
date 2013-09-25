package com.callisto.connect.environment;

import com.callisto.connect.process.Process;

public class Environment {

	private static boolean _isDebugging = false;
	public static boolean isDebugging() { return Environment._isDebugging; }
	public static void setDebugging(boolean debug) { Environment._isDebugging = debug; }
	
	// 싱글턴 패턴 구현.
	private Environment() {}
	private static Environment _instance = null;
	public static Environment getInstance()
	{
		if (Environment._instance == null)
		{
			Environment._instance = new Environment();
			Environment._instance.initialize();
		}
		
		return Environment._instance;
	}
	
	public void initialize()
	{
		// 가상 머신 환경 초기화 과정 수행.
	}

	private Process _currentProcess = null;
	
	public Process getCurrentProcess() { return _currentProcess; }
	public void setCurrentProcess(Process process) { this._currentProcess = process; }

	
	private State _currentState = State.STATE_IDLE;
	
	public State getCurrentState() { return _currentState; }
	public void setCurrentState(State state) 
	{ 
		this._currentState = state;
		
		switch (state) {
		
			case STATE_IDLE:
			{
				// 로드 프로세스 종료 이벤트 송신: 대기 프로그램이 있으면 적재.
				break;	
			}

			case STATE_LOADED:
			{
				// 로드 완료 이벤트 송신: 서버 측에 전송.
				
				execute();
				break;
			}
			
			case STATE_RUNNING:
			{
				break;
			}
		}
	}
	
	public void execute()
	{
		setCurrentState(State.STATE_RUNNING);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {

				while (getCurrentState() == State.STATE_RUNNING)
				{
					// 실행 중일 경우에만 수행할 내용 기술.
					
					Process process = getCurrentProcess();
					process.execute();
				}
				
				// 프로그램 종료 이벤트 송신.
				setCurrentState(State.STATE_IDLE);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
