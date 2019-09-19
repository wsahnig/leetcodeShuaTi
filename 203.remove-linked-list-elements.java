/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
    public ListNode removeElements(ListNode head, int val) {
        if(head != null){
                while(head.val == val){
                    head = head.next;
                    if(head == null) return head;
                }
                ListNode p = head;
                while(p.next != null){
                    if(p.next.val == val){
                        p.next = p.next.next;
                    }
                    else{
                        p = p.next;
                    }
                }
        }
        return head;
    }
}

