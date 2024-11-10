package com.hk.corejava.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class PredefinedFI {
    public static void main(String[] args) {
        System.out.println("===========Predicate FI===========");
        predicateFI();

        System.out.println("===========BiPredicate FI===========");
        biPredicateFI();

        System.out.println("===========Function FI===========");
        FunctionFI();

        System.out.println("===========BiFunction FI===========");
        biFunctionFI();

        System.out.println("===========Consumer FI===========");
        ConsumerFI();

        System.out.println("===========BiConsumer FI===========");
        biConsumerFI();

        System.out.println("===========Supplier FI===========");
        SupplierFI();

        System.out.println("===========UnaryOperator FI===========");
        UnaryOperatorFI();

        System.out.println("===========UnaryOperator FI===========");
        BinaryOperator();
    }



    static class Person {
        private String name;
        public Person(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    private static void BinaryOperator() {
        //BinaryOperator FI is a child of BiFunction FI, speciality os this FI is the two method arguments and the return type is same in BinaryOperator
        BinaryOperator<Integer> multiplier = (num1,num2) -> num1*num2;
        System.out.println("Multiplication of 50 and 40 is :"+multiplier.apply(50,40));
    }

    private static void UnaryOperatorFI() {
        //UnaryOperator FI is a child of Function FI, specialty os this FI is the return type and method argument is same in UnaryOperator
        UnaryOperator<Integer> square = number -> number*number;
        System.out.println("square of 90 = " + square.apply(90));
    }

    private static void biConsumerFI() {
        //BiConsumer FI is similar to Consumer, which takes any two parameter and returns nothing
        BiConsumer<Integer,Integer> printAreaOfRectangle = (length,width) -> System.out.println(length*width);
        printAreaOfRectangle.accept(12,8);
    }

    private static void biFunctionFI() {
        //BiFunction FI is similar to Function, which takes any two parameter and returns something
        BiFunction<Integer,Integer,Integer> multiplier = (num1,num2) -> num1*num2;
        System.out.println(multiplier.apply(10,8));
        System.out.println(multiplier.apply(15,5));
    }

    private static void biPredicateFI() {
        //BiPredicate FI is similar to Predicate, which takes two parameter and returns boolean
        BiPredicate<String,Integer> confirmStringLength = (str,nbr) -> str.length()==nbr;
        System.out.println(confirmStringLength.test("hemant",6));
        System.out.println(confirmStringLength.test("hemant",7));
    }

    private static void SupplierFI() {
        //Supplier FI has one abstract method 'get', which takes zero parameter and returns something
        Supplier<Integer> supplier = () -> 100;
        System.out.println(supplier.get());
        //it has no default or static method
    }

    private static void ConsumerFI() {
        //Consumer FI has one abstract method 'accept', which takes one parameter and returns nothing
        Consumer<String> printString = string -> System.out.println("string = " + string);
        printString.accept("Asur");

        Consumer<List<Integer>> printListOfIntegers = integers -> {
            System.out.print("{ ");
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("}");
        };
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        printListOfIntegers.accept(numbers);

        //use default methods of Consumer FI i.e andThen
        Consumer<List<Integer>> printifOdd = integers -> {
            System.out.print("Odd numbers : { ");
            for (Integer integer : integers) {
                if (integer % 2 != 0)
                    System.out.print(integer + " ");
            }
            System.out.println("}");
        };
        printListOfIntegers.andThen(printifOdd).accept(numbers);
    }

    private static void FunctionFI() {
        //Function FI has one Abstract method 'apply', which takes one any parameter and returns any value
        Function<Integer, Integer> doubler = number -> number * 2;
        Function<Integer, Integer> square = number -> number * number;
        System.out.println("double of 5 is : " + doubler.apply(5));
        System.out.println("square of 5 is : " + square.apply(5));

        //Find avg of a list of Integer using Function FI
        Function<List<Integer>, Double> average = numbers -> {
            double sum = 0.0;
            for (Integer number : numbers)
                sum = sum + number;
            return sum / numbers.size();
        };
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("avg is : " + average.apply(numbers));

        //use default methods of Function FI i.e andThen , compose
        System.out.println("use andThen method :");
        System.out.println("find double of 5 and then square  it: " + doubler.andThen(square).apply(5));
        System.out.println("find square of 5 and then double  it: " + square.andThen(doubler).apply(5));

        System.out.println("use compose method :");
        System.out.println("find double of 5 and then square  it: " + square.compose(doubler).apply(5));
        System.out.println("find square of 5 and then double  it: " + doubler.compose(square).apply(5));

        //use static method of Function FI i.e. identity, it just creates a Function which returns same thing which is sent as parameter
        System.out.println("use identity method :");
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));
    }

    private static void predicateFI() {
        //Predicate FI has one Abstract method which takes one parameter and returns boolean
        Predicate<Integer> isOverPaidSalary = salary -> salary > 100000;
        if (isOverPaidSalary.test(50000))
            System.out.println("yes, salary 50000 is overpaid");

        //use default methods of Predicate FI i.e and , or , negate
        Predicate<Integer> isUnderPaidSalary = isOverPaidSalary.negate();
        if (isUnderPaidSalary.test(50000))
            System.out.println("yes, salary 50000 is underpaid");

        Predicate<Integer> isPerfectSalary = salary -> salary % 1000 == 0;
        Predicate<Integer> isPerfectAndUnderPaidSalary = isPerfectSalary.and(isUnderPaidSalary);
        if (isPerfectAndUnderPaidSalary.test(50000))
            System.out.println("yes, salary 50000 is underpaid&perfect");
        if (!isPerfectAndUnderPaidSalary.test(50111))
            System.out.println("No, salary 50111 is not underpaid&perfect");
    }

    public static class MethodConstructorReference {
        public static void main(String[] args) {
            MethodReference();
            ConstructorReference();
        }

        private static void ConstructorReference() {
            //get Person object from person names
            //without Constructor reference
            List<String> strings = Arrays.asList("hemant", "hari", "himesh", "harish", "harshit");
            Function<String, Person> getPersonFromName = str -> new Person(str);
            List<Person> persons = transformStringtoPerson(strings, getPersonFromName);
            System.out.println(persons);

            //with Constructor reference
            List<String> names = Arrays.asList("Darshan", "dinesh", "dharma", "daya", "daman");
            List<Person> personList = transformStringtoPerson(strings, Person::new);
            System.out.println(personList);
        }
        /**
         * Transforms a list of strings into a list of {@code Person} objects by applying a given function.
         *
         * @param list The list of strings to be transformed into {@code Person} objects. Must not be {@code null}.
         * @param function A {@code Function<String, Person>} that defines how to convert each string into a {@code Person}.
         *                 Must not be {@code null}.
         */
        private static List<Person> transformStringtoPerson(List<String> list, Function<String, Person> function) {
            List<Person> transformedList = new ArrayList<>();
            for (String item : list) {
                transformedList.add(function.apply(item));
            }
            return transformedList;
        }
        private static void MethodReference() {
            // convert list of String to uppercase
            //without method reference
            Function<String, String> toUpper = string -> string.toUpperCase();
            List<String> strings = Arrays.asList("hemant", "hari", "himesh", "harish", "harshit");
            strings = transformStringList(strings, toUpper);
            System.out.println(strings);

            //with method reference
            List<String> names = Arrays.asList("Darshan", "dinesh", "dharma", "daya", "daman");
            names = transformStringList(names, String::toUpperCase);
            System.out.println(names);
        }
        /** Transforms a list of strings by applying a given function to each element.
         *  @param list The list of strings to be transformed. Must not be {@code null}.
         *  @param function A {@code Function<String, String>} that defines the transformation to be applied
         *                   to each string in the list. Must not be {@code null}.
         *
         */
        private static List<String> transformStringList(List<String> list, Function<String, String> function) {
            List<String> transformedList = new ArrayList<>();
            for (String item : list) {
                transformedList.add(function.apply(item));
            }
            return transformedList;
        }


    }
}
