package com.hk.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithms {
    public static void main(String[] args) {
        //System.out.println(tribonacciDP(8));

        testIsSumPossible();
    }

    private static void testIsSumPossible() {
        // Define test cases
        List<Integer> numbers1 = Arrays.asList(2, 4, 6);
        int amount1 = 8;

        List<Integer> numbers2 = Arrays.asList(1, 3, 5);
        int amount2 = 9;

        List<Integer> numbers3 = Arrays.asList(2, 4);
        int amount3 = 7;

        // Test the method
        System.out.println("Test case 1: " + isSumPossibleDP(amount1, numbers1)); // should return true
        System.out.println("Test case 2: " + isSumPossibleDP(amount2, numbers2)); // should return true
        System.out.println("Test case 3: " + isSumPossibleDP(amount3, numbers3)); // should return false
    }

    //with out DP
    public static int fibonacci(int index) {
        //0 1 1 2 3 5 8 13 21 34 55
        return index < 2 ? index : (fibonacci(index - 1) + fibonacci(index - 2));
    }

    //with DP
    public static int fibonacciDP(int index) {
        Map<Integer, Integer> memory = new HashMap<>();
        //0 1 1 2 3 5 8 13 21 34 55
        return fibonacciDP(index, memory);
    }

    private static int fibonacciDP(int index, Map<Integer, Integer> memory) {
        if (index < 2)
            return index;
        else if (memory.containsKey(index))
            return memory.get(index);
        int result = fibonacciDP(index - 1, memory) + fibonacciDP(index - 2, memory);
        memory.put(index, result);
        return result;
    }

    //withoutDP
    public static int tribonacci(int index) {
        //0 0 1 1 2 4 7 13 24
        if (index <= 1)
            return 0;
        else if (index == 2)
            return 1;
        else
            return tribonacci(index - 1) + tribonacci(index - 2) + tribonacci(index - 3);

    }

    //with DP
    public static int tribonacciDP(int index) {
        Map<Integer, Integer> memory = new HashMap<>();
        //0 0 1 1 2 4 7 13 24
        return tribonacciDP(index, memory);
    }

    private static int tribonacciDP(int index, Map<Integer, Integer> memory) {
        if (index <= 1)
            return 0;
        else if (index == 2)
            return 1;
        else if (memory.containsKey(index)) {
            return memory.get(index);
        }
        int result = tribonacciDP(index - 1, memory) + tribonacciDP(index - 2, memory) + tribonacciDP(index - 3, memory);
        memory.put(index, result);
        return result;
    }

    //without dp
    public static boolean isSumPossible(Integer amount, List<Integer> numbers) {
        if (amount == 0)
            return true;
        else if (amount < 0)
            return false;
        for (Integer integer : numbers) {
            Integer subAmount = amount - integer;
            if (isSumPossible(subAmount, numbers))
                return true;
        }
        return false;
    }

    //with DP
    public static boolean isSumPossibleDP(Integer amount, List<Integer> numbers) {
        return isSumPossibleDP(amount, numbers, new HashMap<Integer, Boolean>());
    }

    private static boolean isSumPossibleDP(Integer amount, List<Integer> numbers, Map<Integer, Boolean> memory) {
        if (amount == 0)
            return true;
        else if (amount < 0)
            return false;
        else if (memory.containsKey(amount))
            return memory.get(amount);
        for (Integer integer : numbers) {
            Integer subAmount = amount - integer;
            if (isSumPossible(subAmount, numbers)) {
                memory.put(amount, true);
                return true;
            }
        }
        memory.put(amount, false);
        return false;
    }

}
