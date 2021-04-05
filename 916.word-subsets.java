/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 */

// @lc code=start
class Solution {
    private Map<Character, Integer> getCntMap(String b)
    {
          Map<Character,Integer> cnt = new HashMap<>();
            
            for(int i = 0;i < b.length(); i++)
            {
                char c = b.charAt(i);
                if(cnt.containsKey(c))
                {
                    cnt.put(c,cnt.get(c)+1);
                }
                else
                {
                    cnt.put(c,1);
                }
            }
        return cnt;
    }
    
    
    public List<String> wordSubsets(String[] A, String[] B) {
        Map<Character,Integer> maxCnt = new HashMap<>();
        for(String b : B)
        {
            Map<Character,Integer> cnt = getCntMap(b);
            for(Character ch : cnt.keySet())
            {
                int x = cnt.get(ch);
                if(maxCnt.containsKey(ch))
                {
                    if(maxCnt.get(ch) < x)
                    {
                        maxCnt.put(ch, x);
                    }
                }
                else
                {
                    maxCnt.put(ch, x);
                }
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String a : A)
        {
            Map<Character, Integer> cnt = getCntMap(a);
            
            
            boolean flag = true;
            for(Character ch : maxCnt.keySet())
            {
                if(!cnt.containsKey(ch) || maxCnt.get(ch)  > cnt.get(ch))
                {
                    flag = false;
                    continue;
                }
            }
            if(flag) ans.add(a);
        }
        return ans;
    }
}
// @lc code=end

