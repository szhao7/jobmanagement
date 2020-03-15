package com.morningstar.autoManagementDemo.core;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyJob implements Job {
	 
		public void execute(JobExecutionContext context) throws JobExecutionException {
	        log.info("star the job.");
	        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
	        
	    }

		
}

