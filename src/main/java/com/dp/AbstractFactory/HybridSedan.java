package com.dp.AbstractFactory;

class HybridSedan extends HybridVehicle {
    HybridSedan() {
        super(CarBodyType.Sedan);
    }
    @Override
    public void greetDriver() {
        System.out.println("Greeting from your hybrid "
                + CarBodyType.Sedan);
    }
}