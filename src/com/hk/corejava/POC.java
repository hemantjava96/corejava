package com.hk.corejava;

import java.util.HashSet;

public class POC {
    public static void main(String[] args) {

    }

    public void internalsOfHashSet(){
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(1);
    }
}
