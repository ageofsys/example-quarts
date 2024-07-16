package com.ageofsys.example;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class MyApplication1 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = JdbcStoreScheduler.standdy("quartz-server1.properties");
        scheduler.start();
    }
}
