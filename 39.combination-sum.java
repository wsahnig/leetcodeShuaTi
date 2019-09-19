/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (47.05%)
 * Total Accepted:    313.7K
 * Total Submissions: 666.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
class Solution {
    public void backtrack(int[] candidates,List<List<Integer>> result,
    List<Integer> path,int remain,int curr){
         if(remain == 0){
             result.add(new ArrayList(path));
         }
         for(int i=curr;i<candidates.length;i++){
             if(remain - candidates[i] < 0){
                 return ;
             }
             path.add(candidates[i]);
             backtrack(candidates,result,path,remain - candidates[i],i);
             path.remove(path.size()-1);
         }
    }      
    

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

