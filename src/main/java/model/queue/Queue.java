package model.queue;

import model.linkedlist.AbstractSinglyLinkedNode;

/**
 * @author aiden
 */
public class Queue extends AbstractSinglyLinkedNode {

    public static void push(Queue queue, Object val)
    {
        Node curr = queue.head;
        Node newNode = new Node(val);
        if (curr != null) {
            while(curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = newNode;

        }
        else {
            queue.head = newNode;
        }
    }

    public static Node top(Queue queue)
    {
        return queue.head!=null ? queue.head : null;
    }

    public static Queue pop(Queue queue)
    {
        if(queue.head != null)
        {
            queue.head = queue.head.next;
            return queue;
        }
        else
        {
            return null;
        }
    }

    public static int find (Queue queue, Object val)
    {
        int index = 0;
        Node curr = queue.head;

        while(curr!=null)
        {
            if(curr.val == val)
            {
                return index;
            }
            index++;
            curr = curr.next;
        }
        return -1;
    }

    public static void printQueue(Queue queue) {
        Node curr = queue.head;
        System.out.println("Queue: ");
        while(curr!=null)
        {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.print('\n');
    }
}
