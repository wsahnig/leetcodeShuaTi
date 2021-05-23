/*
 * @lc app=leetcode id=1642 lang=java
 *
 * [1642] Furthest Building You Can Reach
 */

// @lc code=start
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++)
        {
            int diff = heights[i+1]-heights[i];
            if(diff>0){
                queue.add(diff);
                if(queue.size()>ladders)
                {
                    bricks-=queue.poll();
                    if(bricks<0) return i;
                }
            }
        }
        return heights.length-1;
    }
}
// @lc code=end

