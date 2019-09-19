/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (30.61%)
 * Total Accepted:    776.4K
 * Total Submissions: 2.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r,l;
        r = new ListNode(0);
        l = r;    
        int k = 0;
        while(l1 != null || l2 != null){
            k = 0;
            if(l1 != null) {l.val += l1.val;l1 = l1.next;}
            if(l2 != null) {l.val += l2.val;l2 = l2.next;}            
            if(l.val >= 10) {l.val = l.val % 10;k = k + 1;}
            
            if(l1 != null || l2 != null || k != 0)           
            l.next =  new ListNode(k);
            
            l = l.next; 
                      
        } 
        return r;
    }
}

