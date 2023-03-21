package com.lcf.learn.algrithm.shuffle;

import java.util.*;

/**
 * 微派面试：洗牌，让每个牌出现到每个位置的概率相等
 * 进阶：9这张牌出现在0 这个位置的概率是其他牌出现在这个位置的概率的2倍
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }
        int nineIn0 = 0;
        int oneIn0 = 0;
        for (int i = 0; i < 10000; i++) {
            // System.out.println("before: " + Arrays.toString(nums));
            int[] rst = shuffleListII(nums);
            if (rst[0] == 9) {
                nineIn0 += 1;
            } else if (rst[0] == 1) {
                oneIn0 += 1;
            }
            // System.out.println("after: " + Arrays.toString(rst));
        }
        System.out.println("nineIn0: " + nineIn0 + ",  oneIn0: "+ oneIn0);

    }

    public static void shuffleList(int[] nums) {
        Random r = new Random();
        int bound = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int idx = r.nextInt(bound);
            swap(i, idx, nums);
        }
    }


    public static int[] shuffleListII(int[] nums) {
        Random r = new Random();
        int[] rst = new int[nums.length];
        int bound = nums.length;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++, bound--) {
            if (i == 0) {
                int card = r.nextInt(11);
                if (card < 9) {
                    rst[i] = card;
                    used.add(card);
                } else {
                    rst[i] = 9;
                    used.add(card);
                }
            } else {
                int card = r.nextInt(10);
                while (used.contains(card)) {
                    card = r.nextInt(10);
                }
                rst[i] = card;
                used.add(card);
            }
        }
        return rst;
    }

    public static void swap(int i, int j, int[] data) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
