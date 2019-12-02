import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    class Building{
        int l,r,h;
        public Building(int l,int r,int h){
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0)
           return new ArrayList();
        List<List<Integer>> res = new ArrayList();
        //Sort with Max-Height, or sort with Max-Right-Index if having the same Height
        Queue<Building> pq = new PriorityQueue<>((a,b)->{
            if(a.h != b.h){
                return b.h - a.h;
            }else{
                return b.r - a.r;
            }
        });
        for(int[] b : buildings){
            //Check if the pq's Highest Building (right edge) is overlapped with the New Building (left edge)
			//Save all the height changes until the current pq's Hightest Building is overlapped with the New Building
            while(!pq.isEmpty() && pq.peek().r < b[0]){
                savePollRes(res,pq);
            }

            //If no building left, save the new buildings's upper-left point
            //Else If new building's height is higher than current highest building, save the result
            //If current highest building has the same left index, remove previous result
            if(pq.isEmpty()){
                res.add(Arrays.asList(b[0],b[2]));
            }
            else if(pq.peek().h < b[2]){
                 if(res.get(res.size()-1).get(0) == b[0]){
                     res.remove(res.size()-1);
                 }
                 res.add(Arrays.asList(b[0],b[2]));
            }
            pq.add(new Building(b[0],b[1],b[2]));
        }
        //Save all the result remain in the pq
        while(!pq.isEmpty()){
            savePollRes(res, pq);
        }
        return res;
    }

    private void savePollRes(List<List<Integer>> res,Queue<Building> pq){
         Building pre = pq.poll();
         Building crr = pq.peek();
         //Keep polling out buildings if pq is not empty and if the previous hightest building have larger right-index
        //If there's no building left, add the result with 0 height
        //Else add the result with the height of current highest building
         while(crr != null && pre.h >= crr.h && pre.r >= crr.r){
             pq.poll();
             crr = pq.peek();
         }
         if(crr == null) {
             res.add(Arrays.asList(pre.r,0));
         }else{
             res.add(Arrays.asList(pre.r,crr.h));
         }
    }
}
// @lc code=end

