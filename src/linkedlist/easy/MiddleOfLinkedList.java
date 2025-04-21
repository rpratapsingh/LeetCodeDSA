package linkedlist.easy;

import linkedlist.ListNode;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);


        MiddleOfLinkedList m = new MiddleOfLinkedList();
        ListNode middle = m.middleNode(head);
        System.out.println(middle.val);

    }
}


