package linkedlist;

public class HashNode {
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public HashNode(int key, int value, HashNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
