package linkedlist.medium;

import linkedlist.ListNode;
import linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> nodeStore = new HashMap<>();
        while (current != null) {
            nodeStore.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node copy = nodeStore.get(current);
            copy.next = nodeStore.get(current.next);
            copy.random = nodeStore.get(current.random);
        }
        return nodeStore.get(head);
    }


    public static void main(String[] args) {

        Node _7 = new Node(7);
        Node _13 = new Node(13);
        Node _11 = new Node(11);
        Node _10 = new Node(10);
        Node _1 = new Node(1);

        _7.next = _13;
        _13.next = _11;
        _11.next = _10;
        _10.next = _1;

        _13.random = _7;
        _11.random = _1;
        _10.random = _11;
        _1.random = _7;

        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        Node newNode = copyListWithRandomPointer.copyRandomList(_7);

        while (newNode != null) {
            System.out.println(newNode.val + " Next-->" + (newNode.next != null ? newNode.next.val : "null") + ", Randon-->" + (newNode.random != null ? newNode.random.val : "null"));
            newNode = newNode.next;
        }

    }
}
