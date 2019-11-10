/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    private ListNode mergeList(ListNode l1,ListNode l2){
        ListNode h = new ListNode(0);
        ListNode p = h;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return h.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int N = lists.length;
        //bottom-top
        for(int sz=1;sz < N;sz+=sz){
            for(int lo=0;lo < N-sz;lo+=2*sz){
                lists[lo] = mergeList(lists[lo], lists[lo+sz]);
            }
        }
         
        return lists[0];
    }
}
// @lc code=end

