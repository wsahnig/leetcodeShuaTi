<<<<<<< HEAD
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void backtrack(int[] nums,List<Integer> list,int start){
        if(!ans.contains(list)) ans.add(new ArrayList(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new ArrayList(),0);
        return ans;
    }
}
=======
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

