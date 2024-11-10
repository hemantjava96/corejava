package com.hk.corejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {

        try {
            //Fail Fast Example
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(2);
            integers.add(3);
            Iterator<Integer> itr = integers.iterator();
            while (itr.hasNext()) {
                Integer a = itr.next();
                System.out.print(a);
                integers.remove(a);//this line throws ConcurrentModificationException
            }
        } catch (Exception e) {
            System.out.println(" Exception : " + e);
        }

        //Fail Safe Example
        List<Integer> numbers = new CopyOnWriteArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            System.out.print(a);
            numbers.remove(a);
        }



    }
}
