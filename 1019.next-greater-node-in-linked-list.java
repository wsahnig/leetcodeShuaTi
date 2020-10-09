/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        int size = nums.size();
        int[] ans = new int[size];
        ans[size-1] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(nums.get(size-1));
        for(int i=size-2;i>=0;i--){
            
            int x = st.peek();
            while(x <= nums.get(i)){
                st.pop();
                if(!st.isEmpty())
                x = st.peek();
                else break;
            }
            if(st.isEmpty()) ans[i]=0;
            else ans[i]=x;
            st.push(nums.get(i));
            
        }
        return ans;
    }
}
// @lc code=end

