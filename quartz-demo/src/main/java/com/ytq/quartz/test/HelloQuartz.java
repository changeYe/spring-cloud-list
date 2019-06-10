package com.ytq.quartz.test;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;

/**
 * @author yuantongqin
 * 2019/6/4
 */
@DisallowConcurrentExecution
public class HelloQuartz implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDetail jobDetail = context.getJobDetail();
        System.out.println(jobDetail.toString());
        Scheduler scheduler = context.getScheduler();
        System.out.println(scheduler.toString());
        Trigger trigger = context.getTrigger();
        System.out.println(jobDetail.getJobDataMap().get("name")+"===");

        int a =  1/0;

    }
}
