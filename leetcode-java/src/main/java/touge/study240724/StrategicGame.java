/*
（由叶到根的树形DP）
题目描述：
已知有n个城市，各城市之间有道路，在一个城市上就可以监视这些道路
现在要安排一些守卫，使得每条道路都要被监视到，但是守卫的数量要尽可能的少
问最少需要多少守卫
 */
package com.study240724;

import java.util.*;

public class StrategicGame {

    public static void dfs(int u, List<List<Integer>> adj, int[][] dp){

        dp[u][0]=0;
        dp[u][1]=1;
        for(int v:adj.get(u)){
            dfs(v,adj,dp);
            dp[u][0]+=dp[v][1];
            dp[u][1]+=Math.min(dp[v][0],dp[v][1]);
        }

    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
        int n = sc.nextInt();
        //创建个邻接表来记录节点i的所有邻接节点代码如下
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int begin = 0;
        for (int i=0;i<n;i++){
            int u= sc.nextInt();
            if (i==0){
                begin = u;
            }
            int num= sc.nextInt();
            for(int j=0;j<num;j++){
                int v= sc.nextInt();
                adj.get(u).add(v);
            }
        }
        int [][]dp=new int[n][2];
        dfs(begin,adj,dp);
        System.out.println(Math.min(dp[begin][0],dp[begin][1]));
    }
    }
}
