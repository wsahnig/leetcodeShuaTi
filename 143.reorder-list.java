/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //find preMid
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2!=null){
            if(p2.next == null) break;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode preMid = p1;
        //reverse the second half
        ListNode curr = preMid.next,pre = null,next = null;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        preMid.next=pre;
        //reorder,,,insert a node into a list
        p1 = head;
        p2 = preMid.next;
        while(p1 != preMid){
            //before insert
            preMid.next = p2.next;//save p2's next
            next = p1.next;//save p1's next
            //insert p2 into the first half list
            p2.next = p1.next;
            p1.next = p2;
            //continue
            p1 = next;
            p2 = preMid.next;
        }
    }
}

