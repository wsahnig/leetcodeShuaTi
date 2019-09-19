/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.00%)
 * Total Accepted:    223.2K
 * Total Submissions: 742.1K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        int bottom = matrix.length-1;
        System.out.println(bottom);
        if(bottom < 0) return ans;
        int right = matrix[0].length-1,left = 0;
        int top = 0;
        
        while(top <= bottom && left <= right){
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            
            for(int i=top+1;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            if(top < bottom){
                for(int i=right-1;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
            }
            if(right > left){
                for(int i=bottom-1;i>top;i--){
                    ans.add(matrix[i][left]);
                }
            }            
            top++;
            bottom--;
            right--;
            left++;
        }
        return ans;
    }
}

