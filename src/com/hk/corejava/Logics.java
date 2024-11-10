package com.hk.corejava;

public class Logics {
    public static String reverseStringWithRecursion(String input){
        System.err.println(input);
        /* Base case: if the input string is empty or has only one character, return it */
        if (input.isEmpty() || input.length() == 1) {
            return input;
        } else {
            // Recursive step: reverse the substring starting from the second character,
            // and concatenate it with the first character
            return reverseStringWithRecursion(input.substring(1)) + input.charAt(0);
        }
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit and process each digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed, return the updated array
            }
            digits[i] = 0; // Set the current digit to 0 if it's 9
        }

        // If we have exhausted all digits and all were 9s
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // Set the first digit to 1
        // The rest of newNumber is already initialized to 0s by default
        return newNumber;
    }
}
