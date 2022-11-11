package com.SolidPrinciples;

public class DependencyInversionPrinciple {
}


class LogWriter{
    public void write(String message){
        //write event logs here
    }
}

//This violates dependency inversion principle . i.e. the high level module depends on
//LogWriter which is a concrete class and not an abstraction.
//If we required to add new feature to send email notification or sms notification it will be a problem.
//Dependency INversion principle says higher level modules should depend on simple abstraction
class ServerWatcher{
    LogWriter logWriter = null;

    //this function will call when there is a problem is occured
    public void notify(String message){
        if(logWriter == null){
            logWriter = new LogWriter();
        }
        logWriter.write(message);
    }
}


interface NotificationWriter{
    public void writeNotification(String message);
}

class EmailNotificationWriter implements NotificationWriter{

    @Override
    public void writeNotification(String message) {
        //implementation of email notification
    }
}

//The concrete class creation is still inside the higher level class
class ServerWatcher2{
    NotificationWriter logWriter = null;

    //this function will call when there is a problem is occured
    public void notify(String message){
        if(logWriter == null){
            // Here we will map the abstraction i.e. interface to concrete class
            logWriter = new EmailNotificationWriter();
        }
        logWriter.writeNotification(message);
    }
}

//Dependency Injection:
/*
Dependency injection can be done in three ways.

Constructor injection
Method injection
Property injection
 */
class ServerWatcher3{
    NotificationWriter logWriter = null;

    public ServerWatcher3(NotificationWriter concreteImplementation){
        this.logWriter = concreteImplementation;
    }

    public void notify(String message){
        logWriter.writeNotification(message);
    }
}

class Main{
    public static void main(String[] args) {
        EmailNotificationWriter writer = new EmailNotificationWriter();
        ServerWatcher3 watcher3 = new ServerWatcher3(writer);
        watcher3.notify("server is crashed!");
    }
}
