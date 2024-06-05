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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode firstHead=new ListNode(-1,head);
        ListNode pre=firstHead;
        ListNode next=head;
        while(next!=null){
            if(next.val==val){
                pre.next=next.next;
            }
            else
                pre=pre.next;
            next=next.next;
        }
        return firstHead.next;
    }
}