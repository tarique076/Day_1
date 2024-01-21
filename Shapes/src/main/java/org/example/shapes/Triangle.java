package org.example.shapes;

public class Triangle {

    private Integer sideA;
    private Integer sideB;
    private Integer sideC;

    public Triangle(Integer sideA, Integer sideB, Integer sideC) {
        if(sideA==0 || sideB == 0 || sideC==0)
            throw new IllegalArgumentException();

        if(sideA+sideB<=sideC || sideB+sideC<=sideA || sideA+sideC<=sideB){
            throw new IllegalArgumentException();
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double area(){
        double semiPerimeter = (sideA+sideB+sideC)/2;

        return Math.sqrt(semiPerimeter*(semiPerimeter-sideA)*(semiPerimeter-sideB)*(semiPerimeter-sideC));
    }

}
