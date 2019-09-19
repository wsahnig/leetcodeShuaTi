/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
class Solution {
    public static void adjustHeap(int[] nums,int pos,int end) {
		int tmp = nums[pos];
		int i = pos * 2 + 1;
		while(i <= end ) {			
			if(i < end && nums[i] < nums[i+1]) {				
			    i = i+1;			    
			}		
			if(tmp >= nums[i]) break;
			
			else {
				nums[pos] = nums[i];
				pos = i;
				i = pos * 2 + 1;
			}	
		}
		nums[pos] = tmp;
	}
	
    public int findKthLargest(int[] nums, int k) {
        int i=0,len = nums.length;
        //adjust to big root heap
	    for(i= len/2 -1;i>=0;i--) {
	    	adjustHeap(nums,i,len-1);
	    }
	    for(i = len-1;i>=len-k;i--) {
	    	int tmp = nums[0];
	    	nums[0] = nums[i];
	    	nums[i] = tmp;
	    	adjustHeap(nums,0,i-1);
        }
        return nums[i+1];
    }
}

