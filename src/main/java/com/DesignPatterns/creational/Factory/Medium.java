package com.DesignPatterns.creational.Factory;
//Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
//https://medium.com/@sahoosunilkumar/understanding-factory-method-design-pattern-6e247b1fb9f
public class Medium {
}

class Payment {
    public Payment(){
        initializePaytm();
    }

    private void initializePaytm(){
        //setup with paytm server
        System.out.println("paytm server initialized");
    }

    public void pay(){
        System.out.println("pay by paytm!");
    }
}

class Payment2 {
    public Payment2(){
        intializePaytm();
        initializePaypal();
        initializeGpay();
    }

    private void initializeGpay() {
        //setup with gpay server
        System.out.println("gpay server initialized");
    }

    private void initializePaypal() {
        //setup with paypal server
        System.out.println("paypal server initialized");
    }

    private void intializePaytm() {
        //setup with paytm server
        System.out.println("paytm server initialized");
    }

    public void payUsingPaytm(){
        System.out.println("pay by paytm!");
    }

    public void payUsingPaypal(){
        System.out.println("pay by paypal!");
    }

    public void payUsingGpay(){
        System.out.println("pay by Gpay!");
    }
}

class PaytmPayment {
    public PaytmPayment(){
        initializePaytm();
    }

    private void initializePaytm() {
        System.out.println("paytm server intialized!");
    }

    public void payUsingPaytm(){
        System.out.println("pay by paytm!");
    }

}

class GooglePayPayment {
    public GooglePayPayment() {
        initializeGooglePay();
    }
    private void initializeGooglePay() {
        // setup with paytm server
        System.out.println("googlepay server initialized");
    }

    public void payUsingGooglePay() {
        System.out.println("pay by googlepay");
    }

}

class PaypalPayment {
    public PaypalPayment() {
        initializePaypal();
    }
    private void initializePaypal() {
        // setup with paytm server
        System.out.println("paypal server initialized");
    }

    public void payUsingPayPal() {
        System.out.println("pay by paypal");
    }

}

interface IPayment {
    void pay();
}

abstract class Payment3 implements IPayment {
    public Payment3() {
        initialize();
    }

    protected abstract void initialize();
}

class PaytmPayment3 extends Payment3{
    public PaytmPayment3() {
        super();
    }

    @Override
    protected void initialize() {
        // setup with paytm server
        System.out.println("paytm server initialized");
    }

    @Override
    public void pay() {
        System.out.println("pay by paytm");
    }

}

class GooglePayPayment3 extends Payment3 {
    public GooglePayPayment3() {
        super();
    }

    @Override
    protected void initialize() {
        // setup with paytm server
        System.out.println("googlepay server initialized");
    }

    @Override
    public void pay() {
        System.out.println("pay by googlepay");
    }

}

class PaypalPayment3 extends Payment3 {
    public PaypalPayment3() {
        super();
    }

    @Override
    protected void initialize() {
        // setup with paytm server
        System.out.println("paypal server initialized");
    }

    @Override
    public void pay() {
        System.out.println("pay by paypal");
    }

}

class FactoryPayment {
    public static IPayment createPayment(PaymentType paymentType){
        IPayment iPayment = null;
        switch (paymentType){
            case PAYTM :
                iPayment = new PaytmPayment3();
                break;
            case PAYPAL:
                iPayment = new PaypalPayment3();
                break;
            case GOOGLEPAY:
                iPayment = new GooglePayPayment3();
                break;
            default:
                iPayment = new PaytmPayment3();
                break;
        }
        return iPayment;
    }
}

enum PaymentType {
    PAYTM, PAYPAL, GOOGLEPAY
}


class MakePayment {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.pay();

        PaytmPayment paytmPayment = new PaytmPayment();
        paytmPayment.payUsingPaytm();

        GooglePayPayment googlePayPayment = new GooglePayPayment();
        googlePayPayment.payUsingGooglePay();;

        PaypalPayment paypalPayment = new PaypalPayment();
        paypalPayment.payUsingPayPal();

        IPayment payment1 = FactoryPayment.createPayment(PaymentType.GOOGLEPAY);
        payment1.pay();
        IPayment payment2 = FactoryPayment.createPayment(PaymentType.PAYTM);
        payment2.pay();
        IPayment payment3 = FactoryPayment.createPayment(PaymentType.PAYPAL);
        payment3.pay();
    }
}