package org.example.util;

public class Util {
    public static void print(String format, Object... args) {
        System.out.printf((format) + "%n", args);
    }
}
