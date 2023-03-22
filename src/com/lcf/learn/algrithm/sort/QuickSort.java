package com.lcf.learn.algrithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int begin, int end) {
        int mid = partition(nums, begin, end);
        if (mid > begin) {
            quickSort(nums, begin, mid-1);
        }
        if (mid<end) {
            quickSort(nums, mid+1, end);
        }
    }

    /**
     * 求数组中第k大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        int i = -1;
        int begin = 0;
        int end = nums.length-1;
        while (i != k-1) {
            i = partitionII(nums, begin, end);
            if (i == k-1) {
                return nums[i];
            } else if (i < k-1) {
                begin = i+1;
            } else {
                end = i-1;
            }
        }
        return nums[0];
    }

    /**
     * 降序划分
     */
    public int partitionII(int[] data, int begin, int end) {

        int num = data[end];
        int leftIdx = begin;
        for (int i = begin; i<end; i++) {
            if (data[i] > num) {
                swap(data, leftIdx, i);
                leftIdx += 1;
            }
        }
        swap(data, leftIdx, end);
        return leftIdx;
    }

    public static void quickSortTailRecursive(int[] nums, int begin, int end) {
        while (begin < end) {
            int mid = partition(nums, begin, end);
            quickSortTailRecursive(nums, begin, mid-1);
            begin = mid+1;
        }
    }

    private static int partition(int[] nums, int begin, int end) {
        int val = nums[end];
        int leftIdx = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i]<val) {
                swap(nums, leftIdx, i);
                leftIdx += 1;
            }
        }
        swap(nums, leftIdx, end);
        // System.out.println(Arrays.toString(nums) +": "+ leftIdx);
        return leftIdx;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 8, 7, 1, 5, 4, 5, 6, 2, 4, 9, 0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 3, 7, 8, 7, 1, 5, 4, 5, 6, 2, 4, 9, 0};
        quickSortTailRecursive(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
