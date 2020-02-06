import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     if(nums == null || nums.length == 0) return nums;
    //     int len = nums.length;
    //     Queue<Integer> pq = new PriorityQueue<>((a,b) -> ((int) b - (int) a));

    //     int[] maxArr = new int[len-k+1];
        
    //     for(int i=0;i<k;i++)
    //       pq.add(nums[i]);
    //     maxArr[0] = pq.peek();
    //     for(int i=k;i<len;i++){
    //         pq.remove(nums[i-k]);
    //         pq.add(nums[i]);
    //         maxArr[i-k+1] = pq.peek();
    //     }

    //     return maxArr;
    //  } 
    public  int[] maxSlidingWindow(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w > arr.length) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) { // 队尾出队规则
                queue.pollLast();
            }
            queue.addLast(i);    // 保存数组下标
            if (queue.peekFirst() == i - w) { // 队首出队规则
                queue.pollFirst();
            }
            if (i >= w - 1) { // i等于w-1时，出现第一个窗口
                res[index++] = arr[queue.peekFirst()];
            }
        }
        return res;
    }
      
}
// @lc code=end

