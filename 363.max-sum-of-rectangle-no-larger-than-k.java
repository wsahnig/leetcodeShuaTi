/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int max = Integer.MIN_VALUE;
    
            for(int i=m-1;i>=0;i--){
                max = Math.max(maxSumSubSeq(matrix[i],k),max);
                for(int j=i-1;j>=0;j--){
                    for(int index=0;index<n;index++)
                        matrix[i][index] += matrix[j][index];
                    max = Math.max(maxSumSubSeq(matrix[i],k),max);
                }
            }
            return max;
        }
        
        private int maxSumSubSeq(int[] arr,int k){
            int len = arr.length;
            int sum = 0,max = Integer.MIN_VALUE;
            TreeSet<Integer> ts = new TreeSet<>();
            ts.add(0);
            for(int i=0;i<len;i++){
                sum += arr[i];
                Integer min = ts.ceiling(sum-k);
                if(min != null)
                  max = Math.max(sum-min,max);
                ts.add(sum);
            }
            return max;
        }
    
}
// @lc code=end

