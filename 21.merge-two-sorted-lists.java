/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (46.13%)
 * Total Accepted:    529.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = null;
        if(l1 == null && l2 == null)
              return l;
        l=new ListNode(0);
        ListNode p = l;
        while(l1 != null || l2 != null){
            if( l1 != null && (l2 == null || l1.val <= l2.val) ){
                p.val = l1.val;
                l1=l1.next;           
            }
            else if( l2 != null && (l1 == null || l1.val > l2.val) ){
                p.val = l2.val;
                l2=l2.next;   
            }
            if(l1 != null || l2 != null){
                p.next = new ListNode(0);
            }
            p=p.next;  
        }
        return l; 
    }
}

