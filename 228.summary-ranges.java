/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class Solution {
    private void helper(List<String> res,int start,int end,int[] nums){
        String s = ""; 
        if(end == nums.length || nums[end] - nums[end-1] != 1){            
            if(end - start == 1){
                s += nums[end-1];
            }else{
                s = s + nums[start] + "->" + nums[end-1];
            }
            res.add(s);
            if(end == nums.length){
                return ;
            }
            helper(res,end,end+1,nums);
        }else{
            helper(res,start,end+1,nums);
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums.length == 0) return ans;
        helper(ans,0,1,nums);
        return ans;
    }
}

