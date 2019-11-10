import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    // ArrayList<Integer> list;
    PriorityQueue<Integer> lo ;
    PriorityQueue<Integer> hi ;
    /** initialize your data structure here. */
    public MedianFinder() {
        // list = new ArrayList();
        lo  = new PriorityQueue((a,b)->((int) b - (int) a));
        hi = new PriorityQueue();
    }
    
    public void addNum(int num) {
        //1、insertion sort
        // int i = 0;
        // for(i=list.size()-1;i>=0 && list.get(i) > num;i--);
        // list.add(i+1,num);
        //2、two heap
        lo.add(num);

        hi.add(lo.poll());

        if(lo.size() < hi.size()){
            lo.add(hi.poll());
        }

    }
    
    public double findMedian() {
        // 1、
        // int len = list.size();
        // if(len == 0) return 0;
        // int index = len / 2;
        // return (len & 1) == 1 ? list.get(index) : (list.get(index) + list.get(index-1)) * 0.5;
        //2、
        return lo.size() == hi.size() ? (lo.peek()+hi.peek()) * 0.5 : lo.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

