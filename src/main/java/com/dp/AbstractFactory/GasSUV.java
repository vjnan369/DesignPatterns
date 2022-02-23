package com.dp.AbstractFactory;

class GasSUV extends GasVehicle {
    GasSUV() {
        super(CarBodyType.SUV);
    }
    @Override
    public void greetDriver() {
        System.out.println("Greeting from your gas "
                + CarBodyType.SUV);
    }
}
