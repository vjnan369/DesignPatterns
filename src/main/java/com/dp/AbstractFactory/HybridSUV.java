package com.dp.AbstractFactory;

class HybridSUV extends HybridVehicle {
    HybridSUV() {
        super(CarBodyType.SUV);
    }
    @Override
    public void greetDriver() {
        System.out.println("Greeting from your hybrid "
                + CarBodyType.SUV);
    }
}
