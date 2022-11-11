package com.LambdaAndStream.Lambdas;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Lambda expresssion is an instance of a functional interface
// it is still an implementation of an interface
// 43 functional interfaces
// 1. consumer, 2. supplier, 3. functions, 4. predicate
public class LambdaExamples {
    public static void main(String[] args) {
        //JDK 7 way
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()<20;
            }
        } ;
        //Lambda expression
        Predicate<String> p1 = (String s) -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() < 20;


        //Consumer Object -> refer image
        Consumer<String> consumer = s -> System.out.println(s);

        //Supplier object -> refer image
        Supplier<Person>  supplier = () -> new Person();

        //Function object -> refer image
        Function<Person, Integer> function = person -> person.getAge();

        //Predicate -> refer image
        Predicate<Person> a = person ->  person.getAge()<20;
    }
}

class Person{
    private Integer age;

    public Integer getAge() {
        return age;
    }
}
