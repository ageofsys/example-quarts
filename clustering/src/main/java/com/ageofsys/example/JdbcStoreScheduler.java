package com.ageofsys.example;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JdbcStoreScheduler {

    public static final String GROUP_NAME = "myGroup1";
    public static final String JOB_NAME = "myJob1";
    public static final String TRIGGER_NAME = "myTrigger";

    public static Scheduler standdy(String filename) throws SchedulerException {
        Scheduler scheduler = createScheduler(filename);

        scheduler.standby();

//        boolean jobExists = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(GROUP_NAME))
//                .stream()
//                .anyMatch(jobKey -> jobKey.getName().equals(JOB_NAME));

//        if (!jobExists) {
//            JobDetail job = newJob(HelloJob.class)
//                    .withIdentity(JOB_NAME, GROUP_NAME)
//                    .build();
//
//            Trigger trigger = newTrigger()
//                    .withIdentity(TRIGGER_NAME, GROUP_NAME)
//                    .startNow()
//                    .withSchedule(
//                            cronSchedule("0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?")
//                    )
//                    .build();
//
//            scheduler.scheduleJob(job, trigger);

            for (int i = 0; i < 20; i++) {
                String jobName = "myJob-" + i;

                boolean jobExists = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(GROUP_NAME))
                        .stream()
                        .anyMatch(jobKey -> jobKey.getName().equals(jobName));

                if (!jobExists) {
                    scheduler.scheduleJob(
                            newJob(HelloJob.class)
                                    .withIdentity("myJob-" + i, GROUP_NAME)
                                    .build(),
                            newTrigger()
                                    .withIdentity("myTrigger " + i, GROUP_NAME)
                                    .startNow()
                                    .withSchedule(simpleSchedule()
                                            .withIntervalInSeconds(5)
                                            .repeatForever())
                                    .build());
                }
            }

//        }

        return scheduler;
    }

    public static Scheduler createScheduler(String filename) throws SchedulerException {
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        schedulerFactory.initialize(filename);

        return schedulerFactory.getScheduler();
    }
}
