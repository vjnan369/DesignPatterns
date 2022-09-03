package com.DesignPatterns.structural.Proxy;

//https://anmolsehgal.medium.com/proxy-design-pattern-java-with-example-c672da3c195f
//Proxy design pattern is used to control access to another object, which may be secure, expensive etc to create.
public class Medium {
}

interface User {
    void checkout();
}

class AuthorizedUser implements User {

    @Override
    public void checkout() {
        System.out.println("checking out the product!");
    }
}

class GuestUser implements User {

    @Override
    public void checkout() {
        System.out.println("show the registration page!");
    }
}

interface UserProxy {
    User getUser();
}

class UserProxyHandler implements UserProxy {
    private boolean isLoggedIn;

    public UserProxyHandler(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public User getUser() {
        User user;
        if(isLoggedIn){
            user = new AuthorizedUser();
        } else {
            user = new GuestUser();
        }
        return user;
    }
}

class ProxyTester {
    public static void main(String[] args) {
        boolean isLoggedIn = true;
        User user = new UserProxyHandler(isLoggedIn).getUser();
        user.checkout();
    }
}