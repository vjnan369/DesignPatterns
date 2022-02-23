package com.dp.AbstractFactory;

class GasVehicleFactory {
    private GasVehicleFactory(){}
    static Vehicle GetInstance(CarBodyType type){
        switch (type){
            case SUV:
                return new GasSUV();
            case Sedan:
                return new GasSedan();
            default:
                throw new UnsupportedOperationException("" +
                        "enum " + type + "not supported.");
        }
    }
}

