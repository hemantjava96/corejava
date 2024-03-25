package com.hk.corejava;
import java.util.Date;

public final class ImmutableClass {
    private final String data1;
    private final Date data2;
    private final int data3;

    // Constructor to initialize the object
    public ImmutableClass(String data1, Date data2, int data3) {
        this.data1 = data1;
        // Create a defensive copy of the Date object
        this.data2 = new Date(data2.getTime());
        this.data3 = data3;
    }

    // Getter methods for accessing the data
    public String getData1() {
        return data1;
    }

    public Date getData2() {
        // Return a defensive copy of the Date object
        return new Date(data2.getTime());
    }

    public int getData3() {
        return data3;
    }
}
