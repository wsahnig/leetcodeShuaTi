/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */
class Solution {
    public List<Integer> grayCode(int n) {
        int len = (int) Math.pow(2,n);
        List<Integer> ans = new ArrayList<Integer>(len);
        for(int i=0;i < len;i++){
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}

