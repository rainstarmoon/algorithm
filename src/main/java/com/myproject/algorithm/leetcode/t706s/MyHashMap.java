package com.myproject.algorithm.leetcode.t706s;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

    private int length = 100;

    private Node<Integer>[] hashTable;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hashTable = new Node[length];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        Node<Integer> node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            Node<Integer> curr = hashTable[getHash(key)];
            if (curr == null) {
                curr = new Node<>(key, value);
                hashTable[getHash(key)] = curr;
                return;
            }
            while (true) {
                if (curr.next == null) {
                    Node tmp = new Node(key, value);
                    tmp.prev = curr;
                    curr.next = tmp;
                    return;
                } else {
                    curr = curr.next;
                }
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Node<Integer> node = getNode(key);
        return node == null ? -1 : node.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Node<Integer> node = getNode(key);
        if (node == null) {
            return;
        }
        if (node.prev == null) {
            hashTable[getHash(key)] = node.next;
            if (node.next != null) {
                node.next.prev = null;
            }
        } else {
            node.prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
    }

    private Node<Integer> getNode(int key) {
        Node<Integer> curr = hashTable[getHash(key)];
        while (curr != null) {
            if (curr.key == key) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private int getHash(int key) {
        return key % length;
    }

    private static class Node<T> {
        int key;
        T value;
        Node<T> prev;
        Node<T> next;

        Node(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }

}
