package com.DesignPatterns.structural.Decorator;

//Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects
// inside special wrapper objects that contain the behaviors.
// Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.
public class Medium2 {
}

interface Notifier{
    public void sendNotification();
}

class BaseNotifier implements Notifier{

    @Override
    public void sendNotification() {
        System.out.println("notification processing completed!");
        System.out.println("===================================");
    }
}

class NotificationDecorator implements Notifier{
    Notifier notifier;

    public NotificationDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void sendNotification() {
        notifier.sendNotification();
    }
}

class SMSNotification extends NotificationDecorator{

    public SMSNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendNotification() {
        System.out.println("sending SMS notification!");
        super.sendNotification();
    }
}

class SlackNotification extends NotificationDecorator{

    public SlackNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendNotification() {
        System.out.println("sending Slack notification!");
        super.sendNotification();
    }
}

class FacebookNotification extends NotificationDecorator{

    public FacebookNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendNotification() {
        System.out.println("sending facebook notification!");
        super.sendNotification();
    }
}

class Tester{
    public static void main(String[] args) {
        Notifier notifier1 = new SMSNotification(new BaseNotifier());
        notifier1.sendNotification();

        Notifier notifier2 = new SlackNotification(new FacebookNotification(new BaseNotifier()));
        notifier2.sendNotification();

        Notifier notifier3 = new SMSNotification(new SlackNotification(new BaseNotifier()));
        notifier3.sendNotification();

        Notifier notifier4 = new FacebookNotification(new SMSNotification(new SlackNotification(new BaseNotifier())));
        notifier4.sendNotification();
    }
}
