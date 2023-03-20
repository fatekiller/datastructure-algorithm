package com.lcf.learn.algrithm.bit;

import java.util.Arrays;

public class BitAlgorithm {

    public int[] evenOddBit(int n) {

        int c = 1, idx = 0;
        int[] rst = {0, 0};

        while (c <= n) {
            if ((n & c) == 1) {
                if ((idx & 1) == 1) {
                    System.out.println(idx);
                    rst[1] += 1;
                } else {
                    System.out.println(idx);
                    rst[0] += 1;
                }
            }
            idx += 1;
            c = c << 1;
        }

        return rst;

    }

    public static void main(String[] args) {
        BitAlgorithm ba = new BitAlgorithm();
        System.out.println(Arrays.toString(ba.evenOddBit(17)));
    }
}
