package com.lcf.learn.data.stracture.list;

import java.util.*;

/**
 * 一个带头尾指针的双链表
 */
public class MyLinkedList<T> implements MyList<T> {

    private ListNode head;

    private ListNode tail;

    private int size;

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(T o) {
        if (isEmpty()) return false;
        if (o == null) {
            for (ListNode p = head; p != null; p = p.next) {
                if (p.val == null) {
                    return true;
                }
            }
        } else {
            for (ListNode p = head; p != null; p = p.next) {
                if (p.val.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }


    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (ListNode p = head; p != null; p = p.next) {
                if (p.val == null) {
                    return index;
                }
                index += 1;
            }
        } else {
            for (ListNode p = head; p != null; p = p.next) {
                if (p.val.equals(o)) {
                    return index;
                }
                index += 1;
            }
        }
        return -1;
    }

    class ListNode {
        private ListNode prev;

        private ListNode next;

        protected ListNode(T val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        T val;
    }


    // 初始化，指定容量
    public MyLinkedList() {
    }

    // 头部插入节点
    public void addHead(T val) {
        ListNode f = head;
        ListNode newNode = new ListNode(val, null, f);
        if (head == null)
            tail = newNode;
        else
            head.prev = newNode;
        head = newNode;
        size += 1;
    }

    // 尾部插入节点
    public void addTail(T val) {
        ListNode l = tail;
        ListNode newNode = new ListNode(val, l, null);
        tail = newNode;
        if (head == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    // 删除指定节点
    public void deleteNode(ListNode n) {
        if (n.prev != null) {
            n.prev.next = n.next;
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        }
        n.prev = null;
        n.next = null;
        size--;
    }

    private ListNode node(int idx) {
        if (idx >= size) throw new RuntimeException(String.format("array index out of bound %d, %d", idx, size));
        ListNode p = head;
        for (int i = 0; i < idx; i++) {
            p = p.next;
        }
        return p;
    }

    public T get(int idx) {
        return node(idx).val;
    }

    public void set(int idx, T val) {
        ListNode n = node(idx);
        n.val = val;
    }

    public void insert(int idx, T val) {
        if (idx == 0) {
            addHead(val);
            return;
        }
        ListNode n = node(idx);
        ListNode newNode = new ListNode(val, n.prev, n);
        n.prev.next = newNode;
        n.prev = newNode;
        size++;
    }

    public void delete(int idx) {
        ListNode n = node(idx);
        deleteNode(n);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode p = head, pre = head; p != null; pre = p, p = p.next) {
            if (p != pre) {
                assert p.prev == pre;
            }
            sb.append(p.val);
            sb.append("-->");
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.append("]").toString();
    }
}
