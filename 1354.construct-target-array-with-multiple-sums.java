/*
 * @lc app=leetcode id=1354 lang=java
 *
 * [1354] Construct Target Array With Multiple Sums
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] target) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});
        long sum = 0;
        for(int i=0; i<target.length; i++)
        {
            sum += target[i];
            pq.offer(target[i]);
        }
        while(pq.size()!=0)
        {
            int max = pq.poll();
            if(max == 1) return true;
            else{
            sum -= max;
            //if length is 2
            if(sum == 1) return true;
            else if(max < sum || sum == 0 || max % sum == 0) return false;
            max %= sum;   
            sum += max;
            pq.offer(max);
            }
            
        }
        return true;
    }
}
// @lc code=end

