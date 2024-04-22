import java.util.HashSet;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs1 =new HashSet();
        for(Integer i : nums2) hs1.add(i);
        HashSet<Integer> hs2 = new HashSet();
        for(int i=0;i < nums1.length;i++){
            if(hs1.contains(nums1[i]))
               hs2.add(nums1[i]); 
        }
        int[] ans = new int[hs2.size()];
        int i = 0;
        for(Integer num : hs2) ans[i++] = num;
        return ans;
    }
}

