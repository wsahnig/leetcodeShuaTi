/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0) return 0;
        for(int i=1;i<size;i++){
            int x = triangle.get(i).get(0) + triangle.get(i-1).get(0);
            triangle.get(i).set(0,x);
            x = triangle.get(i).get(i) + triangle.get(i-1).get(i-1);
            triangle.get(i).set(i,x);
        }
        for(int i=2;i<size;i++){
            for(int j=1;j<i;j++){
                 int y = triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1) 
                 , triangle.get(i-1).get(j));
                 triangle.get(i).set(j,y);
            }
        }
        int minTotal = triangle.get(size-1).get(0);
        for(int i=1;i<size;i++){
            if(minTotal > triangle.get(size-1).get(i))
            minTotal = triangle.get(size-1).get(i);
        }
        return minTotal;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0)return 0;
        for(int i= size-2;i>=0;i--){
            for(int j=0;j<=i;j++){
               int min = triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
               triangle.get(i).set(j,min); 
            }  
        }
        return triangle.get(0).get(0);
    }
}

