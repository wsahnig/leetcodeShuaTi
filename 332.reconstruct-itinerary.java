import java.util.*;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */
class Solution {
    public static List<String> helper(String start,HashMap<String,PriorityQueue<String>> graph,
                               List<String> res,int n){
        if(graph.get(start) != null){
            PriorityQueue<String> tos = new PriorityQueue<String>(graph.get(start));
            while(tos.size()!=0){
                String to = tos.poll();
                res.add(to);
                graph.get(start).remove(to);
                helper(to,graph,res,n);
                if(res.size() == n){
                    return res;
                }
                res.remove(res.size()-1);
                graph.get(start).add(to);
            }
        }
        return res;
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> graph = new HashMap<String,PriorityQueue<String>>();
        int n=1;
        for(List l : tickets){
            String from = (String)l.get(0);
            String to = (String)l.get(1);
            if(graph.get(from) == null){
                graph.put(from,new PriorityQueue());
            }
            graph.get(from).add(to);
            n++;
        }
        
        List<String> res = new ArrayList();
        res.add("JFK");
        return helper("JFK",graph,res,n);
    }
}

