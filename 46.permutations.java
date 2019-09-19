<<<<<<< HEAD


/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (54.25%)
 * Total Accepted:    361.5K
 * Total Submissions: 664.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
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
           if(visit[i] == 0){
            visit[i] = 1;
            if(list.size() <= curr) list.add(curr,nums[i]);
            else list.set(curr,nums[i]);
            dfs(nums,curr+1,list);
            visit[i] = 0;
           }
       }
    }

    public List<List<Integer>> permute(int[] nums) {
        visit = new int[nums.length];
        if(nums.length != 0){
         List<Integer> list = new ArrayList();
         dfs(nums,0,list);
        }
        return ans;
    }
}
=======
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

