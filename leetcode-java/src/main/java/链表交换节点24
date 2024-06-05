/*
要求：给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

思路分析
边界条件检查：首先检查链表是否为空或者只有一个节点，这种情况下无需交换，直接返回原链表。
虚拟头节点：创建一个虚拟头节点 Head，它的 next 指向实际的头节点。这样在处理链表头部交换时会更加简便。
辅助指针初始化：初始化辅助指针 dumy 为虚拟头节点，并设置 pre 和 cur 分别指向链表的前两个节点，方便后续的交换操作。
交换节点对：在 while 循环中，依次交换每对相邻节点：
更新 pre.next 指向 cur.next，断开 pre 和 cur 的链接。
更新 cur.next 指向 pre，完成 pre 和 cur 的交换。
更新 dumy.next 指向 cur，将交换后的节点对连接到前面已处理好的部分。
指针移动：交换完成后，移动 dumy、pre 和 cur 指针，准备处理下一对节点。
返回新链表头节点：最终返回虚拟头节点 Head 的 next，即交换后的新链表的头节点。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空或者只有一个节点，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 创建一个虚拟头节点，并将它的 next 指向当前链表的头节点
        ListNode Head = new ListNode(-1, head);
        // 初始化辅助指针 dumy 为虚拟头节点
        ListNode dumy = Head;
        // 初始化 pre 和 cur 指针，分别指向链表的前两个节点
        ListNode pre = head;
        ListNode cur = head.next;

        // 遍历链表，交换每对相邻节点
        while (cur != null) {
            // pre 指针的 next 指向 cur 的 next，断开 pre 和 cur 的链接
            pre.next = cur.next;
            // cur 指针的 next 指向 pre，实现 pre 和 cur 的交换
            cur.next = pre;
            // dumy 的 next 指向 cur，完成交换后前一个节点与当前节点的连接
            dumy.next = cur;

            // 移动 dumy 指针到下一对节点的前一个节点位置
            dumy = pre;
            // 移动 pre 指针到下一对节点的第一个节点位置
            pre = pre.next;
            // 移动 cur 指针到下一对节点的第二个节点位置，如果存在
            cur = pre == null ? null : pre.next;
        }

        // 返回新的头节点，即虚拟头节点的 next
        return Head.next;
    }
}
