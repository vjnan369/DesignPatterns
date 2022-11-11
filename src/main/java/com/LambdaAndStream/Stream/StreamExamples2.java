package com.LambdaAndStream.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples2 {
    public static void main(String[] args) {
        //Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9);
        List<Integer> answer = list.stream().filter(l -> l%2 == 0).collect(Collectors.toList());
        System.out.println(answer);
        list.stream().filter(l -> l%2 == 0).forEach(System.out::println);

        //Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        System.out.println("-------starts with 1------");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 15, 6, 17, 9);
        list2.stream().map(l -> l + "").filter( l -> l.startsWith("1")).map(l -> Integer.parseInt(l)).forEach(System.out::println);

        //Q3 How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("-------duplicate elements------");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 17, 1, 6, 17, 6);
        Set<Integer> set = new HashSet<>();
        list3.stream().filter(l -> !set.add(l)).forEach(System.out::println);
        System.out.println("-------remove duplicate and return elements------");
        Set<Integer> set2 = new HashSet<>();
        list3.stream().filter(l -> set2.add(l)).forEach(System.out::println);

        //Q4 Given the list of integers, find the first element of the list using Stream functions?
        System.out.println("--------find first element of list -----------");
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 17, 1, 6, 17, 6);
        list4.stream().findFirst().ifPresent(System.out::println);

        //Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println("--------find total number of elements-----------");
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 17, 1, 6, 17, 6);
        System.out.println(list5.stream().count());

        //Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.println("--------find maximum elements-----------");
        List<Integer> list6 = Arrays.asList(1, 2, 3, 4, 17, 1, 6, 17, 6);
        System.out.println(list6.stream().max((a,b) -> a.compareTo(b)).get());

        //Q7 Given a list of integers, sort all the values present in it in descending order using Stream functions?
        System.out.println("--------sort elements-----------");
        List<Integer> list7 = Arrays.asList(1, 2, 3, 4, 17, 1, 6, 17, 6);
        list7.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

    }
}
