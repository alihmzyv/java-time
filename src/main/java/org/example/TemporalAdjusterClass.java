package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static org.example.util.Util.print;

public class TemporalAdjusterClass {
    public static void main(String[] args) {
        LocalDate nowInBaku = LocalDate.now(ZoneId.of("Asia/Baku"));
        print("Now in Baku: %s", nowInBaku);
        print("First day of month: %s", nowInBaku.with(TemporalAdjusters.firstDayOfMonth()));
        print("First %s in month: %s",
                DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                nowInBaku.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
    }
}
