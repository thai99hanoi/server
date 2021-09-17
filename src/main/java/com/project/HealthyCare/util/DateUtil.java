package com.project.HealthyCare.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    public static String dateToString(Date date) {
        String pattern = "dd-MM-yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateStr = df.format(date);
        return dateStr;
    }
}
