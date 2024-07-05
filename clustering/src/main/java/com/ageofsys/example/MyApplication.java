package com.ageofsys.example;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

public class MyApplication {
    public static void main(String[] args) throws SchedulerException {

        ExampleUtils.clearTables();

        Scheduler scheduler1 = JdbcStoreScheduler.standdy("quartz-server1.properties");
        Scheduler scheduler2 = JdbcStoreScheduler.standdy("quartz-server2.properties");

        scheduler1.start();
        scheduler2.start();
    }
}
