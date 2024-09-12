/*
一个数组，将它分出两个不相邻的子数组
使得他们和最大。
 */
package com.study240717;

import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int []nums=new int[n];
            int []left=new int[n];
            int []right=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            left[0]=Math.max(nums[0],0);
            right[n-1]=Math.max(nums[n-1],0);
            for(int i=1;i<n;i++){
                left[i]=Math.max(left[i-1]+nums[i],nums[i]);
            }
            for(int i=n-2;i>=0;i--){
                right[i]=Math.max(right[i+1]+nums[i],nums[i]);
            }
            int tmp=0;

            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    tmp=Math.max(tmp,left[j]+right[i]);
                }
            }
            System.out.println(tmp);
        }
    }
}
