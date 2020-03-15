package com.morningstar.autoManagementDemo.core;
import java.util.Arrays;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class QuartzDemo {		
	 public void quartzTest() throws InterruptedException{
	        try {
	            //获取调度器
	            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
	            scheduler.start();
	            
	            
	            List<String> list=Arrays.asList("test1");
	            for(String str:list){
	            	JobDataMap jobDatamap=new JobDataMap ();
	            	jobDatamap.put("name", str);
		    
	            	JobDetail jobDetail = JobBuilder.newJob(MyJob.class).setJobData(jobDatamap).withIdentity(str).build();
		            CronScheduleBuilder scheduleBuilder =CronScheduleBuilder.cronSchedule("0/20 * * * * ?");
		    
		            CronTrigger trigger=(CronTrigger) TriggerBuilder.newTrigger().withIdentity(str)
		            		.withSchedule(scheduleBuilder).startNow().build();
		            scheduler.scheduleJob(jobDetail, trigger);
		        }
	            
	        } catch (SchedulerException e) {
	             e.printStackTrace();
	        }
	    }
	 
	 public static void main(String[] args) {
		 try {
	            new QuartzDemo().quartzTest();
	        } catch (InterruptedException i) {
	            i.printStackTrace();
	        }
	 }
}
