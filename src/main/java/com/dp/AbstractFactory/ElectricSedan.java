package com.dp.AbstractFactory;

class ElectricSedan extends ElectricVehicle {
    ElectricSedan() {
        super(CarBodyType.Sedan);
    }
    @Override
    public void greetDriver() {
        System.out.println("Greeting from your electric "
                + CarBodyType.Sedan);
    }
}

