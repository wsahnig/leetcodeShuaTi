/*
 * @lc app=leetcode id=1074 lang=java
 *
 * [1074] Number of Submatrices That Sum to Target
 */

// @lc code=start
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int result = 0;
        for(int i=0; i< matrix.length; i++)
        {
            result += subarraySum(matrix[i], target);
            for(int j=i+1; j<matrix.length; j++)
            {
                for(int k=0; k<matrix[0].length; k++)
                {
                    matrix[i][k] += matrix[j][k];
                }
                result += subarraySum(matrix[i], target);
                
            }
        }
        return result;
        
    }
    
    private int subarraySum(int[] nums, int k)
    {
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int ans = 0;
        preSum.put(0,1);
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            if(preSum.containsKey(sum - k))
            {
                ans += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
// @lc code=end

