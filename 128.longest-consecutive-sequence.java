import java.util.Map;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {

    class Union{

        public int[] parent;
        public int[] size;
        public Union(int length){
            parent = new int[length];
            size = new int[length];
            for(int i=0;i<length;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return ;
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }

        public int findLongest(){
               int sizeMax = size[0];
               for(int i=1;i<size.length;i++){
                sizeMax = Math.max(sizeMax,size[i]);
               }
               return sizeMax;
        }
    }
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Union un = new Union(nums.length);
        Map<Integer,Integer> valToIndex = new HashMap<>();

        
        for(int i=0;i<nums.length;i++){
            if(valToIndex.containsKey(nums[i]))
               continue;

            if(valToIndex.containsKey(nums[i]-1)){
                un.union(i, valToIndex.get(nums[i]-1));
            }
            if(valToIndex.containsKey(nums[i]+1)){
                un.union(i, valToIndex.get(nums[i]+1));
            }
            valToIndex.put(nums[i],i);
        }

        return un.findLongest();
    }
}
// @lc code=end

