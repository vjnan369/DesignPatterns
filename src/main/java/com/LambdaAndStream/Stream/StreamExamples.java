package com.LambdaAndStream.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(25, "Male"));
        personList.add(new Person(35, "Female"));
        personList.add(new Person(5, "Male"));
        personList.add(new Person(50, "Female"));

        //Group by Gender
        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getGender)));

        //Group by gender with count
        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting())));

        //list of persons belongs to Male with age>20
        List<Person> peopleList = personList.stream().filter(p -> p.getAge()>20).filter(p -> p.getGender().equalsIgnoreCase("Male")).collect(Collectors.toList());
        System.out.println(peopleList.size());

        //Multiply all ages for female
        List<Person> multipleAge = personList.stream().filter(p -> p.getGender().equalsIgnoreCase("Female")).map(p -> p.multiply(p.getAge())).collect(Collectors.toList());
        System.out.println(multipleAge.get(0).getAge());

        //flatmap

//        List<Product> result = orderRepo.findAll()
//                .stream()
//                .filter(o -> o.getCustomer().getTier() == 2)
//                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
//                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
//                .flatMap(o -> o.getProducts().stream())
//                .distinct()
//                .collect(Collectors.toList());


        //return lowest age from people
        Person person = personList.stream().sorted(Comparator.comparing(Person::getAge)).findFirst().get();
        Person person2 = personList.stream().max(Comparator.comparing(Person::getAge)).get();
        Person person3 = personList.stream().min(Comparator.comparing(Person::getAge).reversed()).get();
        System.out.println(person.getAge());
        System.out.println(person2.getAge());

        //3 recent placed orders
        //order.stream().sorted(Comparator.comparing(o -> o.getOrderDate()).reversed()).limit(3).collect(Collectors.toList());

        //Generate map with age and gender
        Map<Integer, String> result =
                personList.stream().collect(Collectors.toMap(p -> p.getAge(), p -> p.getGender()));


        //Get the most expensive product by category
//        product.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice))));

    }


}
