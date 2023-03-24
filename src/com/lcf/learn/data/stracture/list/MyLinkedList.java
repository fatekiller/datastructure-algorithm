package com.lcf.learn.data.stracture.list;

import java.util.LinkedList;

/**
 * 一个带头尾指针的双链表
 */
public class MyLinkedList<T> {

    class ListNode {
        private ListNode prev;

        private ListNode next;

        protected ListNode(T val) {
            this.val = val;
        }

        T val;
    }

    private ListNode head;

    private ListNode tail;

    // 初始化，指定容量
    public MyLinkedList () {
        head = tail = new ListNode(null);
    }

    // 头部插入节点
    public void addHead (T val) {
        ListNode n = new ListNode(val);
        ListNode tmp = head.next;
        head.next = n;
        n.next = tmp;
        n.prev = head;
        if (tmp != null) {
            tmp.prev = n;
        }
    }

    // 尾部插入节点
    public void addTail(T val) {
        ListNode n = new ListNode(val);
        n.prev = tail;
        tail.next = n;
        tail = n;
    }

    // 删除指定节点

    // 删除尾部节点
}
