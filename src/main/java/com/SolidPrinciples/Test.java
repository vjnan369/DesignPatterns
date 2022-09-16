package com.SolidPrinciples;
//SOLID
//Liscov substitution principle
public class Test{}

@FunctionalInterface
interface TestInterface{
    void testMethod(int data);
}


class MainTester{
    public static void main(String[] args) {
        TestInterface testInterface = (data) -> System.out.println("this is teset method! " + data);

        testInterface.testMethod(23);
    }
}




