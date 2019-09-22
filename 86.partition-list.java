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
        ListNode pre = null;//p's pre
        ListNode gtxPre = null; // gtx's pre    
        ListNode gtx = null;
        if(p == null) return head;
        while(p!=null){
            if(p.val >= x){
               if(gtx == null){
                    gtx = p;
                    gtxPre = pre;
               }
               pre = p;
               p = p.next;
            }
            else if(p.val < x){ 
               if(gtx != null){ //need to adjust node's position
                    pre.next = p.next;
                    if(gtxPre != null){// gtx is not the head
                        gtxPre.next = p;
                    }
                    else{
                        head = p;
                    }
                    //摘下p，插入到gtx的前面
                    gtxPre = p;
                    p.next = gtx; 
               }else{
                   pre = p;
               }
               p = pre.next;
            }
        }
        return head;
    }
    public ListNode partition2(ListNode head, int x) {
        ListNode p = head;
        if(p == null) return head;
        ListNode lastMin = null;
        ListNode lastMax = null;ListNode firstMax = null;
        while(p!=null){
            if(p.val < x){
                 if(lastMin == null){
                     head = p;                     
                 }else{
                     lastMin.next = p;
                 }
                 lastMin = p;
            }
            else{
                 if(lastMax == null){
                     firstMax = p;
                 }else{
                     lastMax.next = p;
                 }
                 lastMax = p;
            }
            p = p.next;
        }
        if(lastMin != null)
        lastMin.next = firstMax;
        if(lastMax != null)
        lastMax.next = null;
        return head;
    }   
}

