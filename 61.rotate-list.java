/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode newHead = null;
        int cnt = 1;
        p = head;
        while(cnt++ < len-k){
            p = p.next;
        }
        newHead = p.next;
        p.next = null;
        p = newHead;
        while(p.next != null) p = p.next;
        p.next = head;
        return newHead;
    }
}

