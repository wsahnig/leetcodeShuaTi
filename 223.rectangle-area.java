/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C-A) * (D-B) + (G-E) * (H-F);
        if(C <= E || G <= A || F >= D || B >= H){
            return sum;
        }
        else{
            int[] x = new int[]{A,C,E,G};
            int[] y = new int[]{B,D,F,H};
            Arrays.sort(x);
            Arrays.sort(y);
            return sum - (x[2] - x[1]) * (y[2] - y[1]);
        }
    }
}

