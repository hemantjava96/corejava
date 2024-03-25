package com.hk.corejava.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {
        Adder adder = Integer::sum;
        Printer printer = System.out::println;

        System.out.println(adder.add(1,2));
        printer.say("hello");


        //Runnable interface is used to create threads
        /*Life before java 8 : create a class implementing Runnable and create object of that class and then create thread using that object,
         Or else create an anonymous class implementing Runnable and create thread as below. */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<=10; i++ )
                    System.out.println(i);
            }
        });
        thread1.start();

        /*Life After java 8: As Runnable is a functional interface we can directly pass the lambda expression*/
        Thread thread2 = new Thread(() -> {
            for (int i = 1; i<=15; i++ )
                System.out.println(i);
        });
        thread2.start();


        //Comparator is also a functional interface used to sort Collections
        List<Integer> integers = new ArrayList<>();
        integers.add(56);
        integers.add(90);
        integers.add(36);
        integers.add(26);
        integers.add(106);
        integers.add(6);
        System.out.println(integers);

        //Life before Java 8
        Comparator<Integer> integerComparatorAsc = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        };
        Collections.sort(integers,integerComparatorAsc);
        System.out.println(integers);

        //Life After java 8
        //Comparator<Integer> integerComparatorDesc = (a, b) -> b-a;
        //Collections.sort(integers,integerComparatorDesc);

        Collections.sort(integers,(a, b) -> b-a);
        System.out.println(integers);
    }
}

interface Adder{
    // It is a functional interface
    public int add(int a, int b);
}

@FunctionalInterface
interface Printer{
    // It is a functional interface
    public void say(String content);
}

interface Starter{
    // It is not a functional interface
    public void start();
    public boolean isStarted();
}

interface Worker{
    // It is a functional interface
    public void work();
    default boolean isWorking(){
        return true;
    }
    static boolean isWorkDone(){
        return true;
    }
}
