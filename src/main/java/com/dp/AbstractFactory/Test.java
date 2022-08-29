package com.dp.AbstractFactory;

/* Its a way of grouping many similar factories into one factory with indicative parameters
https://medium.com/swlh/creational-design-pattern-abstract-factory-5e3f9b53cbf4
 */
public class Test {

    public static void main(String[] args) {
        Vehicle hybridSedan = VehicleFactory.CreateInstance(
                CarBodyType.Sedan,
                EnergyType.Hybrid);
        System.out.println(hybridSedan);
        hybridSedan.fillup();
        hybridSedan.greetDriver();
        hybridSedan.drive();
        Vehicle gasSUV = VehicleFactory.CreateInstance(
                CarBodyType.SUV,
                EnergyType.Gas);
        System.out.println(gasSUV);
        gasSUV.fillup();
        gasSUV.greetDriver();
        gasSUV.drive();
        Vehicle electricSedan = VehicleFactory.CreateInstance(
                CarBodyType.Sedan,
                EnergyType.Electric);
        System.out.println(electricSedan);
        electricSedan.fillup();
        electricSedan.greetDriver();
        electricSedan.drive();
    }
}
