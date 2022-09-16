package com.Java8.Streams;

import java.util.ArrayList;
import java.util.Arrays;
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

class Employee {
    String name;
    char grade;
    Integer salary;

    public Employee(String name, char grade, Integer salary) {
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
        //Shortcircuited methods gives results earlier than we think
        //allMatch() a bunch of chained && operations.
        IntStream.of(1, 2, 3).allMatch(num -> num%2 == 0);
        //anyMatch() bunch of chained || operations
        IntStream.of(1, 2, 3).anyMatch(num -> num%2 == 0);
        //noneMatch
        IntStream.of(1, 2, 3).noneMatch(num -> num%2 == 0);
        //Reduce
        IntStream.of(1,2,3).reduce(0, (a, b) -> a+b);
        //Generate infinite stream
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        //Advantages
        //Streams defer most operations until you actually needs the results
        List<Employee> employees = Arrays.asList(
                new Employee("Jeff Bezos", 'A', 500000),
                new Employee("Larry Ellison", 'A', 400000),
                new Employee("Billy", 'C', 150000),
                new Employee("Mark Zuckerberg", 'B', 300000),
                new Employee("Elon Musk", 'A', 250000)
        );

        employees.stream().filter(employee -> employee.getGrade() < 'B')
                .filter(employee -> employee.getSalary() > 100000)
                .filter(employee -> employee.getName() != null)
                .map(Employee::getName)
                .findFirst()
                .orElse("No Employees are overpaid!");

        // we can use only when operation is stateless, associative, and non-interfacing
        //nums.stream().parallel();
        //nums.parallelStream();
    }
}
