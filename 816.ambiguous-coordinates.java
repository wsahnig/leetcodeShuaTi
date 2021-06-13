/*
 * @lc app=leetcode id=816 lang=java
 *
 * [816] Ambiguous Coordinates
 */

// @lc code=start
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        s = s.substring(1, len-1);
        len -= 2;
        for(int i=0; i<len-1; i++)
        {
            String s1 = s.substring(0,i+1);
            String s2 = s.substring(i+1);
            List<String> l1 = addPoint(s1);
            if(l1.size() == 0) continue;
            List<String> l2 = addPoint(s2);
            if(l2.size() == 0) continue;
            for(String x : l1)
            {
                for(String y : l2)
                {
                    ans.add("(" + x + ", " + y + ")");
                }
            }
        }
        return ans;
    }
    
    private List<String> addPoint(String s)
    {
        List<String> list = new ArrayList<>();
        int len = s.length();
        if(len == 1)
        {
            list.add(s);
            return list;
        }
        else if(s.charAt(0) == '0')
        {
            if(s.charAt(len-1) == '0') return list;
            else
            {
                list.add("0." + s.substring(1));
                return list;
            }
        }
        else if(s.charAt(len-1) == '0')
        {
            list.add(s);
            return list;
        }
        else
        {
            for(int i=0; i<len-1; i++)
            {
                list.add(s.substring(0,i+1) + "." +s.substring(i+1));
            }
            list.add(s);
            return list;
        }
        
    }
}
// @lc code=end

