package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PaydayAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate localDate = LocalDate.from(temporal);
        LocalDate oneDayBeforeLastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth())
                .minusDays(1);
        DayOfWeek dayOfWeekOfOneDayBeforeLastMonth = oneDayBeforeLastDayOfMonth.getDayOfWeek();
        if (dayOfWeekOfOneDayBeforeLastMonth.equals(DayOfWeek.SATURDAY) || dayOfWeekOfOneDayBeforeLastMonth.equals(DayOfWeek.SUNDAY)) {
            return oneDayBeforeLastDayOfMonth.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return oneDayBeforeLastDayOfMonth;
    }
}
