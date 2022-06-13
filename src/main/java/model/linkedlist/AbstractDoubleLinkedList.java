package model.linkedlist;

import model.queue.Queue;

/**
 * @author aiden
 */
public abstract class AbstractDoubleLinkedList {
    public Node head;
    public Node tail;
    public static class Node {
        public final Object val;
        public Node next;
        public Node prev;
        public Node(Object d) {
            val = d;
            next = null;
        }
    }

}
