package linkedlist.easy;

import linkedlist.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;

        LinkedListCycle m = new LinkedListCycle();
        System.out.println(m.hasCycle(head));
    }
}
