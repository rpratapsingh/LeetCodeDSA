package linkedlist.easy;

import linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode temp = head.next;
        return null;
    }

    void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.print(head);
        ListNode newHead = reverseLinkedList.reverseList(head);
        reverseLinkedList.print(newHead);
    }
}
