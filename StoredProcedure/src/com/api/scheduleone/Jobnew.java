package com.api.scheduleone;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class Jobnew implements Job {
	@Override
	public void execute(JobExecutionContext context)
		throws JobExecutionException 
	{
		 System.out.println("Test Execute : " + new Date());
	}
	public void Test()
	 {
		 System.out.println("First Job : " + new Date());
	 }
}
