package org.example.shapes;

public class Circle {

    private Integer radius;

    public Circle(Integer radius) {
        if(radius == 0) throw new IllegalArgumentException();
        this.radius = radius;
    }


}
