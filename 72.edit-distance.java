/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        int len1 = word1.length();
        int len2 = word2.length();
        //dis[0][n],n!=0,表示word1是空串；dis[n][0],n!=0,表示word2是空串
        
        int[][] dis = new int[len1+1][len2+1];
        for(int i = 1;i <= len1; i++)
             dis[i][0] = i;
        for(int i = 1;i <= len2; i++)
             dis[0][i] = i;

        for(int i = 1;i <= len1; i++)
           for(int j = 1;j <= len2; j++){
               int cost = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
               int insert = dis[i][j-1] + 1;
               int delete = dis[i-1][j] + 1;
               int substitute = dis[i-1][j-1] + cost;
               dis[i][j] = Math.min(Math.min(insert,delete),substitute);
           }
        
        return dis[len1][len2];   
    }
}

