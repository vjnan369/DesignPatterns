package com.dp.AbstractFactory;

class ElectricSUV extends ElectricVehicle {
    ElectricSUV(){
        super(CarBodyType.SUV);
    }
    @Override
    public void greetDriver() {

        System.out.println("Greeting from your electric "
                + CarBodyType.SUV);
    }
}
