/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode lastOdd = head;
        ListNode firstEven = head.next;
        
        while(lastOdd.next != null && lastOdd.next.next != null){
            ListNode t = lastOdd.next;
            lastOdd.next = t.next;
            t.next = t.next.next;
            lastOdd = lastOdd.next;
        }
        
        lastOdd.next = firstEven;
        return head;
    }
}

