package com.LambdaAndStream.Lambdas;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class BasicComparator {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        Comparator<String> comparator1 = ( s1,  s2) -> Integer.compare(s1.length(), s2.length());

        Runnable runnable = new Runnable(){
            public void run(){
                System.out.println("this is runnable method!");
            }
        };

        Runnable runnable1 = () -> System.out.println("sdfds");

        //Method references
        Function<Person, Integer> f = person -> person.getAge();

        Function<Person, Integer> f2 = Person::getAge;

        Consumer<String> printer = s -> System.out.println(s);

        Consumer<String> printer2 = System.out::println;
    }


    class Person{
        private Integer age;

        public Integer getAge() {
            return age;
        }
    }
}
