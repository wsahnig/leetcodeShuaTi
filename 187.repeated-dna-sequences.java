/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> atLeastOnce = new HashSet<String>();
        Set<String> moreThanOnce = new HashSet<String>();
        for(int i=0;i<s.length()-9;i++){
            String sub = s.substring(i,i+10);
            if(!atLeastOnce.add(sub)){
                moreThanOnce.add(sub);
            }            
        }
        return new ArrayList(moreThanOnce);
    }
}

