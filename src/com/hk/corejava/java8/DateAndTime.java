package com.hk.corejava.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
    public static void main(String[] args) {
        localDate();
        localTime();
        localDateTime();
        ZonedDateTime();
        instantDurationPeriod();
        dateTimeFormatter();
    }

    private static void dateTimeFormatter() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String today = now.format(myFormatter);
        System.out.println("today = " + today);


        String bDay="16/10/1996";
        LocalDate parse = LocalDate.parse(bDay,myFormatter);
        System.out.println("parse = " + parse);
    }

    private static void instantDurationPeriod() {
        Instant now = Instant.now();//UTC Clock
        System.out.println("now = " + now);

        ZonedDateTime newYorkTime = now.atZone(ZoneId.of("America/New_York"));
        System.out.println("newYorkTime = " + newYorkTime);

        Instant now1 = Instant.now();

        Duration d1 = Duration.between(now, now1);
        System.out.println("d1 = " + d1);


        LocalDate date1 = LocalDate.of(1996,10,16);
        LocalDate today = LocalDate.now();
        Period p = Period.between(date1,today);
        System.out.println("p = " + p);
    }

    private static void ZonedDateTime() {
        //Time with zone
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);//now = 2024-03-25T13:54:08.897+05:30[Asia/Calcutta]

        System.out.println("Zones: \n" + ZoneId.getAvailableZoneIds());

        ZonedDateTime kolkataTime = ZonedDateTime.of(1996, 10, 16, 05, 30, 30, 30, ZoneId.of("Asia/Kolkata"));
        System.out.println("kolkataTime = " + kolkataTime);

        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("newYorkTime = " + newYorkTime);

        ZoneId zone = now.getZone();
        System.out.println("zone = " + zone);
    }

    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime parsedDateTime = LocalDateTime.parse("2013-01-02T13:18");
        System.out.println("parsedDateTime = " + parsedDateTime);

        LocalDateTime beforeOneHour = parsedDateTime.minusHours(1);
        System.out.println("beforeOneHour = " + beforeOneHour);
    }

    private static void localTime() {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        LocalTime beforeOneHour = now.minusHours(1);
        System.out.println("beforeOneHour = " + beforeOneHour);

        LocalTime localTime = LocalTime.of(14, 50, 30);
        System.out.println("localTime = " + localTime);

        LocalTime parsedTime = LocalTime.parse("15:30:30");
        System.out.println("parsedTime = " + parsedTime);
    }

    private static void localDate() {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);
        System.out.println("getMonth: "+now.getMonth());
        System.out.println("getMonthValue : "+now.getMonthValue());
        LocalDate yesterday = now.minusDays(1);
        System.out.println("yesterday = " + yesterday);

        if (now.isAfter(yesterday))
            System.out.println("Yes brother..!");

        LocalDate bDay  = LocalDate.of(1996, 10, 16);
        System.out.println("bDay = " + bDay);
    }
}
