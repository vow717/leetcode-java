/*
题目描述:
Bessie 受雇在 Farmer John 的 N (2<=N<=1,000) 个谷仓之间建立一个廉价的互联网网络，这些谷仓的编号方便地编号为 1..N。
 FJ已经做了一些调查，发现了M(1<=M<=20,000)条谷仓对之间可能的连接路线。
 每个可能的连接路线都有一个关联的成本 C (1<=C<=100,000)。
 Farmer John希望花最少的钱连接网络；他甚至不想付钱给贝西。

意识到农夫约翰不会付钱给她，贝西决定做最糟糕的工作。
她必须决定安装一组连接，以便
(i) 这些连接的总成本尽可能大，
(ii) 所有谷仓都连接在一起（以便可以从任何其他谷仓到达任何谷仓）通过已安装连接的路径），以及
(iii) 确保连接之间不存在循环（Farmer John 可以轻松检测到这一点）。
条件 (ii) 和 (iii) 确保最终的连接集看起来像一棵“树”。

输入
第 1 行：两个空格分隔的整数：N 和 M

第 2..M+1 行：每行包含三个空格分隔的整数 A、B 和 C，描述成本 C 的谷仓 A 和 B 之间的连接路线。

输出
第 1 行：一个整数，包含连接所有谷仓的最昂贵树的价格。如果无法连接所有谷仓，则输出 -1。
 */

package com.study240716;
import java.util.*;

public class BadCowtractors {
    static class Edge implements Comparable<Edge>{
        int from,to,weight;
        public Edge(int from,int to,int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }
        @Override
        public int compareTo(Edge e){
            return e.weight-this.weight;
        }
    }
    static class unionFine{
        int []parent;
        int []rank;
        public unionFine(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=i;
            }
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x,int y){
            if(find(x)==find(y))
                return false;
            int rootX=rank[find(x)];
            int rootY=rank[find(y)];
            if(rootX<rootY){
                parent[find(x)]=find(y);
            }else if(rootX>rootY){
                parent[find(y)]=find(x);
            }else {
                parent[find(y)]=find(x);
                rank[find(x)]+=1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        List<Edge>edges=new ArrayList<>();
        unionFine uf=new unionFine(n);
        for(int i=0;i<m;i++){
            int from=sc.nextInt()-1;
            int to=sc.nextInt()-1;
            int weight=sc.nextInt();
            Edge e=new Edge(from,to,weight);
            edges.add(e);
        }
        Collections.sort(edges);
        int res=0;
        for(Edge e:edges){
            if(uf.union(e.from,e.to)){
                res+=e.weight;
            }
        }
        int parent=uf.find(0);
        for(int i=1;i<n;i++){
            if(uf.find(i)!=parent)
            {
                System.out.println(-1);
                sc.close();
                return;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
