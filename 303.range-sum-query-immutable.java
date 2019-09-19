<<<<<<< HEAD
/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */
class NumArray {

    public NumArray(int[] nums) {
        
    }
    
    public int sumRange(int i, int j) {
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

=======
/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */
class NumArray {
    private int[] array;
    public NumArray(int[] nums) {
        array = new int [nums.length];
        if(nums.length == 0) return;
        array[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            array[i] += array[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? array[j] : (array[j] - array[i-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0
