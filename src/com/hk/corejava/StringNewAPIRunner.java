package com.hk.corejava;

public class StringNewAPIRunner {
    public static void main(String[] args) {
        System.out.println("".isBlank());
        System.out.println(" L R ".strip().replace(" ", "_"));
        System.out.println(" L R ".stripLeading().replace(" ", "_"));
        System.out.println(" L R ".stripTrailing().replace(" ", "_"));
        System.out.println(" L R ".stripIndent().replace(" ", "_"));

        "Helloo,\nHow are you all doing? \nAre you ready?".lines().forEach(System.out::println);
    }
}
