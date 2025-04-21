package linkedlist.medium;

import linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

//        Map<String, ListNode> tracking = new HashMap<>();
//        while (head != null && !tracking.containsKey(head.toString())) {
//            tracking.put(head.toString(), head);
//            head = head.next;
//        }
//        return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = head;

        LinkedListCycleII linkedListCycle = new LinkedListCycleII();
        ListNode listNode = linkedListCycle.detectCycle(head);
        System.out.println(listNode == null ? -1 : listNode.val);
    }
}
