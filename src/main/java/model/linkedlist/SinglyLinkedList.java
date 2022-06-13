package model.linkedlist;

/**
 * @author aiden
 */
public class SinglyLinkedList extends AbstractSinglyLinkedNode{

    public static SinglyLinkedList insert(SinglyLinkedList list, Object data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
        return list;
    }

    public static void printList(SinglyLinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }

    public static void delete(SinglyLinkedList list, Object key)
    {
        Node currNode = list.head, prev = null;
        if ((currNode != null) && (currNode.val.equals(key))) {
            list.head = currNode.next;
            System.out.println(key + " found and deleted");
            return;
        }

        while ((currNode != null) && (!currNode.val.equals(key))) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }
        if (currNode == null) {
            System.out.println(key + " not found");
        }
    }

    public static void reverseList(SinglyLinkedList linkedList) {
        Node curr = linkedList.head;
        Node next;
        Node prev = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        linkedList.head = prev;
    }

    public static int find(SinglyLinkedList linkedList, Object key)
    {
        int index = 0;
        Node curr = linkedList.head;
        while(curr != null)
        {
            if(curr.val.equals(key))
            {
                System.out.println(key + " found at index " + index);
                return index;
            }
            index++;
            curr = curr.next;
        }
        return -1;
    }
}