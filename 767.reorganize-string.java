/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    class Count{
        char c;
        int size;
        public Count(char c,int size){
            this.c = c;
            this.size = size;
        }
    }
    
    public String reorganizeString(String S) {
        int len = S.length();
        Map<Character,Integer> hm = new HashMap<>();
        Queue<Count> q = new PriorityQueue<>((a,b)->b.size-a.size);
        for(char c : S.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> e : hm.entrySet()){
            Count c = new Count(e.getKey(),e.getValue());
            q.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        Count c1 = q.peek();
        int size = c1.size;
        if(size > (len+1)/2) return "";
        
        while(!q.isEmpty()){
            c1 = q.poll(); 
            sb.append(c1.c);
            c1.size--;
            if(!q.isEmpty()){
                Count c2 = q.poll();
                sb.append(c2.c);
                c2.size--;
                if(c1.size > 0)q.offer(c1);
                if(c2.size > 0)q.offer(c2);
            }       
                    
        }
        
        return sb.toString();
    }
}
// @lc code=end

