/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] arr) {
        int MAX =Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i=0;i<n;i++){
            MAX = Math.max(arr[i], MAX);
            MIN = Math.min(arr[i], MIN);
        }
        if(n==1 || MIN == MAX){          
            return 0;
        }
        int max[] = new int[n+1];
        int min[] = new int[n+1];
        boolean hasNum[] = new boolean[n+1];
        for(int i=0;i<n+1;i++) {
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++) {
            int bucketNum = bucket(arr[i], n, MIN, MAX);
            max[bucketNum] = Math.max(max[bucketNum], arr[i]);
            min[bucketNum] = Math.min(min[bucketNum], arr[i]);
            hasNum[bucketNum] = true;
        }
        int res = 0;
        int lastMax = max[0];
        for(int i = 1;i<n+1;i++) {
            if(hasNum[i]) {
                res = Math.max(res,min[i]-lastMax );
                lastMax = max[i];
            }
        }
        return res;
    }
    public int bucket(long num,long len,long min, long max){
        return (int) ((num-min)*len/(max-min));
    }
}
// @lc code=end

