/*
区间DP
 */
package com.study240718;

import java.util.Scanner;

public class CuttingSticks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int L;
        while((L=sc.nextInt())!=0){
            int n=sc.nextInt();
            int[]arr=new int[n+2];
            arr[0]=0;
            arr[n+1]=L;
            for(int i=1;i<=n;i++){
                arr[i]=sc.nextInt();
            }
            int [][]dp=new int[n+2][n+2];
            //i为区间长度，l为起点
            for(int i=1;i<=n+1;i++){
                for(int l=0;l<=n+1;l++){
                    int r=l+i;
                    if(r>n+1)
                        break;
                    int min=Integer.MAX_VALUE;
                    for(int k=l+1;k<r;k++){
                        min=Math.min(dp[l][k]+dp[k][r]+arr[r]-arr[l],min);
                    }
                    if(i==1)
                        dp[l][r]=0;
                    else
                    dp[l][r]=min;
                }
            }
            System.out.println("The minimum cutting is"+dp[0][n+1]);
        }
    }
}
