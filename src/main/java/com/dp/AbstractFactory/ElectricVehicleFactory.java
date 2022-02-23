package com.dp.AbstractFactory;

class ElectricVehicleFactory {
    private ElectricVehicleFactory(){}
    static Vehicle GetInstance(CarBodyType type){
        switch (type){
            case SUV:
                return new ElectricSUV();
            case Sedan:
                return new ElectricSedan();
            default:
                throw new UnsupportedOperationException(
                        "enum " + type + "not supported.");
        }
    }
}

