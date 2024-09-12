/*
问题描述

在河上有一座独木桥，一只青蛙想沿着独木桥从河的一侧跳到另一侧。
在桥上有一些石子，青蛙很讨厌踩在这些石子上。
由于桥的长度和青蛙一次跳过的距离都是正整数，我们可以把独木桥上青蛙可能到达的点看成数轴上的一串整点：0，1，……，L（其中 L 是桥的长度）。
坐标为0的点表示桥的起点，坐标为L的点表示桥的终点。青蛙从桥的起点开始，不停的向终点方向跳跃。
一次跳跃的距离是 S 到 T 之间的任意正整数（包括S,T）。当青蛙跳到或跳过坐标为L的点时，就算青蛙已经跳出了独木桥。
题目给出独木桥的长度 L ，青蛙跳跃的距离范围 S,T ，桥上石子的位置。你的任务是确定青蛙要想过河，最少需要踩到的石子数。

输入说明

输入的第一行有一个正整数L（1<=L<=10^9)表示独木桥的长度。
第二行有三个正整数 S，T，M，分别表示青蛙一次跳跃的最小距离，最大距离，及桥上石子的个数，其中1<=S<=T<=10，1<=M<=100。
第三行有 M 个不同的正整数分别表示这 M 个石子在数轴上的位置（数据保证桥的起点和终点处没有石子）。所有相邻的整数之间用一个空格隔开。

输出说明
输出包括一个整数，表示青蛙过河最少需要踩到的石子数。
 */
package com.study240717;

import java.util.*;

public class GoRiver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j;
        int l = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m + 2];
        arr[0] = 0;
        for (i = 1; i <= m; i++) {
            arr[i] = sc.nextInt();
        }
        arr[m + 1] = l;
        if (s == t) {
            int count = 0;
            for (int stone : arr) {
                if (stone % s == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
        else {
            Arrays.sort(arr);

            int[] brr = new int[m + 3];
            int bLong = 1;
            brr[0] = 0;
            for (i = 1; i <= m + 1; i++) {
                if (arr[i] - arr[i - 1] < t * (t - 1)) {
                    brr[bLong] = brr[bLong - 1] + arr[i] - arr[i - 1];
                    bLong++;
                }
            }
            int[] dp = new int[brr[bLong - 1] + t];
            dp[0] = 0;
            for (i = 1; i < brr[bLong - 1] + t; i++)
                dp[i] = 1000000000;

            int stoneNumber = 1;
            for (i = 0; i < brr[bLong - 1] + t; i++) {
                if (i > brr[stoneNumber] && stoneNumber <= m + 1)
                    stoneNumber++;
                for (j = s; j <= t; j++) {
                    if (i - j >= 0) {
                        if (i == brr[stoneNumber]) {
                            System.out.println(i + "-" + j);
                            dp[i] = Math.min(dp[i - j] + 1, dp[i]);
                        } else {
                            dp[i] = Math.min(dp[i], dp[i - j]);
                        }
                    } else {
                        break;
                    }
                }
            }
            for (i = 0; i < brr[bLong - 1] + t; i++)
                System.out.println(i + ":" + dp[i]);
            int minResult = 1000000000;
            for (i = brr[bLong - 1]; i < brr[bLong - 1] + t; i++) {
                minResult = Math.min(dp[i], minResult);
            }
            System.out.println(minResult);
        }

    }
}
