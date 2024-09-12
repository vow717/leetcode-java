package com.study240719;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PaintPearls {
    public static void main(String[] args) {
        int i,j,n;
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            int []arr=new int [n];
            for(i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            //这一步时间复杂度为O(n^2)，
            //set用来存储颜色，set.add和set.clear的时间复杂度为O(1)
            HashSet set=new HashSet<>();
            //num是一个二维数组，num[i][j]表示从i到j的区间内有多少种颜色
            int [][]num=new int[n][n];
            for(i=0;i<n;i++){
                set.clear();
                set.add(arr[i]);
             for(j=i;j>=0;j--){
                 set.add(arr[j]);
                 num[j][i]=set.size();
             }
            }

            //dp[i]表示给1到i个珍珠染色最少花费
            int []dp=new int[n];
            for(i=0;i<n;i++){
                dp[i]=Integer.MAX_VALUE;
            }
            for(i=0;i<n;i++){
                for(j=0;j<=i;j++){
                    if(j==0){
                        dp[i]=Math.min(dp[i],num[j][i]*num[j][i]);
                    }else{
                        dp[i]=Math.min(dp[i],dp[j-1]+num[j][i]*num[j][i]);
                    }
                }
            }
            System.out.println(dp[n-1]);
        }
    }
}
