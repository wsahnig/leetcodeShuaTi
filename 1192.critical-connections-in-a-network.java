/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections){
        List<Integer>[] graph= new ArrayList[n];
        for(List<Integer> edge: connections){
            int v1= edge.get(0), v2= edge.get(1);
            if(graph[v1]== null) graph[v1]= new ArrayList<>();
            if(graph[v2]== null) graph[v2]= new ArrayList<>();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        int[] discovery= new int[n];
        int[] lowDiscovery= new int[n];
        int[] rank= new int[1];
        Arrays.fill(discovery,-1); 
        Arrays.fill(lowDiscovery,-1);
        List<List<Integer>> bridges= new ArrayList<>();
        dfs(0,-1,rank,discovery,lowDiscovery,graph,bridges);
        return bridges;
    }
    public void dfs(int node,int parent,int[] rank,int[] discovery,int[] lowDiscovery,
                   List<Integer>[] graph,List<List<Integer>> bridges){
        if(discovery[node]!=-1) return;
        discovery[node]= lowDiscovery[node]= rank[0]++;
        for(int neighbor: graph[node]){
            if(neighbor==parent) continue;
            dfs(neighbor,node,rank,discovery,lowDiscovery,graph,bridges);
            if(discovery[node]<lowDiscovery[neighbor]){
                bridges.add(Arrays.asList(node,neighbor));
            }else{
                lowDiscovery[node]= Math.min(lowDiscovery[node],lowDiscovery[neighbor]);
            }
        }
    }
}
// @lc code=end

