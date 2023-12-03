package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

import static org.example.Util.print;

public class DateAndTimeClasses {
    public static void main(String[] args) {
        //LocalTime
        for (int count = 0; count < 5; count++) {
            System.out.println(LocalDateTime.now(ZoneId.of("Europe/Istanbul")));
            print("Now: %s", LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Istanbul")));
        }

        //LocalDateTime
        print("Instant of now: %s", Instant.now());
    }
}
