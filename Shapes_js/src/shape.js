class Rectangle{
    
    constructor(length, breadth) {
        if(length<=0 || breadth<=0 || typeof length !== 'number' || typeof breadth !== 'number'){
            throw new Error('Length and breadth must be positive integers.');
        }
        this.length = length;
        this.breadth = breadth;
    }

    
}