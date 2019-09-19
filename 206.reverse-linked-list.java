<<<<<<< HEAD
/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        
    }
}

=======
/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q;
        ListNode pre = null;
        if(p == null) return head;
        while(p.next != null){
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        p.next = pre;
        head = p;
        return head;
    }
}

>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0
