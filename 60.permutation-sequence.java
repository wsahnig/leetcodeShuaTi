// /*
//  * @lc app=leetcode id=60 lang=java
//  *
//  * [60] Permutation Sequence
//  */
// class Solution {
//     int []visit;
//     int m;
//     ArrayList<String> list = new ArrayList();
//     void dfs(int n,String s){
//         if(n == m){
//             list.add(new String(s));
//         }
//         for(int i=1;i<=m;i++){
//             if(visit[i] == 0){
//                 visit[i] = 1;
//                 dfs(n+1,s+i);
//                 visit[i] = 0;
//             }
//         }
//     }
//     public String getPermutation(int n, int k) {
//         m = n;
//         visit = new int[n+1];
//         String s = "";
//         if(n != 0)
//            dfs(0,s);
//         return list.get(k-1);
//     }
// }

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> in = new ArrayList<>(n);
        int max =1;
        for(int i=1;i<=n;i++){
            in.add(i);
            max*=i;
        }
        StringBuilder res = new StringBuilder(n);
        getPermutation(in,max/n,res,k);
        return res.toString();
    }
    private void getPermutation(List<Integer> in,int max,StringBuilder res,int k){
        int index = k/max;
        k = k%max;
        if(k == 0){
            index -=1;
            k = max;
        }
        res.append(in.remove(index));
        if(in.size()>0)
        getPermutation(in,max/in.size(),res,k);
    }
}


