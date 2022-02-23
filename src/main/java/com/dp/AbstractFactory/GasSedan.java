package com.dp.AbstractFactory;

class GasSedan extends GasVehicle {
    GasSedan() {
        super(CarBodyType.Sedan);
    }
    @Override
    public void greetDriver() {
        System.out.println("Greeting from your gas "
                + CarBodyType.SUV);
    }
}
