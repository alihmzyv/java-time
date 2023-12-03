package org.example;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static org.example.Constants.AZ_LOCALE;
import static org.example.util.Util.print;

public class DateClasses {
    public static void main(String[] args) {
        //LocalDate
        LocalDate date = LocalDate.of(2001, Month.MARCH, 24);
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        print("Day of week of my birthdate: %s", date.getDayOfWeek());
//        System.out.println(nextWed);

        //YearMonth
        YearMonth now = YearMonth.now();
        print("Month of year now: %s", now.getMonth().getDisplayName(TextStyle.FULL, AZ_LOCALE));
        YearMonth yearMonth = YearMonth.of(2023, Month.FEBRUARY);
        print("%d's %s has %d days", yearMonth.getYear(), yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()), yearMonth.lengthOfMonth());

        //MonthDay
        MonthDay monthDay = MonthDay.of(Month.FEBRUARY, 29);
        print("2023 is a leap year: %s", monthDay.isValidYear(2023));

        //Year
        Year year = Year.of(2023);
        print("%s is a leap year: %s", year, year.isLeap());
    }
}
