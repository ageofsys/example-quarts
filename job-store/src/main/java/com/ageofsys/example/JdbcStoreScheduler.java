package com.ageofsys.example;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JdbcStoreScheduler {
    public static void main(String[] args) throws SchedulerException {

        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        schedulerFactory.initialize("quartz-jdbc.properties");

        Scheduler scheduler = schedulerFactory.getScheduler();

        scheduler.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1") // name "myJob", group "group1"
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);

    }
}
