package com.ageofsys.example;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class MyApplication2 {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = JdbcStoreScheduler.standdy("quartz-server2.properties");
        scheduler.start();
    }
}
