/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    
    public int maxPoints(int[][] points) {
        int max = 0,cnt = 0,same = 0;
        int n = points.length;
        if(n < 3) return n;
        for(int i=0;i<n;i++){
            cnt = 1;
            same = 0; 
            for(int j=i+1; j<n; j++){
                cnt=1;
                if(points[i][0]==points[j][0] &&
                points[i][1]==points[j][1]){
                    same++;
                    continue;
                }
                cnt++;
                long xdiff = points[i][0]-points[j][0];
                long ydiff = points[i][1]-points[j][1];
                for(int k=j+1; k<n; k++){
                    if(xdiff * (points[i][1] - points[k][1]) ==
                    ydiff * (points[i][0] - points[k][0])){
                          cnt++;
                    }
                }
                max = Math.max(max,cnt+same);           
            }
             max = Math.max(max,cnt+same);
            if(max > n / 2) return max;
        }
        return max;
    }
}
// @lc code=end

