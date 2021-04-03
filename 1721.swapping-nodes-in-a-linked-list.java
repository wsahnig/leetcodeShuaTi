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
// @lc code=start
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmp = head;
        
        while(k!=1 && tmp != null)
        {
            
            tmp = tmp.next;
            k--;
        }
        if(tmp == null)
        { //kth node not exists
            return head;
        }
        ListNode tmpswap = tmp;
        ListNode tmp2 = head;
        
        while(tmp.next != null)
        {
            tmp = tmp.next;
            
            tmp2 = tmp2.next;
        }
        int value = tmpswap.val;
        tmpswap.val = tmp2.val;
        tmp2.val = value;
        
        return head;  
    }
}
// @lc code=end

