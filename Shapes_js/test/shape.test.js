const {Rectangle, Circle} = require("../src/shape");

describe('Rectangle', () => {
    test('Expect error for non-positive sides', () =>{
        expect(()=> new Rectangle(0,8).toThrow('Length and breadth must be positive integers.'));
    });

    test('Expect area 35 for sides 5 and 7', () => {
        let expected = 5*7;
        const rectangle = new Rectangle(5,7);
        expect(rectangle.area()).toBe(expected);
    });

    test('Expect area 40 for sides 5 and 8', () => {
        let expected = 5*8;
        const rectangle = new Rectangle(5,8);
        expect(rectangle.area()).toBe(expected);
    });

    test('Expect circumference 26 for sides 5 and 8', () => {
        let expected = 2*(5+8);
        const rectangle = new Rectangle(5,8);
        expect(rectangle.circumference()).toBe(expected);
    });

    test('Expect circumference 24 for sides 5 and 7', () => {
        let expected = 2*(5+7);
        const rectangle = new Rectangle(5,7);
        expect(rectangle.circumference()).toBe(expected);
    });
})

describe('Circle', () => {
    test('Expect error for non-positive radius', () =>{
        expect(() => new Circle(0).toThrow('Radius must be a positive integer'));
    });

    test('Expect valid area of circle', () => {
        let expected = Math.PI * Math.pow(5,2);
        const circle = new Circle(5);
        expect(circle.area()).toBe(expected);
    });

    test('Expect valid area of circle', () => {
        let expected = Math.PI * Math.pow(8,2);
        const circle = new Circle(8);
        expect(circle.area()).toBe(expected);
    });

    test('Expect valid circumference', () => {
        let expected = 2*Math.PI*5;
        const circle = new Circle(5);
        expect(circle.circumference()).toBe(expected);
    });
    test('Expect valid circumference', () => {
        let expected = 2*Math.PI*8;
        const circle = new Circle(8);
        expect(circle.circumference()).toBe(expected);
    });
})
