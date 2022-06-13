package model.queue;

import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void pushTest(){
        Queue queue = new Queue();
        for(int i = 1 ; i< 100; i++)
        {
            Queue.push(queue,i);
        }
        Queue.printQueue(queue);
        for(int i = 1 ; i< 50; i++)
        {
            Queue.pop(queue);
        }
        Queue.printQueue(queue);


    }
}