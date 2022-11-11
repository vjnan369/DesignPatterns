package com.DesignPatterns.Behavioral.Strategy;
//https://medium.com/swlh/practical-introduction-to-strategy-design-pattern-using-java-bb664b3f2889
//Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class,
// and make their objects interchangeable.
//The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these
// algorithms into separate classes called strategies.
public class Medium2 {
}

interface RouteStrategy{
    public void buildRoute();
}

class RoadStrategy implements RouteStrategy{

    @Override
    public void buildRoute() {
        System.out.println("route is generated for road!");
    }
}

class WalkStrategy implements RouteStrategy{

    @Override
    public void buildRoute() {
        System.out.println("route is generated for walk!");
    }
}

class FlightStrategy implements RouteStrategy{

    @Override
    public void buildRoute() {
        System.out.println("route is generated for flight!");
    }
}

class Navigator{
    private RouteStrategy routeStrategy;

    public Navigator useStrategy(RouteStrategy routeStrategy){
        this.routeStrategy = routeStrategy;
        return this;
    }

    void showRoute(){
        routeStrategy.buildRoute();
    }
}

class Tester{
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        navigator.useStrategy(new FlightStrategy());
        navigator.showRoute();
        navigator.useStrategy(new RoadStrategy());
        navigator.showRoute();
        navigator.useStrategy(new WalkStrategy());
        navigator.showRoute();
    }
}



