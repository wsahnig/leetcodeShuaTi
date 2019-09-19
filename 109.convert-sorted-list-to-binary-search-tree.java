/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (39.87%)
 * Total Accepted:    167.2K
 * Total Submissions: 419.4K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode findMiddleElement(ListNode head){
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        if(prevPtr != null){
            prevPtr.next = null;
        }

        return slowPtr;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        ListNode mid = findMiddleElement(head);

        TreeNode node = new TreeNode(mid.val);
        
        if(head == mid) {  
          return node;
        }

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        
        return node;
    }
}

