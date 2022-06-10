package model.linkedlist;

import org.junit.jupiter.api.Test;

class LinkedListTest {
    @Test
    void insertTest()
    {
        LinkedList linkedList = new LinkedList();
        LinkedList.insert(linkedList,1);
        LinkedList.printList(linkedList);
    }

}