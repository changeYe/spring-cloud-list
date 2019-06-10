package com.ytq.quartz.test;

import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.DailyCalendar;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 * @author yuantongqin
 * 2019/6/4
 */
public class QuartzTest {

    public static void main(String[] args) {
        //创建scheduler 定时调度器
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

            Trigger trigger = TriggerBuilder.newTrigger()

                    .withIdentity("Trigger1","group1")
                    .startNow()//一点加入scheduler 立即生效
                    // 关联哪一个调度器
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).withRepeatCount(5))
                    .build();

//
            //定义一个job 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
            JobDataMap jobDataMap = new JobDataMap();
            //定义的一些属性值
            jobDataMap.put("name","jobDetail");
            JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class)
                    .withIdentity("JobDetail","group1")
                    .usingJobData(jobDataMap)
                    .build();


//            DailyCalendar dailyCalendar = new DailyCalendar()
            //将开关与灯关联起来
            defaultScheduler.scheduleJob(jobDetail,trigger);

//            JobKey key = new JobKey()
//            defaultScheduler.resumeJob(key);

            //启动
            defaultScheduler.start();
            // 一个trigger 只能关联一个job,而一个job可以关联多个trigger,
            // 为了区分这个开关是一楼的还是二楼的通过group进行区分

//            defaultScheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

}
