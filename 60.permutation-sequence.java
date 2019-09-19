/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    int []visit;
    int m;
    ArrayList<String> list = new ArrayList();
    void dfs(int n,String s){
        if(n == m){
            list.add(new String(s));
        }
        for(int i=1;i<=m;i++){
            if(visit[i] == 0){
                visit[i] = 1;
                dfs(n+1,s+i);
                visit[i] = 0;
            }
        }
    }
    public String getPermutation(int n, int k) {
        m = n;
        visit = new int[n+1];
        String s = "";
        if(n != 0)
           dfs(0,s);
        return list.get(k-1);
    }
}

