package com.lcf.learn.algrithm.sort;

import java.util.Arrays;

public class Sort {

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
        System.out.println(Arrays.toString(nums) +": "+ leftIdx);
        return leftIdx;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,1,1,2,0,0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
