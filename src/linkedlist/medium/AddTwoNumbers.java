package linkedlist.medium;

import linkedlist.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            sum += carry;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(sum % 10);
                current = head;
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int sum = carry + l1.val;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                int sum = carry + l2.val;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return head;
    }


    void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

//
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//
//        ListNode l2 = new ListNode(0);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode sum = addTwoNumbers.addTwoNumbers(l1, l2);

        addTwoNumbers.print(sum);


    }


}
