package com.study240724;
//链式前向星的java实现示例
import java.util.*;
public class 链式前向星示例 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();//n个点
            int m = sc.nextInt();//m条边
            int []head = new int[n+1];//head[i]表示第i个点的第一条边
            int []next = new int[m+1];//next[i]表示第i条边的下一条边
            int []to = new int[m+1];//to[i]表示第i条边的终点
            int []w = new int[m+1];//w[i]表示第i条边的权值
            int cnt = 0;
            for(int i=1;i<=n;i++){
                head[i]=-1;
            }
            for(int i=1;i<=m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int ww = sc.nextInt();
                next[cnt]=head[u];
                head[u]=cnt;
                to[cnt]=v;
                w[cnt]=ww;
                cnt++;
            }
            for(int i=1;i<=n;i++){
                for(int j=head[i];j!=-1;j=next[j]){
                    System.out.println(i+" "+to[j]+" "+w[j]);
                }
            }
        }
    }
}
