package com.hk.corejava.java8;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class OptionalJava8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id : ");
        int i = sc.nextInt();

        try {
            //Without Optional
            String name = getNamefromDB(i);
            System.out.println(name.toUpperCase());
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }


        //With Optional
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        Optional<String> data = getDatafromDB(id);

        if(data.isPresent())System.out.println("data = " + data);
        data.ifPresent(System.out::println);

        System.out.println(data.orElse("NA"));

        try {
            System.out.println(data.orElseThrow(NoSuchElementException::new));
        } catch (NoSuchElementException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    private static Optional<String> getDatafromDB(int id) {
        String name = (id < 100) ? "ram" : null;
        return Optional.ofNullable(name);
    }

    private static String getNamefromDB(int i) {
        // lets assume we have 100 records in db, id id is greater then 100 then return null
        return (i < 100) ? "ram" : null;
    }
}
