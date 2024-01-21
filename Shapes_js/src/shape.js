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


module.exports={
    Rectangle,
    Circle
};