/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    private ListNode partition(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null){
           if(fast.next == null){
               break;
           }
           slow = slow.next;
           fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;  
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head, pre = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public boolean areSame(ListNode p,ListNode q){
        while(p != null && q != null){
            if(p.val == q.val){
                p = p.next;
                q = q.next;
            }
            else return false;
        }      
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode p = partition(head);
        p = reverse(p);
        return areSame(head,p);
    }
}

