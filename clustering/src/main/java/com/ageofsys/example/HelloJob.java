package com.ageofsys.example;

import org.quartz.*;

@DisallowConcurrentExecution
public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            String schedulerName = context.getScheduler().getSchedulerName();
            String schedulerId = context.getScheduler().getSchedulerInstanceId();
            System.err.println(String.format("[%s:%s] Hello!  HelloJob is executing.", schedulerName, schedulerId));
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
