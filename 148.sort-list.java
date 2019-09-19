/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //
        ListNode slow = head , fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        //
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(h2);
        //
        return merge(l1,l2);
    }

    ListNode merge(ListNode l1,ListNode l2){
        ListNode l = new ListNode(0) , p = l;
        while(l1 != null || l2 != null){
            if(l2 == null || (l1 != null && l1.val <= l2.val) ){
                p.next = l1;
                l1 = l1.next;
            }
            else if(l1 == null ||  (l2 != null && l1.val > l2.val) ){
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        return l.next; 
    }
}

