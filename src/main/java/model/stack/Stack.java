package model.stack;

import model.linkedlist.AbstractSinglyLinkedNode;

/**
 * @author aiden
 */
public class Stack extends AbstractSinglyLinkedNode {

    public static void push(Stack stack, Object val){
        Node newNode = new Node(val);
        if (stack.head != null) {
            newNode.next = stack.head;
        }
        stack.head = newNode;
    }

    public static Node top(Stack stack){
        return stack.head != null ? stack.head : null;
    }

    public static Stack pop(Stack stack)
    {
        if(stack.head!=null){
            stack.head = stack.head.next;
            return stack;
        }
        else
        {
            return null;
        }

    }

    public static int find(Stack stack, Object val){
        int index = 0;
        Node curr = stack.head;
        while(curr != null)
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

    public static void printStack(Stack stack) {
        Node currNode = stack.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}
