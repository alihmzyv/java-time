package org.example;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

import static org.example.util.Util.print;

public class TemporalPackage {
    public static void main(String[] args) {
        //ChronoField
        ZonedDateTime nowInIstanbul = LocalDateTime.now(ZoneId.of("Europe/Istanbul")).minusHours(1).atZone(ZoneId.of("Europe/Istanbul"));
        ZonedDateTime nowInBaku = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Baku"));
        print("Now in Istanbul: %s", nowInIstanbul);
        print("Now in Baku: %s", nowInBaku);
        boolean supported = LocalDate.now(ZoneId.of("Europe/Istanbul")).isSupported(ChronoField.CLOCK_HOUR_OF_DAY);
        print("LocalDate supports clock hour of day: %s", supported);

        int milliOfSecond = nowInIstanbul.get(ChronoField.MILLI_OF_SECOND);
        print("Milli of second: %d", milliOfSecond);

        int qoy = nowInIstanbul.get(IsoFields.QUARTER_OF_YEAR);
        print("Qoy: %d", qoy);

        //ChronoUnit
        Duration durationBetweenBakuAndIstanbul = Duration.between(nowInIstanbul, nowInBaku);
        print("Hours between Baku and Istanbul: %s", durationBetweenBakuAndIstanbul.toHours());
    }
}
