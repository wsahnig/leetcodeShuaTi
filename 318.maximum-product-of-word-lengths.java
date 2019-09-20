/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */
class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask=new int[len];
        for(int i=0;i<len;i++){
            mask[i] = createMask(words[i]);
        }
        int max = 0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i] & mask[j]) == 0){
                    max = Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return max;
    }
    private int createMask(String s){
        int mask = 0;
        for(char c:s.toCharArray()){
            mask |= 1 << (c-'a');
        }
        return mask;
    }
}

