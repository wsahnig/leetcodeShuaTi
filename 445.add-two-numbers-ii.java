/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

// @lc code=start
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
        ListNode hNode=new ListNode(-1);
        Stack<Integer> st1 = new Stack();
        Stack<Integer> st2 = new Stack();
        ListNode p = l1;
        while(p != null){
            st1.push(p.val);
            p = p.next;
        }
        p = l2;
        while(p != null){
            st2.push(p.val);
            p = p.next;
        }
        int tmp = 0;
        int val = 0;
        while(!st1.isEmpty() && !st2.isEmpty()){
            val = st1.pop() + st2.pop() + tmp;
            tmp = val / 10;
            val = val % 10;
            ListNode l = new ListNode(val);
            l.next = hNode.next;
            hNode.next = l;
        }
        while(!st1.isEmpty()){
            val = st1.pop() + tmp;
            tmp = val / 10;
            val = val % 10;
            ListNode l = new ListNode(val);
            l.next = hNode.next;
            hNode.next = l;
        }
        while(!st2.isEmpty()){
            val = st2.pop() + tmp;
            tmp = val / 10;
            val = val % 10;
            ListNode l = new ListNode(val);
            l.next = hNode.next;
            hNode.next = l;
        }
        if(tmp == 1){
            ListNode l = new ListNode(1);
            l.next = hNode.next;
            hNode.next = l;
        }
        return hNode.next;

    }
}
// @lc code=end

