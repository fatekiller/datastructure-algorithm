package com.lcf.learn.data.stracture.list;

import java.util.*;

/**
 * 一个带头尾指针的双链表
 */
public class MyLinkedList<T> {

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


    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    public boolean contains(Object o) {
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


    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     *                              (<a href="Collection.html#optional-restrictions">optional</a>)
     */
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
}
