package com.jrod.atmira.nasa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Jesús Rodríguez
 */
public class UtilsDate {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getCurrentDate(){
        LocalDate localDate = LocalDate.now();
        return dtf.format(localDate);
    }

    public static String sumDaysToDate(String date, Long days){
        LocalDate localDate = LocalDate.parse(date);
        return dtf.format(localDate.plusDays(days));
    }
}
