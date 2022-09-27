package com.DesignPatterns.Behavioral.Strategy;
//https://medium.com/swlh/practical-introduction-to-strategy-design-pattern-using-java-bb664b3f2889
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



