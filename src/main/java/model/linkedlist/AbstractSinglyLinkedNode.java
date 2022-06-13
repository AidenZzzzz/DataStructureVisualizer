package model.linkedlist;

import model.stack.Stack;

/**
 * @author aiden
 */
public abstract class AbstractSinglyLinkedNode {
    public Node head;
    public static class Node {
        public final Object val;
        public Node next;
        public Node(Object d) {
            val = d;
            next = null;
        }
    }

    public static void print(AbstractSinglyLinkedNode object)
    {
        Node curr = object.head;
        while(curr != null)
        {
            System.out.print( curr.val + " ");
            curr=curr.next;
        }
        System.out.print('\n');
    }
}
