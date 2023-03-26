package com.lcf.learn.data.stracture.list;

public class BiSearch {

    public static void main(String[] args) {
        System.out.println(sqrt(9.0, 0.001));

        // 查找第一个大于等于目标的下标
        System.out.println("=================biSearchInsertLeft====================");
        System.out.println(biSearchInsertLeft(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(biSearchInsertLeft(new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(biSearchInsertLeft(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0));
        System.out.println(biSearchInsertLeft(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 6));


        // 查找最后一个小于等于目标的下标
        System.out.println("=================lastIndexOf====================");
        System.out.println(lastIndexOf(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(lastIndexOf(new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(lastIndexOf(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0));
        System.out.println(lastIndexOf(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 1));
        System.out.println(lastIndexOf(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, -1));
        System.out.println(lastIndexOf(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 10));

        // 查找最后一个小于等于目标的下标
        System.out.println("=================lastIndexOfII====================");
        System.out.println(lastIndexOfII(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(lastIndexOfII(new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(lastIndexOfII(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0));
        System.out.println(lastIndexOfII(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, -1));
        System.out.println(lastIndexOfII(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 10));

    }

    /**
     * @param value 待开方数
     * @param error 误差
     * @return 结果
     */
    public static double sqrt(double value, double error) {
        double begin = 0.0, end = value;
        double mid = (begin + end) / 2;
        while (end - begin > 2 * error) {
            mid = (begin + end) / 2;
            if (mid * mid > value) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        System.out.println(begin + "," + end);
        return mid;
    }

    /**
     * 二分查找，查找第一个大于等于目标的下标; 如果不存在大于等于的，则返回-1
     */
    public static int biSearchInsertLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) {
            return -1;
        }
        return left;
    }

    /**
     * 查找最后一个小于等于目标值的，如果不存在，返回-1
     * --> 转换为求第一个大于等于目标值的
     */
    public static int lastIndexOf(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            // 小于等于的部分不要
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 不存在的情况
        if (left == 0) {
            return -1;
        }
        // 不存在大于target的数
        if (nums[left]<target) {
            return left;
        }
        return left - 1;
    }

    /**
     * 查找最后一个小于等于目标值的，如果不存在，返回-1
     * --> 转换为求第一个大于等于目标值的
     */
    public static int lastIndexOfII(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            // 小于等于的部分不要
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        // 不存在的情况
        if (left == 0) {
            return -1;
        }
        return left - 1;
    }

}
