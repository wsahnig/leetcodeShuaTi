import java.util.HashMap;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.equals("") || str.equals("") || str.equals(" ")) return false;
        HashMap<Character,String> hm = new HashMap();
        String[] arr = str.split(" ");
        if(arr.length != pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            if(!hm.containsKey(pattern.charAt(i))){
                if(hm.values().contains(arr[i])) return false;
                hm.put(pattern.charAt(i),arr[i]);
            }
            else{
                if(!hm.get(pattern.charAt(i)).equals(arr[i])) return false;
            }
        }
        return true; 
    }
}

