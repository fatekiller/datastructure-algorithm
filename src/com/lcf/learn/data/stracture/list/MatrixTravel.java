package com.lcf.learn.data.stracture.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixTravel {

    /**
     * 输入一个m*n 的矩阵，按顺时针的方式遍历
     * 方法1， 按层遍历 设置 left, top, right, bottom, 如果 top == bottom 或者 left == right， 就按照单行处理， 否则转圈遍历
     */
    public static int[] travelMatrix(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int m = matrix.length, n = matrix[0].length;
        int left = 0, top = 0, right = n - 1, bottom = m - 1;
        int[] rst = new int[m * n];
        int idx = 0;
        while (idx < m * n) {

            // 只有一列
            if (left == right) {
                for (int i = top; i <= bottom; i++) {
                    rst[idx++] = matrix[i][left];
                }
                break;
            }
            // 只有一行
            if (bottom == top) {
                for (int i = left; i <= right; i++) {
                    rst[idx++] = matrix[top][i];
                }
                break;
            }

            // 写上面
            for (int i = left; i <= right; i++) {
                rst[idx++] = matrix[top][i];
            }

            // 写右边
            for (int i = top + 1; i <= bottom; i++) {
                rst[idx++] = matrix[i][right];
            }

            // 写下面
            for (int i = right - 1; i >= left; i--) {
                rst[idx++] = matrix[bottom][i];
            }

            // 写左边
            for (int i = bottom - 1; i >= top+1; i--) {
                rst[idx++] = matrix[i][left];
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return rst;
    }

    /**
     * 对角线遍历数组
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0) return new int[]{};
        int m = mat.length, n = mat[0].length;
        return new int[]{};

    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        System.out.println(Arrays.toString(travelMatrix(data)));
    }
}
