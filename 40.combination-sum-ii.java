/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (40.80%)
 * Total Accepted:    211.8K
 * Total Submissions: 517.3K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    public void backtrack(int[] candidates,List<List<Integer>> result,
    List<Integer> path,int remain,int curr){
         if(remain == 0){
             if(result.indexOf(new ArrayList(path)) == -1)
             result.add(new ArrayList(path));
         }
         for(int i=curr;i<candidates.length;i++){
             if(remain - candidates[i] < 0){
                 return ;
             }
             path.add(candidates[i]);
             backtrack(candidates,result,path,remain - candidates[i],i+1);
             path.remove(path.size()-1);
         }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null){
            throw new NullPointerException("candidates cannot be null");
        }

        if(target <= 0){
            throw new IllegalArgumentException("target cannot be negative"); 
        }

        List<List<Integer>> result = new ArrayList();

        Arrays.sort(candidates);

        backtrack(candidates,result,new ArrayList<Integer>(),target,0);

        return result;
    }
}

