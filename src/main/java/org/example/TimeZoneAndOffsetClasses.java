package org.example;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.example.Util.print;

public class TimeZoneAndOffsetClasses {
    public static void main(String[] args) {
        //example usage
        LocalDateTime now = LocalDateTime.now();
//        ZonedDateTime nowInDefaultZone = now.atZone(ZoneId.systemDefault());
//        ZonedDateTime nowInIstanbulZoneSameInstant = nowInDefaultZone.withZoneSameInstant(ZoneId.of("Europe/Istanbul"));
//        ZonedDateTime nowInIstanbulSameLocal = nowInDefaultZone.withZoneSameLocal(ZoneId.of("Europe/Istanbul"));
//        print("LocalDateTime now in %s: %s", ZoneId.systemDefault(), now);
//        print("ZonedDateTime now in %s: %s", ZoneId.systemDefault(), nowInDefaultZone);
//        print("ZonedDateTime now in %s: %s", ZoneId.of("Europe/Istanbul"), nowInIstanbulZoneSameInstant);
//        print("ZonedDateTime now in %s: %s", ZoneId.of("Europe/Istanbul"), nowInIstanbulSameLocal);


        //print all zones with offset not equal to a whole hour
//        ZoneId.getAvailableZoneIds()
//                .stream()
//                .sorted()
//                .map(zoneId -> now.atZone(ZoneId.of(zoneId)))
//                .map(ZonedDateTime::getOffset)
//                .filter(zoneOffset -> zoneOffset.getTotalSeconds() % (60 * 60) != 0)
//                .map(zoneOffset -> zoneOffset.getDisplayName(TextStyle.FULL, Locale.getDefault()))
//                .forEach(System.out::println);
//
//        OffsetDateTime offsetDateTime = nowInDefaultZone.toOffsetDateTime();
//        print("OffsetDateTime now in %s: %s", ZoneId.systemDefault(), offsetDateTime);

        LocalDateTime departedAt = LocalDateTime.of(2023, 12, 3, 17, 0, 0, 0);
        ZoneId departureZoneId = ZoneId.of("Asia/Baku");
        ZonedDateTime departedAtWithZone = departedAt.atZone(departureZoneId);
        print("Leaving Baku at with Baku Time: %s", departedAtWithZone);

        long tripDurationInSec = 6 * 30 * 24 * 60 * 60;
        ZoneId arrivalZoneId = ZoneId.of("Atlantic/Faroe");
        ZonedDateTime departedAtWithFareoTime = departedAt.atZone(arrivalZoneId);
        ZonedDateTime arrivalTimeWithFareoTime = departedAtWithZone.plusSeconds(tripDurationInSec).withZoneSameInstant(arrivalZoneId); //daylight saving time will have started
        print("Departue time in Fareo with Fareo Time: %s", departedAtWithFareoTime);
        print("Time in Fareo when arrived: %s", arrivalTimeWithFareoTime);

        print("Duration of trip: %s sec", (arrivalTimeWithFareoTime.toEpochSecond() - departedAtWithZone.toEpochSecond()));
    }
}
