/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.04%)
 * Total Accepted:    362.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode p = head;
        int len=0;
        while(p != null){
            p = p.next;
            len ++;
        }
        if(n == len) return head.next;

        //len - n + 1;
        p = head;
        for(int i=1 ;i< len - n; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, pre = null;
        while(n > 1 && p != null)
        {
            p = p.next;
            n--;
        }
        ListNode q = head;
        while(p.next != null)
        {
            p = p.next;
            pre = q;
            q = q.next;
        }
        if(pre == null) return head.next;
        else pre.next = q.next;
        return head;
        
    }
}

