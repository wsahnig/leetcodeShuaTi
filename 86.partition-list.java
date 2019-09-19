/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode pre1 = null; // gtx's pre
        ListNode pre2 = null;// p's pre
        ListNode gtx = null;
        if(p == null) return head;
        while(p!=null){
            if(p.val >= x && gtx == null){
               gtx = p;
               pre1 = pre2;
            }
            else if(p.val < x){ 
               if(gtx != null){ //need to adjust node's position
                    pre2.next = p.next;
                    if(pre1 != null){// gtx is not the head
                       pre1.next = p;
                    }
                    else{
                        head = p;
                    }
                    pre1 = p;
                    p.next = gtx; 
               }
            }
            pre2 = p;
            if(p != null)
            p = p.next;
        }
        return head;
    }   
}

