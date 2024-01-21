package org.example.shapes;

public class Rectangle {

    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {
        if(length ==0 || breadth == 0){
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.breadth = breadth;
    }

    public int area(){
        return this.length*this.breadth;
    }

    public int circumference(){
        return 2*(this.length+this.breadth);
    }

    public Rectangle(int length) {
        if(length==0){
            throw new IllegalArgumentException();
        }
        this.length = length;
    }
}
