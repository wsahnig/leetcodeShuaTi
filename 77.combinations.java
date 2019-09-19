/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void dfs(int s,int n,int k,List<Integer> list){
        if(k==0){
          ans.add(new ArrayList(list));
          return;
        }
        for(int i=s;i<=n-k+1;i++){
            list.add(i);
            dfs(i+1,n,k-1,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {    
        dfs(1,n,k,new ArrayList());
        return ans;
    }
}

