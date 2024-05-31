package com.hk.corejava;

import java.util.ArrayList;
import java.util.List;

public class CopyOfAPI {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hemant");
        names.add("hemant1");
        names.add("hemant2");
        names.add("hemant3");
        names.add("hemant4");
        addElement(names);

        List<String> newNames = List.of("hk", "hk2", "hk3");//Returns an unmodifiable list
        try {
            addElement(newNames);//error
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        List<String> copyOfNames = List.copyOf(names);
        try {
            addElement(copyOfNames);//error
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        System.out.println(names);

    }

    private static void addElement(List<String> names) {
        names.add("new element");
    }
}
