package model.linkedlist;

/**
 * @author aiden
 */
public class LinkedList {
    public Node head;
    public static class Node {
        final int val;
        Node next;
        Node(int d) {
            val = d;
            next = null;
        }
    }
    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }

    public static void delete(LinkedList list, int val)
    {
        Node currNode = list.head;
        Node prev = list.head;
        while (currNode != null) {
            if(currNode.val == val) {
                prev = currNode.next;
            }
            prev = currNode;
            currNode = currNode.next;
        }

    }
}