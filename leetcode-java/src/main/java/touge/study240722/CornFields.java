/*
题目描述:
农夫约翰有一个N*M的玉米田，他想要在这个玉米田中种植玉米。
玉米田中的每一块土地可以种植玉米也可以不种植玉米，但是约翰有一个习惯，他不会在相邻的两块土地中种植玉米。
现在约翰想要知道他一共有多少种种植玉米的方案。
 */
package com.study240722;

import java.util.Scanner;

public class CornFields {
    public static boolean OK(int a,int b){
        if((a|b)!=a) return false;
        if((b&(b<<1))!=0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[]arr=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i]=(arr[i]<<1)+sc.nextInt();
            }
        }

        int [][]dp=new int[13][1<<12];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j< 1<<12;j++){
                if(OK(arr[i],j)){
                    for(int k=0;k<1<<12;k++){
                        if((k&j)==0){
                            dp[i][j]+=dp[i-1][k];
                            dp[i][j]%=100000000;
                        }
                    }
                }
            }
        }
        int result=0;
        for(int j=0;j<1<<12;j++)
            result+=dp[n][j];
        System.out.println(result);
    }
}
