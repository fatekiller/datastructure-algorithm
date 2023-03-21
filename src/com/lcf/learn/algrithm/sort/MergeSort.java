package com.lcf.learn.algrithm.sort;

import java.util.Arrays;

public class MergeSort {


    public static int[] mergeSort(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);
        mergeSortII(nums, result, 0, nums.length - 1);
        return result;
    }

    public static void mergeSortII(int[] nums, int[] result, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + ((end - begin) >> 1);

        // 分别排序
        mergeSortII(nums, result, begin, mid);
        mergeSortII(nums, result, mid + 1, end);

        // 合并排序子数组
        int i = begin, j = mid+1, k = begin;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                result[k] = nums[i];
                i += 1;
            } else {
                result[k] = nums[j];
                j += 1;
            }
            k += 1;
        }

        while (i <= mid) {
            result[k++] = nums[i++];
        }

        while (j <= end) {
            result[k++] = nums[j++];
        }

        // 从临时数组中将结果复制到待排序数组中
        if (end + 1 - begin >= 0) System.arraycopy(result, begin, nums, begin, end + 1 - begin);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        int[] rst = mergeSort(nums);
        System.out.println(Arrays.toString(rst));
    }
}
