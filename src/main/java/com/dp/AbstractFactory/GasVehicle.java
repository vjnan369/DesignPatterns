package com.dp.AbstractFactory;

public class GasVehicle implements Vehicle{
    private CarBodyType type;

    public GasVehicle(CarBodyType type) {
        this.type = type;
    }

    @Override
    public void drive() {
        System.out.println("Driving an gas " + type);

    }

    @Override
    public void fillup() {
        System.out.println("your gas " +
                type + " is fueling...");
    }

    @Override
    public void greetDriver() {

    }

    @Override
    public String toString() {
        return "GasVehicle{" +
                "type=" + type +
                '}';
    }
}
