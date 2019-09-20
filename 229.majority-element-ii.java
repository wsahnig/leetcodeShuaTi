import java.util.ArrayList;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */
class Solution {
    //这样的数最多只有2个
    //且如果存在这样的数，3个数中至少有一个这样的数
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0,num2 = 0,cnt1 = 0,cnt2 = 0;
        Set<Integer> res = new HashSet<Integer>();
        int thre = nums.length / 3;
        for(int n : nums){
            if(num1 == n){
               cnt1++;  
            }else if(num2 == n){
               cnt2++;
            }else if(cnt1 == 0){
               num1 = n;
               cnt1++; 
            }else if(cnt2 == 0){
               num2 = n;
               cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int n:nums){
            if(n == num1) cnt1++;
            if(n == num2) cnt2++;
        }
        if(cnt1 > thre) res.add(num1);
        if(cnt2 > thre) res.add(num2);
        return new ArrayList(res);

    }
}

