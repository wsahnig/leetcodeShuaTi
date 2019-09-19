/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */
class Solution {
    boolean[][] isPalindrome;
    List<List<String>> result;
    private void generate(String s){
        isPalindrome = new boolean[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            for(int j=i; j<s.length(); j++){
                isPalindrome[i][j] = 
                (s.charAt(i) == s.charAt(j) &&
                (j-i<=2 || isPalindrome[i+1][j-1]));
            }
        }
    }

    private void dfs(int index, String s,List<String> curr){
        if(index == s.length()) {
            result.add(new ArrayList(curr));
            return; // return 
        }
        for(int i = index; i< s.length(); i++){
            if(isPalindrome[index][i]) {
                curr.add(s.substring(index, i+1));
                dfs(i+1,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if(s == null || s.isEmpty()){
           return result;
        }
        generate(s);
        dfs(0,s,new ArrayList<>());
        return result;
    }
}

