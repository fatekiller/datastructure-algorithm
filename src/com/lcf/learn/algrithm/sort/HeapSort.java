package com.lcf.learn.algrithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 8, 7, 1, 5, 4, 5, 6, 2, 4, 9, 0};
        Heap h = new Heap(nums.length, nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = h.pop();
        }
        System.out.println("Result: " + Arrays.toString(nums));
    }
}

class Heap {
    private int[] data;

    private int capacity;

    public Heap(int capacity, int[] input) {
        this.data = Arrays.copyOf(input, input.length);
        this.capacity = capacity;
        for (int i = capacity / 2; i >= 0; i--) {
            heapify(i);
            System.out.println("Result: " + Arrays.toString(data));
        }
    }

    public void heapify(int idx) {
        int i = idx;
        while (i < capacity) {
            int newIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < capacity && this.data[left] < this.data[newIdx]) {
                newIdx = left;
            }

            if (right < capacity && this.data[right] < this.data[newIdx]) {
                newIdx = right;
            }

            if (newIdx == i) {
                return;
            }
            swap(i, newIdx);
            i = newIdx;
        }
    }

    public int pop() {
        this.capacity--;
        int ret = this.data[0];
        this.data[0] = this.data[capacity];
        heapify(0);
        return ret;
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
