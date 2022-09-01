package com.SolidPrinciples.ISP;

//Interface Segregation Principle (ISP)
//do not force any client to implement an interface which is irrelevant to them
//https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97
public class Medium {}

interface UPIPayments {
    public void payMoney();
    public void getScratchCard();
    public void getCashBackIntoAccount();
}

class GooglePay implements UPIPayments {

    @Override
    public void payMoney() {}

    @Override
    public void getScratchCard() {}

    @Override
    public void getCashBackIntoAccount() {}
}

//paytm doesnt support get cashback into account feature, which is violation
class Paytm implements UPIPayments {

    @Override
    public void payMoney() {}

    @Override
    public void getScratchCard() {}

    @Override
    public void getCashBackIntoAccount() {
        //not applicable
    }
}

//Solution
interface UPIPayments2 {
    public void payMoney();
    public void getScratchCard();
}

interface CashBackManager {
    public void getCashBackIntoAccount();
}

class Paytm2 implements UPIPayments2 {

    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }
}

class GooglePay2 implements CashBackManager, UPIPayments2 {

    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackIntoAccount() {

    }
}






