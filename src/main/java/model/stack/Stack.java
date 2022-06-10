package model.stack;

import view.linkedlist.LinkedListNode;

/**
 * @author aiden
 */
public class Stack extends LinkedListNode {

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
}
