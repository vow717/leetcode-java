/*
双向BFS搜索（不熟练，写太麻烦了)
 */
package com.study240717;
import java.util.*;

public class KnightMoves {
    static int[][] flag = {
            {1, 2}, {2, 1}, {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    static class Chess {
        int[][] chess;
        int[][] crank;
        int cLong;

        public Chess(int n) {
            chess = new int[n][n];
            crank = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chess[i][j] = 1;
                    crank[i][j]=0;
                }
            }
            cLong = n;
        }
    }

    static public boolean Ok(int x, int y, Chess c) {
        return x >= 0 && y >= 0 && x < c.cLong && y < c.cLong;
    }

    static int Bfs(Chess c, int x1, int y1, int x2, int y2) {
        Queue<int[]> start = new LinkedList<>();
        Queue<int[]> end = new LinkedList<>();

        start.offer(new int[]{x1, y1, 0});
        c.chess[x1][y1] = 0;

        end.offer(new int[]{x2, y2, 0});
        c.chess[x2][y2] = 2;

        while (!start.isEmpty() && !end.isEmpty()) {
            int[] startCurrent = start.poll();
            int[] endCurrent = end.poll();

            int a1 = startCurrent[0], b1 = startCurrent[1], rank1 = startCurrent[2];
            int a2 = endCurrent[0], b2 = endCurrent[1], rank2 = endCurrent[2];

            for (int i = 0; i < 8; i++) {
                int newA1 = a1 + flag[i][0], newB1 = b1 + flag[i][1];
                int newA2 = a2 + flag[i][0], newB2 = b2 + flag[i][1];

                if (Ok(newA1, newB1, c)) {
                    if (c.chess[newA1][newB1] == 2) {
                        return rank1 + c.crank[newA1][newB1] +1;
                    }
                    if (c.chess[newA1][newB1] == 1) {
                        c.chess[newA1][newB1] = 0;
                        c.crank[newA1][newB1]=rank1+1;
                        start.offer(new int[]{newA1, newB1, rank1 + 1});
                    }
                }
                if (Ok(newA2, newB2, c)) {
                    if (c.chess[newA2][newB2] == 0) {
                        return c.crank[newA2][newB2] + rank2 + 1;
                    }
                    if (c.chess[newA2][newB2] == 1) {
                        c.chess[newA2][newB2] = 2;
                        c.crank[newA2][newB2]=rank2+1;
                        end.offer(new int[]{newA2, newB2, rank2 + 1});
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Chess c = new Chess(n);
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
            } else {
                int result = Bfs(c, x1, y1, x2, y2);
                System.out.println(result);
            }
        }
        sc.close();
    }
}
