/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(i > k){
                hs.remove(nums[i-k-1]);
            }
            if(!hs.add(nums[i])) return true;
        }
        return false;
    }
}

