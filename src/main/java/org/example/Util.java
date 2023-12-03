package org.example;

public class Util {
    public static void print(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }
}
