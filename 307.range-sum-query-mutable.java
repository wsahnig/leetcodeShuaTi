/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */
class NumArray {
    private int[] tree;
    private int[] data;

    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        data = new int[nums.length];
        for(int i=0; i<data.length;i++){
            data[i] = nums[i];
        }
        this.tree = new int[data.length*4];
        buildSegmentTree(0,0,data.length-1);
    }
    //数组下标范围为left~right
    private void buildSegmentTree(int treeIndex,int left,int right){
        if(left == right){
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = 2*treeIndex + 1;
        int rightTreeIndex = 2*treeIndex + 2;
        int mid = left + (right - left) / 2;
        buildSegmentTree(leftTreeIndex,left,mid);
        buildSegmentTree(rightTreeIndex, mid+1, right);
        tree[treeIndex] = (tree[leftTreeIndex] + tree[rightTreeIndex]);

    }

    private void update(int treeIndex,int left,int right,int i,int val){
        if(left == right) {
            tree[treeIndex] = val;
            return;
        }
        int leftTreeIndex = 2*treeIndex + 1;
        int rightTreeIndex = 2*treeIndex + 2;
        int mid = left + (right - left) / 2;
        if(i <= mid){
            update(leftTreeIndex,left,mid,i,val);
        }else if(i >= mid+1){
            update(rightTreeIndex,mid+1,right,i,val);
        }
        //上面的update执行完，执行下面的这句
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }
    public void update(int i, int val) {
        data[i] = val;
        update(0,0,data.length-1,i,val);
    }

    private int query(int treeIndex,int left,int right,int qL,int qR){
        if(left == qL && right == qR){
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = treeIndex * 2 + 1;
        int rightTreeIndex = treeIndex * 2 + 2;
        if(qR <= mid){
            return query(leftTreeIndex,left,mid,qL,qR);
        }
        if(qL >= mid+1){
            return query(rightTreeIndex,mid+1,right,qL,qR);
        }
        int lSum = query(leftTreeIndex,left,mid,qL,mid);
        int rSum = query(rightTreeIndex,mid+1,right,mid+1,qR);
        return lSum+rSum;
    }
    
    public int sumRange(int i, int j) {
        return query(0,0,data.length-1,i,j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

