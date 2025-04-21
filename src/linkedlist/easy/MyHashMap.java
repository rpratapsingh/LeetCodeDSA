package linkedlist.easy;

import linkedlist.HashNode;
import linkedlist.Node;

import java.util.Arrays;

public class MyHashMap {

    HashNode[] addresses;
    private static final int SIZE = 10000;

    public MyHashMap() {
        addresses = new HashNode[SIZE];
        for (int i = 0; i < SIZE; i++) {
            addresses[i] = new HashNode(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        HashNode node = addresses[hash];
        while (node.next != null) {
            if (node.next.key == key) {
                node.next.value = value;
                return;
            }
            node = node.next;
        }
        node.next = new HashNode(key, value);
    }

    public int get(int key) {
        int hast = getHash(key);
        HashNode hashNode = addresses[hast].next;
        while (hashNode != null) {
            if (hashNode.key == key) {
                return hashNode.value;
            }
            hashNode = hashNode.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        HashNode cur = addresses[hash];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
