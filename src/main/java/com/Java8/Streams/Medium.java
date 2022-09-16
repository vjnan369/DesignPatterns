package com.Java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Student{
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

//https://medium.com/javarevisited/java-streams-for-beginners-105ed3aa2f74
//https://medium.com/@bpnorlander/java-a-guide-to-streams-a94e2895a25d
//intermediate operations: peek, flatmap, limit, sort, distinct, map, filter
//terminal operations: noneMatch, allMatch, collect, findAny, findFirst, anyMatch,
//toArray, reduce, min, max, forEach, collect, count etc.
public class Medium {
    private static Student takeAttendance(Student student){
        return student;
    }
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("jnan", 26));
        studentList.add(new Student("raj", 22));
        studentList.add(new Student("sujith", 82));
        Stream.of(studentList);
        //forEach() -> terminal operator
        studentList.forEach(s -> takeAttendance(s));
        //peek() - intermediate operator
        studentList.stream().peek(s -> takeAttendance(s))
                        .map(s -> s.getAge()).forEach(System.out::println);
        //collect()
        studentList.stream().filter(student -> student.age>25).map(Student::getName).collect(Collectors.toList());
        //filter() -> predicate
        studentList.stream().filter(s -> s.getAge()<30).map(Student::getName).collect(Collectors.toList());
        //map
        studentList.stream().map(Student::getName).collect(Collectors.toList());
        //skip
        studentList.stream().skip(1).collect(Collectors.toList());
        //Stream specialiazation for primitive types
        //sorted(), min(), max(), and sum().
        //int[] sortedNums = IntStream.of(nums).sorted();
        IntStream.of(1,2,3);
        IntStream.range(5, 10);
        //creates an IntStream from a Stream
        int totalAge = studentList.stream().mapToInt(Student::getAge).sum();
        //allMatch() a bunch of chained && operations.
        IntStream.of(1, 2, 3).allMatch(num -> num%2 == 0);
        //anyMatch() bunch of chained || operations
        IntStream.of(1, 2, 3).anyMatch(num -> num%2 == 0);
        //noneMatch
        IntStream.of(1, 2, 3).noneMatch(num -> num%2 == 0);
    }
}
