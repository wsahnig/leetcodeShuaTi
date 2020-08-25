/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(),m = words.length,k;
        if (n == 0 || m == 0 || (k = words[0].length()) == 0)
            return res;
        int size = m*k;

        Map<String,Integer> dict = new HashMap<>();
        for(String word:words){
            dict.put(word,dict.getOrDefault(word,0)+1);
        }

        Map<String,Integer> curDict = new HashMap<>();
        for(int i=0;i+size <= n;i++){
            curDict.clear();
            int cnt=0;
            for(int j=i;j<i+size;j+=k){
                String sub = s.substring(j,j+k);
                curDict.put(sub,curDict.getOrDefault(sub,0)+1);
                if(!dict.containsKey(sub)){
                    continue;
                }
                if(curDict.get(sub) > dict.get(sub)){
                    continue;
                }
                cnt++;
            }
            if(cnt == m){
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

