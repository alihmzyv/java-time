package org.example;

import com.sun.jdi.request.DuplicateRequestException;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.example.util.Util.print;

public class PeriodAndDuration {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(2022, 3, 13, 1, 0, 0), ZoneId.of("America/New_York"));
        ZonedDateTime plusOneDay = zonedDateTime.plus(Duration.ofDays(1));
        print("Day: %s", zonedDateTime);
        print("Plus one day: %s", plusOneDay);
        long daysBetween = Duration.between(zonedDateTime, plusOneDay).toHours();
        print("Hours between: %d", daysBetween);
        //plus years, months, days works in a different way that the plus hours, ...
        //to not only work on local time line, Duration.ofYears(), etc can be used
        long ageInDays = calculateAgeInDays(LocalDateTime.of(2005, 1, 1, 1, 0, 0), ZoneId.of("America/New_York"));
        print("Age in days: %d", ageInDays);
    }


    public static long calculateAgeInDays(LocalDateTime localDateTime, ZoneId zoneId) {
        ZonedDateTime birthDateTime = ZonedDateTime.of(localDateTime, zoneId);
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        Duration age = Duration.between(birthDateTime, now);
        return age.toDays();
    }
}
