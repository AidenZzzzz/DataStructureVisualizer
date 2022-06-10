package model.queue;

import view.linkedlist.LinkedListNode;

/**
 * @author aiden
 */
public class Queue extends LinkedListNode {

    public static void push(Queue queue, Object val)
    {
        Node curr = queue.head;
        Node newNode = new Node(val);
        if (curr != null) {
            while(queue.head.next != null)
            {
                curr = queue.head.next;
            }
            curr.next = newNode;

        }
        queue.head = newNode;
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




}
