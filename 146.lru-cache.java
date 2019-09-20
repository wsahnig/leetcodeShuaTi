import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class LRUCache {
    private int cap;
    private Map<Integer,Integer> map = new LinkedHashMap();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.keySet().contains(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }
        else if(cap == map.size()){
            Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();          
        }
        map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

