/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList2(ListNode head) {
        if(head == null) return head;
        ListNode p = head.next,pre = head;
        while(p != null){
            ListNode next = p.next;
            ListNode q = head;
            while(q.next != null && q.next != p && 
                     q.next.val < p.val){
                q = q.next;
            }
            if(q == head && q.val > p.val){
               pre.next = next;
               p.next = q;
               head = p;
            }
            else if(q.next != p){
                pre.next = next;
                p.next = q.next;
                q.next = p; 
            }
            else{
                pre = p;
            }
            p = next;
        }
        return head;
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode  p = head.next;
        ListNode pre = head;
        while(p != null){
           
           ListNode q = newHead;
           while(q.next != null && q.next != p && q.next.val < p.val){
                q = q.next;
           }
           //遍历结束后，q.next是不是就是第一个值大于p的节点或者就是p
           if(q.next != p){
               pre.next = p.next;
               p.next = q.next;
               q.next = p;
           }else{
               pre = p;
           }
           p = pre.next;
        }
        return newHead.next;
    }
}

