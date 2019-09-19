/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode p = head.next, q = p.next;
        while(q!=null && q.next != null){
            if(p == q){
                q = head;
                while(p != q){
                    p = p.next;
                    q = q.next;
                }
                return q;
            }
            p = p.next;
            q = q.next.next;
        }
        return null;
    }
}

