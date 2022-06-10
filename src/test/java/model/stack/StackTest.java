package model.stack;

import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void stackTest()
    {
        Stack stack = new Stack();
        stack.push(stack,3);
        stack.push(stack,"2");
        stack.push(stack,1);

        stack.pop(stack);

        stack.print(stack);

        System.out.println(stack.find(stack,"2"));

    }

}