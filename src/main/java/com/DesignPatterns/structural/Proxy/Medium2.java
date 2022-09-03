package com.DesignPatterns.structural.Proxy;
//https://medium.com/javarevisited/how-to-implement-proxy-design-pattern-using-java-719c06a0ae34
//The Proxy design pattern is part of the Structural Design Pattern Family, it let us create a placeholder or substitute for a real object
//The proxy design pattern allows us to follow the Design Principle (SOLID).
public class Medium2 {
}

class PackageInfo{
    private String size;
    private String weight;

    public PackageInfo(String size, String weight) {
        this.size = size;
        this.weight = weight;
    }

    public PackageInfo() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}

interface PackageDelivery {
    String deliveryWay(PackageInfo packageInfo);
}

class BicycleDelivery implements PackageDelivery{

    @Override
    public String deliveryWay(PackageInfo packageInfo) {
        return "delivery by bicycle!";
    }
}

class CarDelivery implements PackageDelivery {

    @Override
    public String deliveryWay(PackageInfo packageInfo) {
        return "delivery by car!";
    }
}

class TruckDelivery implements PackageDelivery {

    @Override
    public String deliveryWay(PackageInfo packageInfo) {
        return "delivery by truck!";
    }
}
//PROXY CLASS
class DeliveryManager {
    String deliveryManagerProxy(PackageInfo packageInfo){
        switch (packageInfo.getSize()){
            case "SMALL" :
                return new BicycleDelivery().deliveryWay(packageInfo);
            case "MEDIUM" :
                return new CarDelivery().deliveryWay(packageInfo);
            case "LARGE" :
                return new TruckDelivery().deliveryWay(packageInfo);
            default:
                return "UNABLE_TO_DELIVER!";
        }
    }
}

class ProxyTester2{
    public static void main(String[] args) {
        DeliveryManager deliveryManager = new DeliveryManager();
        System.out.println(deliveryManager.deliveryManagerProxy(new PackageInfo("LARGE", "20KG")));
    }
}