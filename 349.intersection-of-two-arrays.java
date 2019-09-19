import java.util.HashSet;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list =new ArrayList();
        for(Integer i : nums2) list.add(i);
        HashSet<Integer> set = new HashSet();
        for(int i=0;i < nums1.length;i++){
            if(list.contains(nums1[i]))
               set.add(nums1[i]); 
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(Integer num : set) ans[i++] = num;
        return ans; 
    }
}

