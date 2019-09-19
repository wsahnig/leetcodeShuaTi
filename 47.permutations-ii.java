<<<<<<< HEAD
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (39.76%)
 * Total Accepted:    233.3K
 * Total Submissions: 584.8K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public int []visit;
    public List<List<Integer>> ans = new ArrayList();

    public void dfs(int[] nums,int curr,List list){
       if(curr == nums.length){
           ans.add(new ArrayList(list));
           return;
       }
       for(int i=0;i<nums.length;i++){
           if(visit[i] == 1 || i>=1 && nums[i] == nums[i-1] && visit[i-1] == 1)
             continue;
            visit[i] = 1;
            if(list.size() <= curr) list.add(curr,nums[i]);
            else list.set(curr,nums[i]);
            dfs(nums,curr+1,list);
            visit[i] = 0;          
       }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        visit = new int[nums.length];
        if(nums.length != 0){
         List<Integer> list = new ArrayList();
         Arrays.sort(nums);
         dfs(nums,0,list);
        }
        return ans;
    }
}
=======
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

