import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return nums;
        int len = nums.length;
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> ((int) b - (int) a));

        int[] maxArr = new int[len-k+1];
        
        for(int i=0;i<k;i++)
          pq.add(nums[i]);
        maxArr[0] = pq.peek();
        for(int i=k;i<len;i++){
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            maxArr[i-k+1] = pq.peek();
        }

        return maxArr;
    }
}
// @lc code=end

