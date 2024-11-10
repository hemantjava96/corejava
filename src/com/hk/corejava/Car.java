package com.hk.corejava;

public class Car {
    private Integer carId;
    private String carName;
    private String brand;
    private String model;
    private Double price;
    private String color;

    // Private constructor to enforce the use of the builder
    private Car(CarBuilder builder) {
        this.carId = builder.carId;
        this.carName = builder.carName;
        this.brand = builder.brand;
        this.model = builder.model;
        this.price = builder.price;
        this.color = builder.color;
    }

    // Getters
    public Integer getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    // Inner Builder class
    public static class CarBuilder {
        private Integer carId;
        private String carName;
        private String brand;
        private String model;
        private Double price;
        private String color;

        public CarBuilder setCarId(Integer carId) {
            this.carId = carId;
            return this;
        }

        public CarBuilder setCarName(String carName) {
            this.carName = carName;
            return this;
        }

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
