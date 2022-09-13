package com.DesignPatterns.structural.Bridge;
//Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.
//https://medium.com/@amritlalsahu5/bridge-design-pattern-9afad7138777
//Decouples an abstraction from its implementation so that the two can vary independently
public class Medium {
}


interface IShapeColor{
    void fillColor();
}
abstract class Shape {
    protected IShapeColor color;

    public Shape(IShapeColor color) {
        this.color = color;
    }

    abstract void applyColor();
}

class Circle extends Shape{

    public Circle(IShapeColor color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.println("circle filled with ");
        color.fillColor();
    }
}

class Rectangle extends Shape {

    public Rectangle(IShapeColor color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.println("rectangle filled with ");
        color.fillColor();
    }
}

class ColorRedImpl implements IShapeColor{

    @Override
    public void fillColor() {
        System.out.println("Red Color ");
    }
}

class ColorBlueImpl implements IShapeColor{

    @Override
    public void fillColor() {
        System.out.println("Blue Color ");
    }
}

class ColorGreenImpl implements IShapeColor{

    @Override
    public void fillColor() {
        System.out.println("Green Color ");
    }
}

class BridgeTester{
    public static void main(String[] args) {
        Shape s1 = new Rectangle(new ColorRedImpl());
        Shape s2 = new Rectangle(new ColorBlueImpl());
        Shape s3 = new Rectangle(new ColorGreenImpl());

        s1.applyColor();
        s2.applyColor();
        s3.applyColor();

        Shape s4 = new Circle(new ColorGreenImpl());
        Shape s5 = new Circle(new ColorBlueImpl());
        Shape s6 = new Circle(new ColorRedImpl());
        s4.applyColor();
        s5.applyColor();
        s6.applyColor();
    }
}
