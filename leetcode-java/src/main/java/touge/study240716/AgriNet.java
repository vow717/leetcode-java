/*
题目描述
农民约翰当选为市长！他的竞选承诺之一是为该地区的所有农场提供互联网连接。他当然需要你的帮助。
农民约翰为他的农场订购了高速连接，并将与其他农民分享他的连接。为了最大限度地降低成本，他想铺设最少数量的光纤，将他的农场连接到所有其他农场。
给定连接每对服务器场需要多少光纤的列表，您必须找到将它们连接在一起所需的最小光纤量。每个服务器场都必须连接到其他服务器场，以便数据包可以从任何一个服务器场流到任何其他服务器场。
任何两个农场之间的距离都不会超过100000。
输入
输入包括几个案例。对于每种情况，第一行包含农场数量N（3<=N<=100）。以下几行包含N x N conectivity矩阵，其中每个元素都显示了从农场到另一个农场的距离。从逻辑上讲，它们是由N个空间分隔的整数组成的N行。从物理上讲，它们的长度限制在80个字符以内，因此有些行会延续到其他行。当然，对角线将为0，因为从农场i到农场本身的距离对于这个问题来说并不有趣。
输出
对于每种情况，输出一个整数长度，即连接整套场所需的最小光纤长度之和。
 */

package com.study240716;

import java.util.*;

public class AgriNet {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    static class unionFine {
        int[] parent;
        int[] rank;

        public unionFine(int x) {
            parent = new int[x];
            rank = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            if (find(x) == find(y)) {
                return false;
            }
            int rootX = rank[find(x)];
            int rootY = rank[find(y)];
            if (rootX < rootY) {
                parent[find(x)] = find(y);
            } else if (rootX > rootY) {
                parent[find(y)] = find(x);
            } else {
                parent[find(x)] = find(y);
                rank[find(y)] += 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        unionFine uf=new unionFine(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = sc.nextInt();
                if(i==j)
                    continue;
                Edge e = new Edge(i, j, weight);
                edges.add(e);
            }
        }
        Collections.sort(edges);
        int res = 0;
        for(Edge e:edges) {
            if(uf.union(e.from,e.to)){
                res+=e.weight;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
