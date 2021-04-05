/*
 * @lc app=leetcode id=923 lang=java
 *
 * [923] 3Sum With Multiplicity
 */

// @lc code=start
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i< arr.length-2; i++)
        {
            int left = i+1;
            int right = arr.length - 1;
            while(left < right)
            {
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == target)
                {
                    int tmp = 0;
                    int l1=1;
                    while(left < right && arr[left] == arr[left+1])
                    {
                        l1++;
                        left++;
                    }
                    if(left == right)
                    {
                        l1 = l1*(l1-1)/2;
                    }
                    int l2=1;
                    while(right > left && arr[right] == arr[right-1])
                    {
                        l2++;
                        right--;
                    }
                    tmp = l1*l2;
                    ans += tmp;
                    if(ans >= 1000000007) ans %= 1000000007;
                    left++;
                    right--;
                }
                else if(sum < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

