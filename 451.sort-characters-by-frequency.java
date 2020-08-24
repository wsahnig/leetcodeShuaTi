import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap();
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->
                (b.getValue()-a.getValue())
        );
        for(Map.Entry<Character,Integer> entry : hm.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()!=0){
            Map.Entry<Character,Integer> en = pq.poll();
            char ch = en.getKey();
            int num = en.getValue();
            for(int i=0;i<num;i++){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}
// @lc code=end

