package com.hk.corejava;

public class CarDriver {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setCarId(1)
                .setCarName("Model S")
                .setBrand("Tesla")
                .setModel("S")
                .setPrice(79999.99)
                .setColor("Red")
                .build();

        // Print car details
        System.out.println(car);
    }
}
