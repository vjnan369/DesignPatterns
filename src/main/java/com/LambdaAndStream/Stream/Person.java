package com.LambdaAndStream.Stream;

public class Person {
    private int age;
    private String gender;

    public Person(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    Person multiply(Integer age){
        this.age = 2*age;
        return this;
    }
}
