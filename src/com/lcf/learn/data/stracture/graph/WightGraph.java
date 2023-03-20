package com.lcf.learn.data.stracture.graph;

import java.util.Arrays;
import java.util.HashSet;

public class WightGraph {


    /**
     * 求图最短路径算法
     *
     * @param paths
     * @return 最短路径
     */
    public static int shortestPath(int[][] paths, int n, int src, int dest) {
        int maxVal = Integer.MAX_VALUE;
        int[][] distance = new int[n][n];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], maxVal);
            distance[i][i] = 0;
        }
        for (int i = 0; i < paths.length; i++) {
            int n1 = paths[i][0], n2 = paths[i][1], weight = paths[i][2];
            distance[n1][n2] = weight;
            distance[n2][n1] = weight;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(distance[i]));
        }

        // 用来记录已经确定了到源点的最短距离的点
        HashSet<Integer> visited = new HashSet<>();
        visited.add(src);
        int round = 0;
        while (!visited.contains(dest)) {
            int nextNode = 0, minPath = maxVal;
            for (Integer edge : visited) {
                int[] currentDistance = distance[edge];
                for (int to = 0; to < n; to++) {
                    // 无路径、到源点的、已经找到最短路径的、到自己的 无需更新
                    if (currentDistance[to] == maxVal || to == src || visited.contains(to)) continue;
                    int currentPath = distance[src][edge] + distance[edge][to];

                    // 如果到src 有更短路径，则更新
                    if (distance[src][to] > currentPath) {
                        distance[src][to] = currentPath;
                    }

                    // 记录当前这一轮从源点能扩展到的点, 注意不一定是有更新的
                    if (currentPath < minPath && !visited.contains(to)) {
                        nextNode = to;
                        minPath = currentPath;
                    }
                }
            }
            visited.add(nextNode);
            System.out.printf("round: %d, node: %d, minPath: %d%n", round++, nextNode, minPath);
        }

        return distance[src][dest];
    }

    public static void main(String[] args) {
        int[][] testCase = new int[][]{{0, 1, 1}, {0, 3, 3}, {0, 2, 4}, {1, 3, 1}, {2, 4, 1}, {3, 4, 3}};

        System.out.println(shortestPath(testCase, 5, 0, 4));
    }

}
