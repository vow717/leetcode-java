/*
题目描述:
描述有N个村庄，从1到N编号，你应该修建一些道路，这样每两个村庄就可以相互连接。
我们说两个村庄A和B是相连的，当且仅当A和B之间有一条道路，或者存在一个村庄C，使得A和C之间有道路，并且C和B是连接的。
我们知道，一些村庄之间已经有一些道路，你的工作是修建一些道路，以便所有村庄都能连接起来，并且所有修建的道路的长度都是最小的。
输入第一行是一个整数N（3<=N<=100），表示村庄的数量。
然后是N行，其中第i行包含N个整数，这N个整数中的第j行是村庄i和村庄j之间的距离（距离应该是[11000]内的整数）。
然后有一个整数Q（0<=Q<=N*（N+1）/2）。
然后是Q条线，每条线包含两个整数a和b（1<=a<b<=N），这意味着a村和b村之间的道路已经建成。
输出您应该输出一条包含整数的线，该整数是所有要修建的道路的长度，以便连接所有村庄，并且该值是最小值。
 */
package com.study240716;
import java.util.*;
//克鲁斯卡尔算法求解
public class ConstructingRoads {
    static class Edge implements Comparable<Edge> {
        int from, to,weight;
        public Edge(int from, int to,int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    static class unionFine{
        int []parent;
        //rank[i]表示以i为根的树的高度
        //用rank来决定合并的方向有利于降低树的高度，提高效率
        int []rank;
        public unionFine(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x,int y){
            if(find(x)==find(y)){
                return false;
            }
            int rankX=rank[find(x)];
            int rankY=rank[find(y)];
            if(rankX<rankY){
                parent[find(x)]=find(y);
            }else if(rankX>rankY){
                parent[find(y)]=find(x);
            }else {
                parent[find(x)]=find(y);
                rank[find(y)]++;
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        unionFine uf=new unionFine(n);
        List<Edge>edges=new ArrayList<>();
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                int weight = sc.nextInt();
                if(i==j) continue;
                else {
                    Edge e = new Edge(i, j, weight);
                    edges.add(e);
                }
            }
        }
        int q=sc.nextInt();
        for(int i=0;i<q;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            uf.union(x-1,y-1);
        }
        Collections.sort(edges);
        int res=0;
        for (Edge e:edges){
            if(uf.union(e.from,e.to)){
                res+=e.weight;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
