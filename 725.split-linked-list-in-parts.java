/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null || k == 0) 
        return new ListNode[k];
        ListNode p = root;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        int avelen = len / k;
        int add = len % k;
        ListNode[] listarr = new ListNode[k];
        p = root;
        int index = 0,cnt = 0;
        ListNode tmp;
        while(p != null){
            cnt = avelen;
            if(add != 0){
                cnt++;
                add--;
            }
            listarr[index++]=p;
            while(--cnt != 0){
                p = p.next;
            }
            // change list here
            tmp = p.next;
            p.next = null;
            p = tmp;          
        }
        return listarr;

    }
}
// @lc code=end

