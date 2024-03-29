package com.DesignPatterns.structural.Proxy;

//https://medium.com/sde-base/proxy-pattern-in-java-94fa47f38d95
//Proxy design pattern is used to control access to another object, which may be secure, expensive etc to create.
//The Proxy design pattern is part of the Structural Design Pattern Family, it let us create a placeholder or substitute for a real object
public class Medium3 {

}

interface IInternet{
    boolean connectTo(String host);
}

class RealInternet implements IInternet{

    @Override
    public boolean connectTo(String host) {
        if(connected(host))
            return true;
        return false;
    }

    private boolean connected(String host){
        return true;
    }
}

class ProxyInternet implements IInternet{

    @Override
    public boolean connectTo(String host) {
        RealInternet internet_connector;
        if(host.toLowerCase().contains("jnanweb.com")){
            //redirect to intranet server
            System.out.println("proxy called");
        } else {
            internet_connector = new RealInternet();
            return internet_connector.connectTo(host);
        }
        return false;
    }
}

class Tester{
    public static void main(String[] args) {
        IInternet connection = new ProxyInternet();
        connection.connectTo("www.jnanweb.com/result");
    }
}
