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
            int mid = (right - left) / 2 + left;
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
        if (nums[left] < target) {
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
            int mid = (right - left) / 2 + left;
            // 小于等于的部分不要
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 不存在的情况
        if (left == 0) {
            return -1;
        }
        return left - 1;
    }

    /**
     * 旋转数组查找简单版；没有重复的数字，先找到中间数，然后两边二分查找
     */
    public static int searchRotatedI(int[] nums, int target) {

        int middle = findMiddleI(nums);
        int leftIdx = biFind(nums, 0, middle-1, target);
        if (leftIdx != -1){
            return leftIdx;
        }
        return biFind(nums, middle, nums.length-1, target);
    }

    /**
     * 一定有解，找最合适的，用 left < right
     * 每次丢掉肯定不对的，也就是连续上升的后半段（保留middle），或者连续下降的前半段（不要middle，不存在解）
     */
    public static int findMiddleI(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int middle = (end - begin) / 2 + begin;
            if (nums[middle] < nums[end]) {
                end = middle;
            } else {
                begin = middle+1;
            }
        }
        return begin;
    }


    public static int searchRotatedII(int[] nums, int target) {
        int middle = findMiddleII(nums);
        int left = biFind(nums, 0, middle-1, target);
        if (left != -1) {
            return left;
        }
        return biFind(nums, middle, nums.length-1, target);

    }

    /**
     * 先和无重复的方法一样，排除不存在解的区间，
     * 如果有相等的情况，可以收缩右边界就慢慢收缩右边界，否则就收缩左边界
     * 如果收缩到正确答案的地方，还有nums[mid]等于nums[right];那么说明整个数组的数据全都一样
     */
    public static int findMiddleII(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<right) {
            int mid = (right-left)/2+left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                // 右边界可以收缩则收缩右边界
                if (right > 0 && nums[right-1] <= nums[right]) {
                    right = right + 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return left;
    }

    public static int biFind(int[] nums, int begin, int end, int target){
        int left = begin, right = end;
        while(left <= right) {
            int mid = (right-left)/2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

}
