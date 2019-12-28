/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */
class Solution {
    public int ladderLength(String s, String t, List<String> dic) {
        HashMap<String,ArrayList<String>> dict = new HashMap();
        for(String str : dic){
            int len = str.length();
            for(int i=0;i<len;i++){
                String sub = str.substring(0,i)+"*"+str.substring(i+1);
                ArrayList<String> value = dict.getOrDefault(sub,new ArrayList());    
                value.add(str);
                dict.put(sub,value);    
            }
        }
        Queue<String> q = new LinkedList();
        HashMap<String,Boolean> visited = new HashMap();
        visited.put(s,true);
        q.offer(s);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String cur = q.poll();
                for(int i=0;i<cur.length();i++){
                    String patt = cur.substring(0,i)+"*"+cur.substring(i+1);
                    ArrayList<String> neighbors = dict.get(patt);
                    if(neighbors != null){
                        for(String neighbor : neighbors){
                            if(!visited.containsKey(neighbor)){
                                q.offer(neighbor);
                                visited.put(neighbor,true);
                                if(neighbor.equals(t)){
                                    return level+1;
                                }
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

