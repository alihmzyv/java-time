package org.example;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class DayOfWeekAndMonthEnums {
    public static void main(String[] args) {
        Locale locale = new Locale("az", "AZ");
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        Month month = Month.NOVEMBER;
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
    }
}