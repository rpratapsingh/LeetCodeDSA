package datastructure;


class LinkedList<T> {

    private ListNode<T> root;
    private ListNode<T> tail;
    private int length;

    public void insert(T value) {
        if (root == null) {
            root = new ListNode<>(value);
            tail = root;
        } else {
            tail.setAddress(new ListNode<T>(value));
            tail = tail.getAddress();
        }
        length++;
    }

    public int getSize() {
        return length;
    }

    public void print() {
        ListNode<T> traverse = root;
        while (traverse != null) {
            System.out.print(traverse.getValue() + " ");
            traverse = traverse.getAddress();
        }
        System.out.println();
    }
}

public class Insert {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.print();

        System.out.println(linkedList.getSize());
    }
}
