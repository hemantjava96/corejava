package com.hk.corejava.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        demo();
        createStream();
        playWithStream();

    }

    private static void playWithStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 33, 3, 2, 2, 6, 2, 2, 3, 23, 2, 3, 23, 3332, 3, 2, 32, 2, 3244232);
        List<Integer> newList = list.stream() // -> returns a stream
                .filter(x -> x % 2 == 0) // -> filters out the even number
                .map(x -> x / 2) // -> divide them with 2
                .peek(System.out::println) // -> print the result as of now
                .skip(1) // -> skip the 1st number
                .limit(10) // -> take 1st 10 number
                .sorted((a, b) -> b - a) // -> sort in descending order as per the comparator
                .peek(System.out::println) // -> print the result
                .collect(Collectors.toList()); // -> return the List

        System.out.println(newList);
    }

    private static void createStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 76);
        Stream<Integer> numberStream = numbers.stream();

        String[] arr = {"hemant", "kumar", "Besra"};
        Stream<String> stringStream = Arrays.stream(arr);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 6);

        //1st arg: initial point, 2nd arg is FI of Function which will be used to find next element
        Stream<Integer> limit = Stream.iterate(0, x -> x + 1).limit(100);

        //generate method takes FI Supplier which supplies the data for stream
        Stream<Integer> limit1 = Stream.generate(() -> (int) Math.random()).limit(5);
    }

    private static void demo() {
        //Without Stream
        int sum = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) sum = sum + arr[i];
        }
        System.out.println("sum : " + sum);

        //with stream
        int newSum = Arrays.stream(arr).filter(x -> x % 2 == 0).sum();
        System.out.println("sum : " + newSum);
    }


}
