package com.lcf.learn.data.stracture.hash;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    /**
     * 放入一个元素之后能get到, size正确更新
     * 放入已经存在的元素，会更新原有的值
     * hash冲突的时候会拉链
     */
    public static void test1() {

        CustomHashTable<String, String> cht = new CustomHashTable<>(3);
        cht.put("name", "stu1");
        assert cht.size() == 4;
        assert "stu1".equals(cht.get("name"));
        cht.put("name", "stu2");
        assert "stu2".equals(cht.get("name"));
    }

    /**
     * 1. 拉链之后查询
     * 2. 有链表的情况，删除之后重新get
     */
    public static void test2() {
        CustomHashTable<String, String> cht = new CustomHashTable<>(3);
        for (int i = 0; i < 12; i += 4) {
            cht.put("key" + i, "val" + i);
        }
        cht.print();
        for (int i = 0; i < 12; i += 4) {
            assert cht.get("key" + i).equals("val" + i);
        }
        cht.delete("key8");
        cht.print();
        for (int i = 0; i < 12; i += 4) {
            String key = "key" + i;
            if (cht.containsKey(key)) {
                assert cht.get(key).equals("val" + i);
            }
        }
    }

    /**
     * 测试resize
     */
    public static void test3() {
        CustomHashTable<String, String> cht = new CustomHashTable<>(3);
        for (int i = 0; i < 12; i += 4) {
            cht.put("key" + i, "val" + i);
        }
        cht.print();
        System.out.println("======================after resize===============");
        cht.put("key12", "val12");
        cht.print();
        for (int i = 0; i < 13; i += 4) {
            assert cht.get("key" + i).equals("val" + i);
        }
    }
}
