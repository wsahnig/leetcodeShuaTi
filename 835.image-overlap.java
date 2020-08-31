/*
 * @lc app=leetcode id=835 lang=java
 *
 * [835] Image Overlap
 */

// @lc code=start
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        List<int[]> lista = new ArrayList<int[]>();
        List<int[]> listb = new ArrayList<int[]>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(A[i][j] == 1) {
                    lista.add(new int[]{i, j});
                }
                if(B[i][j] == 1) {
                    listb.add(new int[]{i, j});
                }
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(int[] pa: lista) {
            for(int[] pb: listb) {
                String slop = (pb[1] - pa[1]) + " " + (pb[0] - pa[0]);
                map.put(slop, map.getOrDefault(slop, 0) + 1);
            }
        }
        
        int max = 0;
        for(Integer it: map.values()) {
            max = Math.max(max, it);
        }
        return max;

    }
}
// @lc code=end

