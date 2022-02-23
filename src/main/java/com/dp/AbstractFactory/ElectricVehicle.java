package com.dp.AbstractFactory;

public class ElectricVehicle implements Vehicle{
    private CarBodyType type;

    public ElectricVehicle(CarBodyType type) {
        this.type = type;
    }

    @Override
    public void drive() {
        System.out.println("Driving an electric " + type);

    }

    @Override
    public void fillup() {
        System.out.println("your electric " +
                type + " is charging...");
    }

    @Override
    public void greetDriver() {

    }

    @Override
    public String toString() {
        return "ElectricVehicle{" +
                "type=" + type +
                '}';
    }
}
