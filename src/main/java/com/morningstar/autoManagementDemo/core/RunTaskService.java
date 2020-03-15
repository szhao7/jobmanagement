package com.morningstar.autoManagementDemo.core;

public class RunTaskService{
	
	public void init() {
		StartupThread startupThread = new StartupThread();
		startupThread.setName("startupThread");
		startupThread.start();
		
	}

	class StartupThread extends Thread {
		public void run(){
			try {
				new QuartzDemo().quartzTest();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}

