package com.example.laundry_project.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.TimeZone;

public class DateStamp {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Timestamp getCurrentDate() {
        return Timestamp.valueOf(dateFormat.format(System.currentTimeMillis()));
    }
}
