package model.linkedlist;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {
    @Test
    void test()
    {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        SinglyLinkedList.insert(linkedList,1);
        SinglyLinkedList.insert(linkedList,2);
        SinglyLinkedList.insert(linkedList,3);
        SinglyLinkedList.insert(linkedList,4);
        SinglyLinkedList.delete(linkedList,3);
        SinglyLinkedList.reverseList(linkedList);
        SinglyLinkedList.find(linkedList,1);
        SinglyLinkedList.printList(linkedList);
    }

}