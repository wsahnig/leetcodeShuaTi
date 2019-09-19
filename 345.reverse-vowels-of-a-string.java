/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */
class Solution {
    public String reverseVowels(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int low = 0 , high = len - 1;
        while(low < high){
            while(low < high && !"aAoOeEiIuU".contains(arr[low]+"")){
                low++;
            }
            while(high > low && !"aAoOeEiIuU".contains(arr[high]+"")){
                high--;
            }    
            if(low < high){
                char t = arr[low];
                arr[low++] = arr[high];
                arr[high--] = t;
            }         
        }
        return String.valueOf(arr);
    }
}

