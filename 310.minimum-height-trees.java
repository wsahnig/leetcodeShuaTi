import java.util.Queue;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */
class Solution {
      
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,LinkedList<Integer>> graph = new HashMap();
        int[] indegree = new int[n];
        ArrayList<Integer> res = new ArrayList();
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0){
            res.add(0);
            return res;
        }
        for(int i=0;i<n;i++){
            graph.put(i,new LinkedList());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<n;i++){
            if(indegree[i] == 1) q.offer(i);
        }
        while(n > 2){
            int size = q.size();
            n-=size;
            for(int i=0;i<size;i++){
                int curr = q.poll();
                for(Integer nei : graph.get(curr)){
                    if(indegree[nei] == 1) continue;
                    indegree[nei]--;
                    if(indegree[nei] == 1) q.offer(nei);
                }
            }
        }

        while(!q.isEmpty()){
            res.add(q.poll());
        }

        return res;
        
    }
}

