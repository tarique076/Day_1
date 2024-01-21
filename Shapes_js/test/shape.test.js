const {Rectangle} = require("../src/shape");

describe('Rectangle', () => {
    test('Expect error for non-positive sides', () =>{
        expect(()=> new Rectangle(0,8).toThrow('Length and breadth must be positive integers.'));
    });

    
})