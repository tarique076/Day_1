package org.example.shapes;

public class Circle {

    private Integer radius;

    public Circle(Integer radius) {
        if(radius == 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    public double area() {
        return Math.PI*this.radius*this.radius;
    }

    public double circumference() {
        return 2*Math.PI*this.radius;
    }
}
