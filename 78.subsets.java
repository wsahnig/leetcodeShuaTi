/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class Solution {
    
    private void backtrack(List<Integer> list,int[] nums,int start,List<List<Integer>> ans){
        ans.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
          list.add(nums[i]);
          backtrack(list,nums,i+1,ans);
          list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(new ArrayList(),nums,0,ans);
        return ans;
    }
}

