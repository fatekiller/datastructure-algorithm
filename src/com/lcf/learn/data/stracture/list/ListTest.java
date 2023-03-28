package com.lcf.learn.data.stracture.list;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class ListTest {

    public static void main(String[] args) {
        MyList<Integer> myList = new MyLinkedList<>();
        myList.insert(0, null);
        assert  myList.contains(null);

        // testCase1();
        // testCase2();
        testCase3();
    }

    public static void testCase1() {
        MyList<Integer> myList = new MyLinkedList<>();
        for (int i = 0; i <10; i++) {
            myList.addTail(i);
        }
        System.out.println(myList);
        myList.delete(5);
        System.out.println(myList);
    }

    public static void testCase2() {
        var linkList = new LinkedList<Integer>();
        var myLinkList = new MyLinkedList<Integer>();
        Random rnd = new Random();
        // 插入1000个数
        for (int i = 0; i < 1000; i++) {
            var num = rnd.nextInt(1000);
            linkList.add(i);
            myLinkList.addTail(num);
        }

        // 随机再插入1000个数
        for (int i = 0; i < 1000; i++) {
            var idx = rnd.nextInt(1000);
            linkList.add(idx, i);
            myLinkList.insert(idx, i);
        }

        // 随机查1000次，看查的结果
        for (int i = 0; i < 1000; i++) {
            var idx = rnd.nextInt(2000);
            assert Objects.equals(linkList.get(idx), myLinkList.get(idx));
        }

        // 随机删除1000个数
        for (int i = 0; i < 1000; i++) {
            var idx = rnd.nextInt(1000);
            linkList.remove(idx);
            myLinkList.delete(idx);
        }

        // 随机查1000次，看查的结果
        for (int i = 0; i < 1000; i++) {
            var idx = rnd.nextInt(2000);
            assert Objects.equals(linkList.get(idx), myLinkList.get(idx));
        }
    }

    public static void testCase3() {
        MyList<Integer> myList = new MyLinkedList<>();
        for (int i = 0; i <10; i++) {
            myList.addHead(i);
        }
        System.out.println(myList);
        myList.delete(5);
        System.out.println(myList);
    }
}
