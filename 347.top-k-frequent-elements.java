import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */
class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i], 0)+1);
        }
        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
            (a,b)->(b.getValue()-a.getValue())
        );
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            heap.add(entry);
        }
        List<Integer> res = new ArrayList();

        while(k-- > 0){
            res.add(heap.poll().getKey());
        }
        return res;
        
    }
}

