package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.example.util.Util.print;

public class InstantClass {
    public static void main(String[] args) {
        Instant now = Instant.now();
        print("Now in instant: %s, %d sec", now, now.getEpochSecond());
        Instant nowSystemDefault = now.atZone(ZoneId.systemDefault()).toInstant();
        print("Now system default zone: %s, %d sec", nowSystemDefault, nowSystemDefault.getEpochSecond());
    }
}
