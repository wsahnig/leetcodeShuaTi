import java.util.*;


/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<ArrayList<Integer>> pq = new PriorityQueue<ArrayList<Integer>>(
            (l1,l2) -> {
                return l1.get(0) + l1.get(1) - l2.get(0) - l2.get(1);
            }
        );
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0)
        return ans;
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                pq.add(list);
            }
        }
        while(k-- > 0 && !pq.isEmpty()){
            ans.add(pq.poll());
        }

        return ans;
    }
}

