/*
 * @lc app=leetcode id=478 lang=java
 *
 * [478] Generate Random Point in a Circle
 */

// @lc code=start
class Solution {
    private double r;
    
    private double x;
    
    private double y;
    
    public Solution(double radius, double x_center, double y_center) {
        r = radius; 
        x = x_center; 
        y = y_center;
    }
    
    public double[] randPoint() {
        while(true){
           double randx = (Math.random()*2 - 1) * r;
            
            double randy = (Math.random()*2 - 1) * r;
            
            if(Math.pow(randx,2)+Math.pow(randy,2) <= Math.pow(r,2))
                return new double[]{x+randx, y+randy};
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

