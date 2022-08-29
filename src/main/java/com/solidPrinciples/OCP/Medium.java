package com.solidPrinciples.OCP;
// Classess/Modules/functions Open for extension and closed for modification
//https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97
public class Medium {}

class NotificationService{
    //OCP violation if we want mobile/whatsapp based notification
    public void sendNotification(String medium){
        if(medium.equals("email")){
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}

interface NotificationService2 {
    public void sendNotification(String medium);
    public void sendTransactionNotification(String medium);
}

class EmailNotification implements NotificationService2 {

    @Override
    public void sendNotification(String medium) {
        //write email notification logic
    }

    @Override
    public void sendTransactionNotification(String medium) {

    }
}

class WhatsAppNotification implements NotificationService2 {

    @Override
    public void sendNotification(String medium) {
        //write whatsapp notification logic
    }

    @Override
    public void sendTransactionNotification(String medium) {

    }
}


