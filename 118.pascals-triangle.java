/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (44.92%)
 * Total Accepted:    234.6K
 * Total Submissions: 522.2K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        if(numRows == 0) return ans;
        list.add(1);
        ans.add(list);
        if(numRows == 1){
            return ans;
        }
        for(int i=1; i < numRows; i++){
            list = new ArrayList();
            for(int j=0; j <= i;j++){
                int x = 0,y = 0;
                if(j-1 >= 0) x = ans.get(i-1).get(j-1);
                if(j < ans.get(i-1).size() ) y= ans.get(i-1).get(j);
                list.add(x+y);  
            }
            ans.add(list);
        }
        return ans;
    }
}

