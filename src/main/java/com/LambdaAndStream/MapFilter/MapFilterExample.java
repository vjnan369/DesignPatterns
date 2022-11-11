package com.LambdaAndStream.MapFilter;

import java.util.ArrayList;
import java.util.List;

public class MapFilterExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(25));
        personList.add(new Person(35));
        personList.add(new Person(5));
        personList.add(new Person(50));

        // average of age of people older than 20;
        // list -> map -> age -> filter -> age>20 -> reduce -> avg

        System.out.println(personList.stream().map(Person::getAge).filter(age -> age>20).reduce((a1, a2) -> a1 + a2).get());
    }
}
