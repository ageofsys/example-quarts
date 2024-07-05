package com.ageofsys.example;

import java.sql.*;

public class ExampleUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/example-quartz";
    private static final String USERNAME = "devman";
    private static final String PASSWORD = "secret";

    public static void clearTables() {
        String[] tables = {
                "QRTZ_SIMPLE_TRIGGERS",
                "QRTZ_CRON_TRIGGERS", "QRTZ_BLOB_TRIGGERS", "QRTZ_CALENDARS",
                "QRTZ_PAUSED_TRIGGER_GRPS", "QRTZ_FIRED_TRIGGERS", "QRTZ_SCHEDULER_STATE", "QRTZ_LOCKS",
                "QRTZ_TRIGGERS", "QRTZ_JOB_DETAILS"
        };
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            for (String table : tables) {
                try (PreparedStatement statement = connection.prepareStatement("DELETE FROM " + table)) {
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
