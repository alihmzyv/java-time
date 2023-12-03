package org.example;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

import static org.example.util.Util.print;

public class TemporalQueryDemo {
    public static void main(String[] args) {
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        print("LocalDate precision is %s", LocalDate.now().query(query));
        //custom temporal queries can be written just like custome temporal adjusters
    }
}
