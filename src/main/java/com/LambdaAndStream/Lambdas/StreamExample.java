package com.LambdaAndStream.Lambdas;

import java.util.*;

public class StreamExample {
    public static void main(String[] args) {
        //Map -> getOrDefault(key, default);
        //Map -> putIfAbsent(key, value);
        //Map -> replace(key, newValue);
        //map -> remove(key, value);

        //Merge 2 map key values;
        Map<City2, List<Person2>> map1 = new HashMap<>();
        Map<City2, List<Person2>> map2 = new HashMap<>();


        map2.forEach(
                (key, value) ->
                        map1.merge(key, value,
                                (existingPeople, newPeople) -> {
                                    existingPeople.addAll(newPeople);
                                    return existingPeople;
                                }
                        )
        );


        List<Person2> person2 = new ArrayList<>();
        person2.removeIf(p -> p.getAge()<30);
        person2.replaceAll(p -> new Person2(21));
        person2.sort(Comparator.comparing(Person2::getAge).reversed());

        Map<City2, List<Person2>> map3 = new HashMap<>();

        City2 city2 = new City2("paris");

        map3.putIfAbsent(city2, new ArrayList<>());
        map3.get(city2).add(new Person2(22));

//        map3.computeIfAbsent(city2, city -> new ArrayList<>()).add(p2);
    }
}

class Person2{
    private Integer age;

    public Person2(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}

class City2{
    private String name;

    public City2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
