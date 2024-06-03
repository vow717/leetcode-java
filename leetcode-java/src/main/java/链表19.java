/*
要求:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。


思路分析:

辅助类 Counter：定义了一个内部类 Counter，它有一个成员变量 count，用于记录递归遍历时的节点位置。
递归删除节点 SSS：定义了一个递归方法 SSS，用于从链表末尾向前递归，计算节点位置并在适当时刻删除指定节点。
构造虚拟头节点：在 removeNthFromEnd 方法中构造了一个虚拟头节点 Head，方便处理删除头节点的情况。
启动递归：通过调用 SSS 方法启动递归，进行节点删除操作。
*/



// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
class Solution {
    // 内部类 Counter，用于计数
    class Counter {
        int count = 0; // 计数器变量
    }

    // 递归方法，用于移除倒数第 N 个节点
    public void SSS(ListNode pre, ListNode cur, Counter now, int n) {
        // 基本情况：如果当前节点为 null，增加计数并返回
        if (cur == null) {
            now.count++; // 计数器自增
            return;
        }

        // 递归调用：向前移动到链表末尾
        SSS(pre.next, cur.next, now, n);

        // 如果当前计数等于目标位置 n，则移除当前节点
        if (now.count == n)
            pre.next = cur.next; // 删除当前节点
        now.count++; // 计数自增
        return;
    }

    // 主方法：移除倒数第 N 个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Counter now = new Counter(); // 创建计数器对象
        ListNode Head = new ListNode(-1, head); // 创建虚拟头节点
        SSS(Head, head, now, n); // 调用递归方法
        return Head.next; // 返回处理后的链表
    }
}