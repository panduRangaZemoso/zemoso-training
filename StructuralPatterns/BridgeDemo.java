package StructuralPatterns;

public class BridgeDemo {

    public static void main(String[] args){
        Colour green = new Green();
        Colour blue = new Blue();

        Shape s1 = new Circle(green, 3);
        Shape s2 = new Rectangle(blue, 2, 3);

        s1.displayShape();
        s2.displayShape();

        s1.setColour(blue);
        s1.displayShape();

    }
}

abstract class Shape{
    int area;
    String shapeType;
    Colour colour;

    public Shape(Colour colour) {
        this.colour = colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    abstract int computeArea();

    public void displayShape() {
        System.out.println(this.shapeType+" filled with "+colour.fillColour());
    }

}

class Circle extends Shape{

    int radius;

    public Circle(Colour colour, int radius) {
        super(colour);
        this.radius = radius;
        this.shapeType= "Circle";
    }

    @Override
    int computeArea() {
        return (22/7)*radius*radius;
    }
}

class Rectangle extends Shape{
    int length;
    int breadth;

    public Rectangle(Colour colour, int length, int breadth) {
        super(colour);
        this.length = length;
        this.breadth = breadth;
        this.shapeType = "Rectangle";
    }

    @Override
    int computeArea() {
        return length*breadth;
    }
}

interface Colour{
    String fillColour();
}

class Green implements  Colour{

    @Override
    public String fillColour() {
        return "green colour";
    }
}

class Blue implements  Colour{

    @Override
    public String fillColour() {
        return "blue colour";
    }
}