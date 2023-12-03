package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PaydayAdjusterTest {
    TemporalAdjuster paydayAdjuster = new PaydayAdjuster();

    public static Stream<Arguments> getDateAndExpectedResult() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, 11, 16), LocalDate.of(2023, 11, 29)),
                Arguments.of(LocalDate.of(2023, 9, 14), LocalDate.of(2023, 9, 29))
        );
    }

    @ParameterizedTest
    @MethodSource("getDateAndExpectedResult")
    void adjustInto(Temporal testDate, Temporal payday) {
        Temporal actualPayday = testDate.with(paydayAdjuster);
        assertEquals(actualPayday, payday);
    }
}