package com.hk.corejava;

public class Logics {
    public static String reverseStringWithRecursion(String input){
        /* Base case: if the input string is empty or has only one character, return it */
        if (input.isEmpty() || input.length() == 1) {
            return input;
        } else {
            // Recursive step: reverse the substring starting from the second character,
            // and concatenate it with the first character
            return reverseStringWithRecursion(input.substring(1)) + input.charAt(0);
        }
    }
}
