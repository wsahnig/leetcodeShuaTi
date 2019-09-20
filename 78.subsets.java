/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private void backtrack(List<Integer> list,int[] nums,int start){
        ans.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
          list.add(nums[i]);
          backtrack(list,nums,i+1);
          list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList(),nums,0);
        return ans;
    }
}

