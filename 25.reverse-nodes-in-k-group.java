/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
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
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head),pre = dummy,cur = pre.next;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        while(len >= k){
            cur=pre.next;
            for(int i=1;i<k;i++){ 
                ListNode suc = cur.next;
                cur.next = suc.next;
                suc.next = pre.next;
                pre.next = suc;
            }
            pre = cur;
            len -= k;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        for(int i=0;i<k;i++){
            if(cur == null) return head;
            cur=cur.next;
        }
        ListNode newHead = reverse(head,cur);
        head.next=reverseKGroup(cur,k);
        return newHead;
    }
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode pre = null;
        while(head != tail){
            ListNode suc = head.next;
            head.next = pre;
            pre = head;
            head = suc;
        }
        return pre;
    }
}
// @lc code=end

