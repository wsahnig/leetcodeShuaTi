/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode p = head.next;
        while(p != null && head.val == p.val){
            while(p != null && head.val == p.val){
                p = p.next;
            }
            head = p;
            if(p != null)
            p = p.next;
        }
        if(head == null || p == null) return head;
        ListNode pre = head;
        ListNode q = p.next;
        while(p != null && q != null){
            if(p.val == q.val){
                while(q != null && p.val == q.val){
                    q = q.next;
                }
                pre.next = q;
            }
            else{
                pre = p;
            }
            p = q;
            if(q != null)
            q = q.next;
        }
        return head;

    }
}

