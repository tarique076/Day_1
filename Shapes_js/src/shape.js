class Rectangle{
    
    constructor(length, breadth) {
        if(length<=0 || breadth<=0 || typeof length !== 'number' || typeof breadth !== 'number'){
            throw new Error('Length and breadth must be positive integers.');
        }
        this.length = length;
        this.breadth = breadth;
    }

    area() {
        return this.length*this.breadth;
    }

    circumference() {
        return 2*(this.length+this.breadth);
    }
};

class Circle{

    constructor(radius){
        if(radius<=0 || typeof radius !== 'number'){
            throw new Error('Radius must be a positive integer');
        }
        this.radius = radius;
    }

    area(){
        return Math.PI * Math.pow(this.radius,2);
    }

    circumference(){
        return 2*Math.PI*this.radius;
    }
}

class Triangle{

    constructor(sideA, sideB, sideC){
        if(sideA==0 || sideB == 0 || sideC==0)
            throw new Error('All sides must be non negative.');

        if(sideA+sideB<=sideC || sideB+sideC<=sideA || sideA+sideC<=sideB){
            throw new Error('Sum of two sides must always be greater than third side.');
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    area(){
        let semiPerimeter = (this.sideA+this.sideB+this.sideC)/2;

        return Math.sqrt(semiPerimeter*(semiPerimeter-this.sideA)*(semiPerimeter-this.sideB)*(semiPerimeter-this.sideC));
    }

    circumference(){
        return this.sideA+this.sideB+this.sideC;
    }
}

module.exports={
    Rectangle,
    Circle,
    Triangle
};