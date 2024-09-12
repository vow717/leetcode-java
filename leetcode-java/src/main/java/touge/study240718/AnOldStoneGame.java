/*
Garsia-Wachs算法

描述有一个古老的石制游戏。
在游戏开始时，玩家在一条线上挑选n（1<=n<=50000）堆石头。
目标是按照以下规则将石头合并成一堆：在游戏的每一步，玩家都可以将两个相邻的石头合并成新的石头。
分数是新堆石头的数量。你需要编写一个程序来确定总分的最低值。
input输入包含多个测试用例。每个测试用例的第一行包含一个整数n，表示桩的数量。
以下n个整数描述了游戏开始时每堆石头的数量。最后一个测试用例后面跟着一个零。
输出对于每个测试用例，在一行中输出答案。你可以假设答案不会超过1000000000。
 */
package com.study240718;

import java.util.Scanner;

public class AnOldStoneGame {
    static int  INTMAX = Integer.MAX_VALUE;

    // Stone类代表一个石头堆，链表结构包含石头堆数量、前后指针
    static class Stone {
        int num;
        Stone next;
        Stone last;

        public Stone(int num, Stone next, Stone last) {
            this.num = num;
            this.next = next;
            this.last = last;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // 读取输入直到遇到0
        while ((n = sc.nextInt()) != 0) {
            int i;
            Stone header = new Stone(INTMAX, null, null); // 链表头，用INTMAX占位
            Stone last = header;

            // 初始化链表，将输入的石头堆加入链表
            for (i = 1; i <= n; i++) {
                int num = sc.nextInt();
                last.next = new Stone(num, null, last);
                last = last.next;
            }
            last.next = new Stone(INTMAX, null, last); // 链表尾，用INTMAX占位

            int result = 0; // 总得分初始化为0

            // 当石头堆数量大于1时，进行合并操作
            while (n > 1) {
                Stone pre = header;
                Stone now = pre.next;
                Stone next1 = now.next;
                Stone next2 = next1.next;

                // 遍历链表，找到合并位置
                while (next2 != null) {
                    // 如果当前石头堆比下下个石头堆小，进行合并
                    if (now.num < next2.num) {
                        n--; // 石头堆数量减1
                        result = result + now.num + next1.num; // 更新总得分

                        // 创建新的合并石头堆
                        Stone stone = new Stone(now.num + next1.num, null, null);
                        pre.next = next2;
                        next2.last = pre;

                        // 在链表中插入新的合并石头堆，保持链表有序
                        Stone up = pre;
                        while (up != null) {
                            if (up.num >= stone.num) {
                                up.next.last = stone;
                                stone.next = up.next;
                                up.next = stone;
                                stone.last = up;
                                break;
                            }
                            up = up.last;
                        }
                        break;
                    } else {
                        // 向前移动指针，继续寻找合并位置
                        pre = pre.next;
                        now = pre.next;
                        next1 = now.next;
                        next2 = next1.next;
                    }
                }
            }
            // 输出当前测试用例的最低得分
            System.out.println(result);
        }
    }
}