/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
        return "";
        Map<Character,Integer> hm = new HashMap<>();
        for(char c:t.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        int left=0,minlen=Integer.MAX_VALUE,head=0;
        int cnt = t.length();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){//
                if(hm.get(c)>0) cnt--;
                hm.put(c,hm.get(c)-1);
            }
            while(cnt == 0){//
                if(i-left < minlen){
                    head = left;
                    minlen = i-left+1;
                }
                char c2 = s.charAt(left++);
                if(hm.containsKey(c2)){
                    hm.put(c2,hm.get(c2)+1);
                    if(hm.get(c2)>0) cnt++;
                }
            }
        }
        return minlen==Integer.MAX_VALUE ? "":s.substring(head,head+minlen);
    }
}
// @lc code=end

