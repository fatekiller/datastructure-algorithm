package com.lcf.learn.data.stracture.list.stack;

import java.util.Arrays;

public class StackAlgorithm {
    /**
     * 两个栈实现队列
     */

    /**
     * 校验出栈顺序
     */

    /**
     * 汉诺塔问题
     */

    /**
     * 单调栈-每日温度
     * 给定一个每天的温度列表，每天输出下一个更高温度在几天后
     * [1,3,6,4,5,8,2] -> [1,1,3,1,1,0,0]
     * 解法：单调栈，如果温度比栈顶低则入栈，比栈顶高则依次出栈里的元素，出的时候根据下标差计算值
     */
    public static int[] lowerTemps(int[] temps) {
        Stack stack = new Stack(temps.length);
        int[] rst = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.top()]<temps[i]) {
                int idx = stack.pop();
                rst[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            rst[stack.pop()] = 0;
        }
        return rst;
    }


    /**
     * 接雨水
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(lowerTemps(new int[]{1,3,6,4,5,8,2})));
    }
}

class Stack {
    private int[] data;
    private int top = -1;

    public Stack(int capacity) {
        data = new int[capacity];
    }

    public int top() {
        return data[top];
    }

    public void push(int val) {
        data[++top] = val;
    }

    public int pop() {
        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
