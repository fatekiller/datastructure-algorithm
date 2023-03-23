package com.lcf.learn.data.stracture.list;

public class BiSearch {

    public static void main(String[] args) {
        System.out.println(sqrt(9.0, 0.001));
    }

    public static double sqrt(double value, double error) {
        double begin = 0.0, end = value;
        double mid = (begin+end)/2;
        while (end - begin > 2*error) {
            mid = (begin+end)/2;
            if (mid*mid > value) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        System.out.println(begin+","+end);
        return mid;
    }
}
