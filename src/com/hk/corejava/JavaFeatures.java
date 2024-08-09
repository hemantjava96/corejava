package com.hk.corejava;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFeatures {
    public static void main(String[] args) {

        // try with resource before java 9
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("try with resource before java 9");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // try with resource in and after java 9
        Scanner scanner = new Scanner(System.in);
        try (scanner) {
            System.out.println("try with resource before java 9");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // java 10 local variable as var
        // can only be applied in local variable
        var name = "java 10 local variable as var"; // Infers String type
        var age = 30; // Infers int type
        var salary = 50000.0; // Infers double type
        System.out.println("String: " + name);
        System.out.println("Number: " + age);
        System.out.println("Double: " + salary);


        //Java 11 Local Variable Type as var in Lambda Expressions
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("def");
        strings.add("jkl");
        strings.forEach((var string) -> {
            System.out.println("value: " + string);
        });

        /*
        java 12 string indent
        Indent method is used to add an indentation to each line of a string
        It returns a new String instance with the specified number of spaces added to the beginning of each line.
         */
        String original = "Hello\n World";

        System.out.println(original);
        String indented = original.indent(10);
        System.out.println(indented);

        /*
        java 12 string transform
        Transform method applies a transformation function to the string and returns the result.
        It’s a way to perform operations on strings in a more functional programming style.
        */
        String string = "Hello";
        String transformed = string.transform(String::toUpperCase);
        System.out.println(transformed); // Output: HELLO


        /*
        Files Mismatch
        Files.mismatch method is part of the java.nio.file package in Java, and it is used to compare the content of two files for differences.
        It’s specifically designed to efficiently determine whether two files have differing content without needing to read the entire contents of the files.
         */
        try {
            Path filePath1 = Files.createTempFile("file1", ".txt");
            Path filePath2 = Files.createTempFile("file2", ".txt");
            Files.writeString(filePath1, "I love Java");
            Files.writeString(filePath2, "I love Technology");

            long mismatch = Files.mismatch(filePath1, filePath2); // It returns 7
            System.out.println("mismatch = " + mismatch);

            Files.delete(filePath1);
            Files.delete(filePath2);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*
        Java 13
        TextBlocks
        Text Blocks were introduced as a preview feature in Java 13 and were made a permanent part of the Java language in Java 15.
        It provides a more readable and natural way to define strings that span multiple lines without the need for concatenation or escape characters.
         */
        String value = """
             _    _  ______  __   __
            | |  | ||  ____||  \\/  |
            | |__| || |__   | \\  / |
            |  __  ||  __|  | |\\/| |
            | |  | || |____ | |  | | 
            |_|  |_||______||_|  |_| 
            """;
        System.out.println("value = \n" + value);


        //java 14 yeild keyword
        var day = "Sunday";
        var result = switch (day) {
            case "Monday", "Tuesday", "Wednesday","Thursday", "Friday": yield "Weekday";
            case "Saturday", "Sunday": yield "Weekend";
            default: yield "Invalid day.";
        };
        System.out.println("result = " + result);


    }
}

//java9 - Private Interface Methods
interface MyInterface {
    default void publicMethod() {
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Private method in interface.");
    }
}


/*
Java 14 introduces a new class type record as preview feature to facilitate creation of immutable data objects.
Java 15 enhances record type further. With Java 16, record is now a standard feature of JDK.
Defining a record is a concise way of defining an immutable data holding object.
*/
record Book(String title, String author, String isbn) {}


/*
Sealed class is a feature introduced in Java 15 to enhance the control over class inheritance and ensure that only specific subclasses can extend it.
It provides a way to declare a limited set of classes that are allowed to inherit from the sealed class, while preventing other classes from extending it.
Here’s a basic explanation of how sealed classes work
All sealed class subclasses must either be final, sealed or non-sealed
 */
sealed class Shape permits Rectangle{}
non-sealed class Rectangle extends Shape{}
