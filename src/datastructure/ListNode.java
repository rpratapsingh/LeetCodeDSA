package datastructure;

public class ListNode<T> {
    private T value;
    private ListNode address;

    ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public ListNode getAddress() {
        return address;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setAddress(ListNode address) {
        this.address = address;
    }
}
