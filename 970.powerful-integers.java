/*
 * @lc app=leetcode id=970 lang=java
 *
 * [970] Powerful Integers
 */

// @lc code=start
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet();
        
        for(int i=1; i<bound; i*=x)
        {
            for(int j=1; j<bound; j*=y)
            {
                int sum = i+j;
                if(sum <= bound)
                {
                    ans.add(sum);
                }
                else break;
                if(y==1) break;
            }
            if(x==1)  break;  
        }
        return new ArrayList<Integer>(ans);
    }
}
// @lc code=end

