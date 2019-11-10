/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length==0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        
        Queue<Integer> pq = new PriorityQueue( (a,b) -> ((int)b-(int)a) );
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(matrix[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}
// @lc code=end

