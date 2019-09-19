/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (45.70%)
 * Total Accepted:    318.4K
 * Total Submissions: 694.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
   
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String,List> hm = new HashMap<String,List>();
        for(String s:strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!hm.containsKey(key)) hm.put(key,new ArrayList());
            hm.get(key).add(s);
        }
        return new ArrayList(hm.values());
    }
}

