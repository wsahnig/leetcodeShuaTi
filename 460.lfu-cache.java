import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    private Queue<CacheBlock> pq ;
    private Map<Integer,CacheBlock> hm;
    private int timeStamp;
    private int capacity;
    class CacheBlock{
       int key;
       int value;
       int count;
       int timeStamp;
       public CacheBlock(int key,int value,int count,int timeStamp){
            this.key = key;
            this.value = value;
            this.count = count;
            this.timeStamp = timeStamp; //最近使用时间
             
       }
    }

    public LFUCache(int capacity) {
        pq =  new PriorityQueue<CacheBlock>((a,b)->{
            if(a.count != b.count){
                return a.count - b.count;
            }else{
                return a.timeStamp - b.timeStamp;
            }
        });
        
        hm = new HashMap();
        this.timeStamp = 0; 
        this.capacity = capacity;
    }
    
    private void updateCacheBlock(CacheBlock cb){
        if(cb == null) return;
        pq.remove(cb);
        cb.count++;
        cb.timeStamp = this.timeStamp++;
        pq.add(cb);
    }

    private void addCacheBlock(CacheBlock cb){
        if(!pq.isEmpty() && pq.size() == capacity){
            CacheBlock tmp = pq.poll();
            hm.remove(tmp.key);
        }
        pq.add(cb);
        hm.put(cb.key,cb);
    }

    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        CacheBlock cb = hm.get(key);
        updateCacheBlock(cb);
        return cb.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        CacheBlock cb = hm.get(key);
        if(cb == null){
            cb = new CacheBlock(key, value, 1, this.timeStamp);
            this.timeStamp++;
            addCacheBlock(cb);
        }else{
            cb.value = value;
            updateCacheBlock(cb);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

