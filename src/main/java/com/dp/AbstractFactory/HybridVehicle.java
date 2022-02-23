package com.dp.AbstractFactory;

public class HybridVehicle implements Vehicle{
    private CarBodyType type;

    public HybridVehicle(CarBodyType type) {
        this.type = type;
    }

    @Override
    public void drive() {
        System.out.println("Driving an hybrid " + type);

    }

    @Override
    public void fillup() {
        System.out.println("your hybrid " +
                type + " is fueling or charging...");
    }

    @Override
    public void greetDriver() {

    }

    @Override
    public String toString() {
        return "HybridVehicle{" +
                "type=" + type +
                '}';
    }
}
