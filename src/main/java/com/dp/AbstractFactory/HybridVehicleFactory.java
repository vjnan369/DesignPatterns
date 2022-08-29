package com.dp.AbstractFactory;

class HybridVehicleFactory {
    private HybridVehicleFactory(){}
    static Vehicle GetInstance(CarBodyType type){
        switch (type){
            case SUV:
                return new HybridSUV();
            case Sedan:
                return new HybridSedan();
            default:
                throw new UnsupportedOperationException(
                        "enum " + type + "not supported.");
        }
    }
}