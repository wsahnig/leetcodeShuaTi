/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list =new ArrayList();
        for(Integer i : nums2) list.add(i);
        ArrayList<Integer> list2 =new ArrayList();
        for(int i=0;i < nums1.length;i++){
            if(list.contains(nums1[i]))
               list2.add(nums1[i]);
               list.remove((Integer)nums1[i]); 
        }
        int[] ans = new int[list2.size()];
        int i = 0;
        for(Integer num : list2) ans[i++] = num;
        return ans;
    }
}

