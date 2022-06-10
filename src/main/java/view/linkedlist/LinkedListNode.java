package view.linkedlist;

import model.stack.Stack;

/**
 * @author aiden
 */
public class LinkedListNode {
    public Node head;
    public static class Node {
        public final Object val;
        public Node next;
        public Node(Object d) {
            val = d;
            next = null;
        }
    }

    public static void print(Stack stack)
    {
        Node curr = stack.head;
        while(curr != null)
        {
            System.out.print( curr.val + " ");
            curr=curr.next;
        }
        System.out.print('\n');
    }
}
