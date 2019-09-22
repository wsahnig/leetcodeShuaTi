import java.util.Arrays;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) return 0;
        int[] candy = new int[len];
        candy[0] = 1;
        for(int i=1;i<len;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
            else{
                candy[i] = 1;
                int j = i-1;
                while(j>=0 && ratings[j] > ratings[j+1] && candy[j] == candy[j+1]){
                     candy[j]++;
                     j--;
                }
            }
        }
        return Arrays.stream(candy).sum();
    }
}

