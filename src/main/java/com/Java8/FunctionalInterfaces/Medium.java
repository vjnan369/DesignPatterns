package com.Java8.FunctionalInterfaces;
//https://medium.com/@AADota/interfaces-in-java-8-introduction-to-functional-interface-3726fc0f22c

public class Medium {
}

//Default Methods
//Unlike abstract methods, default methods must have a body, and it is optional for the classes implementing that interface to override them.
interface DefaultInterface{
    default String checkDefault(){
        return "this is default method in interface!";
    }
}

//Addition of Static Methods
//They are similar to default methods, except we can not override them in the implementing classes. They are used to provide a generic, or well written implementation which we do not want our implementing classes to change.
interface StaticInterface{
    static String checkStatic(){
        return "this is static method in interface!";
    }
}

//Functional Interfaces
//A functional interface is basically an interface with only 1 abstract method in it. It can contain default methods, static methods, or override methods from the Object class, but restricted to only using 1 abstract method.
//A functional interface eliminates the need of writing anonymous classes and helps us write lambda expressions
//https://medium.com/swlh/functional-interfaces-and-lambda-expressions-java-8-series-part-1-4cc60f2542ba
@FunctionalInterface
interface FunctionalTestInterface{
    void functionalMethod();

    static void staticMethod(){
        System.out.println("static method!");
    }

    default void defaultMethod(){
        System.out.println("its a default method!");
    }
}

@FunctionalInterface
interface Calculator{
    int calculate(int n1, int n2);

    static double findSquareRoot(int n1){
        return Math.sqrt(n1);
    }
}

class LambdaTester{
    public static void main(String[] args) {
        double root = Calculator.findSquareRoot(25);
        System.out.println(root);
    }
}

class LambdaTester2 implements Calculator{
    public static void main(String[] args) {
        double root = Calculator.findSquareRoot(25);
        System.out.println(root);

        LambdaTester2 lambdaTester2 = new LambdaTester2();
        System.out.println(lambdaTester2.calculate(7, 3));

        Calculator calc = new Calculator() {
            @Override
            public int calculate(int n1, int n2) {
                return n1 + n2;
            }
        };
        System.out.println(calc.calculate(12, 13));

        Calculator calc2 = (n1, n2) -> {return n1 + n2;};
        Calculator calc3 = (n1, n2) -> n1 + n2;
        Calculator multiplier = (n1, n2) -> n1 * n2;
        Calculator subtractor = (n1, n2) -> n1 > n2 ? n1 - n2 : n2-n1;
        System.out.println(calc2.calculate(23, 22));
    }

    @Override
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }
}


//Method References
//Referring to static method.
//It is nothing but an easier way of writing a lambda expression. It is done by referring, the single abstract method, to another existing method. This is achieved with help of a double colon (::) operator introduced in Java 8

@FunctionalInterface
interface Calculator2{
    int calculate(int n1, int n2);
}

class Tester{
    int num1, num2;

    public Tester() {
    }

    public Tester(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    static int sum(int n1, int n2){
        return n1 + n2;
    }

    int multiply(){
        return num1*num2;
    }

    int subtract(int n1, int n2){
        return n1>n2 ? n1-n2 : n2-n1;
    }
    public static void main(String[] args) {
        Calculator2 c2 = Tester::sum;
        System.out.println(c2.calculate(11, 12));
        //This is very useful in terms of reusability. Instead of defining our very own sum method, we can also reuse the existing sum method of the Integer wrapper class which will basically give the same result —
        Calculator2 calculator2 = Integer::sum;
        System.out.println(calculator2.calculate(5, 7));

        //Referring to instance methods of objects

        Tester tester = new Tester();
        Calculator2 c3 = tester::subtract;
        System.out.println(c3.calculate(-5, 3));

        //Constructor references
        CalculatorFactory factory = Tester::new;
        Tester tester1 = factory.getMyCalculator(4, 5);
        System.out.println(tester1.multiply());

    }
}

//Constructor references
// is used to create an object of a named class by ‘referring’ to its constructor.
// A constructor reference helps us implement the factory pattern in a functional manner. We define a functional interface which acts as a factory

@FunctionalInterface
interface CalculatorFactory {

    Tester getMyCalculator(int num1, int num2);
}








