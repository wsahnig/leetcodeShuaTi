/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
      Map<Integer, Integer> hm = new HashMap<>();
      for(List<Integer> list:wall){
          int sum=0;
          for(int i=0;i<list.size()-1;i++){
              sum+=list.get(i);
              hm.put(sum, hm.getOrDefault(sum, 0)+1);
          }
      }
      int max = 0;
      for(Integer i:hm.keySet())
      {
          max=Math.max(max,hm.get(i));
      }
      return wall.size()-max;
    }
}
// @lc code=end

