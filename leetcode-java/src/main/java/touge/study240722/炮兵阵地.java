/*
题目描述:
炮兵阵地, 有一个炮兵阵地，有n行m列，每个位置上可以放置一个炮兵，或者不放置炮兵。
如果某个位置放置了炮兵，那么这个位置的左右上下2格都不能放置炮兵，防止误伤。
现在要求在这个炮兵阵地上放置炮兵，使得炮兵的数量最多。
P表示这个位置可以放置炮兵，H表示这个位置不能放置炮兵。
 */
package com.study240722;

import java.util.*;

public class 炮兵阵地 {
    public static boolean OK(int a, int b) {
        if ((a | b) != a) return false;
        if ((b & (b << 1)) != 0 || (b & (b << 2)) != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                char c = s.charAt(j - 1);
                arr[i] = (arr[i] << 1) + (c == 'P' ? 1 : 0);
            }
        }

        List < Integer > validStates = new ArrayList < > ();
        for (int i = 0; i < (1 << m); i++) {
            if ((i&(i<<1))==0&&(i&(i<<2))==0) {
                validStates.add(i);
            }
        }

        int[][][] dp = new int[n + 1][1 << m][1 << m];
        for (int i = 1; i <= n; i++) {
            for (int j: validStates) {
                if (OK(arr[i], j)) {
                    for (int k: validStates) {
                        if ((k & j) != 0)
                            continue;
                        for (int l: validStates) {
                            if ((k & l) != 0 || (j & l) != 0)
                                continue;

                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][k][l] + Integer.bitCount(j));
                        }
                    }
                }
            }
        }
        int resultMax = 0;
        for (int j: validStates)
            for (int k: validStates)
                resultMax = Math.max(resultMax, dp[n][j][k]);
        System.out.println(resultMax);
    }
}
