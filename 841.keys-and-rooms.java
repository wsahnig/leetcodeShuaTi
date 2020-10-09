/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {
    private void dfs(List<List<Integer>> rooms,boolean[] visited,int start){
        List<Integer> nums = rooms.get(start);
        int len = nums.size();
        for(int i=0;i<len;i++){
            int newStart = nums.get(i);
            if(!visited[newStart]){
                visited[newStart]=true;
                dfs(rooms,visited,newStart);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        visited[0]=true;
        dfs(rooms,visited,0);
        for(int i=0;i<size;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
// @lc code=end

