package com.dp.PrototypePattern;

// Allows you to create object by cloning an existing object instead of
// creating a new object form scratch. this is used when object creation process
// is costly.
public class Test {
    public static void main(String args[]){
        Human human1 = new Human("Jnan", "Jnan V", 25);
        Human human2 = (Human) human1.getClone();
    }
}
