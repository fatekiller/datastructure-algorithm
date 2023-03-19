package com.lcf.learn.data.stracture.hash;

import java.util.Arrays;

public class CustomHashTable<K, V> {

    static class Node<K, V> {
        Node<K, V> next;
        V val;
        K key;

        private Node(K k, V v) {
            val = v;
            key = k;
        }
    }

    private Node<K, V>[] nodes;

    private int capacity;

    private int size;

    private float loadFactor;

    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public CustomHashTable(int capacity) {
        // 容量取满足需求的最小一个2的次幂
        int cap = 2;
        while (cap < capacity) {
            cap = cap << 1;
        }
        this.capacity = cap;
        this.nodes = new Node[cap];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public int size() {
        return this.size;
    }

    public void put(K key, V val) {

        int slotIdx = getSlotIdx(key, capacity);
        Node<K, V> newNode = new Node<>(key, val);
        Node<K, V> slot = nodes[slotIdx];
        if (slot == null) {
            nodes[slotIdx] = newNode;
        } else {
            // 找当前要插入的Node
            Node<K, V> exist = getNodeForKey(key);
            if (exist != null) {
                exist.val = val;
                return;
            }
            // 当前不存在，新插入一个
            Node<K, V> tmp = slot.next;
            slot.next = newNode;
            newNode.next = tmp;
        }
        System.out.println("key: "+key+" val: "+val+" slotIdx: "+slotIdx+" size: "+size+", "+"limit: "+capacity*loadFactor);
        if (++size > capacity*loadFactor) {
            System.out.println("resize");
            resize();
        }

    }

    public void delete(K key) {
        int slotIdx = getSlotIdx(key, capacity);
        Node<K, V> slot = nodes[slotIdx];
        if (slot == null) {
            throw new RuntimeException("key :"+key+" not exist!");
        }
        if (slot.key.equals(key)) {
            nodes[slotIdx] = slot.next;
            slot.next = null;
            size -= 1;
            return;
        }
        Node<K, V> pre = slot, p = slot;
        while (p != null) {
            if (p.key.equals(key)) {
                pre.next = p.next;
                p.next = null;
                size -= 1;
                return;
            }
            pre = p;
            p = p.next;
        }
        throw new RuntimeException("key :"+key+" not exist!");
    }

    private Node<K, V> getNodeForKey(K key) {
        int slotIdx = getSlotIdx(key, capacity);
        Node<K, V> slot = nodes[slotIdx];
        if (slot == null) {
            return null;
        }
        while (slot != null) {
            if (slot.key.equals(key)) {
                return slot;
            }
            slot = slot.next;
        }
        return null;
    }

    public V get(K key) {
        Node<K, V> node = getNodeForKey(key);
        return node == null ? null: node.val;
    }

    public boolean containsKey(K key) {
        Node<K, V> node = getNodeForKey(key);
        return node != null;
    }

    private void resize() {
        int newCap = capacity << 1;
        Node<K, V>[] newNodes = new Node[newCap];

        for (Node<K, V> head : nodes) {
            if (head == null) {
                continue;
            }

            Node<K, V> p = head;
            while (p != null) {
                Node<K, V> tmp;
                int slotIdx = getSlotIdx(p.key, newCap);
                Node<K, V> newListHead = newNodes[slotIdx];
                if (newListHead == null) {
                    newNodes[slotIdx] = p;
                    tmp = p.next;
                    p.next = null;
                    p = tmp;
                } else {
                    tmp = newListHead.next;
                    newListHead.next = p;
                    Node<K, V> tmp2 = p.next;
                    p.next = tmp;
                    p = tmp2;
                }
            }
        }
        this.capacity = newCap;
        this.nodes = newNodes;
    }

    public void clear() {
        if (size > 0) {
            Arrays.fill(nodes, null);
            size = 0;
        }
    }

    private int getSlotIdx(K key, int cap) {
        return key.hashCode() & (cap-1);
    }

    public void print() {
        System.out.println("size: "+size+" capacity: "+capacity);
        for (Node<K, V> head : nodes) {
            System.out.print("NodeList: ");
            if (head == null) {
                System.out.println("null");
                continue;
            }

            Node<K, V> p = head;
            StringBuilder sb = new StringBuilder();
            while (p != null) {
                sb.append("[key: ").append(p.key).append(", val: ").append(p.val).append("]->");
                p = p.next;
            }
            sb.delete(sb.length()-2, sb.length());
            System.out.println(sb);
        }
    }
}
