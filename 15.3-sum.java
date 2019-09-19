import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.49%)
 * Total Accepted:    494.2K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i=0, j=0, k=0;

        for(i = 0 ; i < nums.length/2 ; i++){
             int tmp = nums[i] ;
             nums[i] = nums[nums.length-i-1];
             nums[nums.length-i-1] = tmp;
        }
        
        for( k= nums.length-1;k >=0;k--){
            for( i=0 ; i < k ; i++ ){
                for( j=i+1;j < k ;j++){
                      if(nums[i] + nums[j] + nums[k] <= 0) break;
                }
                if(j != k && nums[i] + nums[j] + nums[k] == 0){

                    List<Integer> l = new ArrayList();

                    l.add(nums[k]);                    
                    l.add(nums[j]);
                    l.add(nums[i]);

                    if(list.indexOf(l) == -1)
                    list.add(l);
                    
                }
            }
        }
        
        return list;
    }
}

