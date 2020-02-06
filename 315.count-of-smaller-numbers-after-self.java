/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    //左边大于右边，左边部分的那个数以后的每个数的权值都加一。
    class Number{
        int value;
        int weight;
        int OriIdx;
        public Number(int v,int w,int o){
             this.value = v;
             this.weight = w;
             this.OriIdx = o;
        }
    }
    private static void merge(Number[]arr,int low,int mid,int hi){
        int l = low,r = mid+1;
        Number[] tmp = new Number[hi-low+1];
        int k = 0;
        int w = 0;
        while(l <= mid && r <= hi){
            if(arr[l].value > arr[r].value){
                tmp[k++] = arr[r++];
                w++;
            }
            else{
                arr[l].weight += w;
                tmp[k++] = arr[l++];
            }
        }
        while(l <= mid){
           arr[l].weight += w; 
           tmp[k++] = arr[l++];
        }
        while(r <= hi) tmp[k++] = arr[r++];
        for(int i=0;i<k;i++){
            arr[low+i] = tmp[i];
        }
    }
    
    private static void mergeSort(Number[] arr,int low,int hi){
        int mid = (low+hi) / 2;
        if(low < hi){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,hi);
            merge(arr,low,mid,hi);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> res = new ArrayList();
        if(nums == null || nums.length == 0) return res;
        int len = nums.length;
        Number[] arrs = new Number[len];
        for(int i=0;i<len;i++){
             arrs[i] = new Number(nums[i],0,i);
             res.add(0);
        }
        mergeSort(arrs, 0, len-1);
        for(Number num : arrs){
            res.set(num.OriIdx,num.weight);
        }
        return res;
    }
}
// @lc code=end

